package com.example.jobs.jsontodb;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableBatchProcessing
public class JsonToDbBatchJobConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	/**
	 * json file to db job
	 * 
	 * @param listener
	 * @param step1
	 * @return
	 */
	@Bean
	public Job jsonToDbJob(JobCompletionNotificationListener listener, Step step1) {
		// @formatter:off
		return jobBuilderFactory.get("jsonToDbJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.start(step1)
				//.next(step1)
				.build();
		// @formatter:on
	}

	/**
	 * Read json data from json file
	 */
	@Bean
	public JsonItemReader<Customer> customerItemReader() {
		// @formatter:off
		return new JsonItemReaderBuilder<Customer>()
                .jsonObjectReader(new JacksonJsonObjectReader<>(Customer.class))
                .resource(new ClassPathResource("customers-json.json"))
                .name("customerItemReader")
                .build();
		// @formatter:on

	}

	/**
	 * writing json record to database
	 * 
	 * @param dataSource
	 * @return
	 */
	@Bean
	public JdbcBatchItemWriter<Customer> customerItemWriter(DataSource dataSource) {
		// @formatter:off
		return new JdbcBatchItemWriterBuilder<Customer>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO customer (first_name, last_name, city, country) VALUES (:firstName, :lastName, :city, :country)")
				.dataSource(dataSource)
				.build();
		// @formatter:on

	}

	/**
	 * processing json record
	 */
	@Bean
	public CustomerItemProcessor customerItemProcessor() {
		return new CustomerItemProcessor();
	}

	@Bean
	public Step step1(JdbcBatchItemWriter<Customer> customerItemWriter) {
		// @formatter:off
		return stepBuilderFactory.get("step1")
				.<Customer, Customer>chunk(3)
				.reader(customerItemReader())
				.processor(customerItemProcessor())
				.writer(customerItemWriter).build();
		// @formatter:on
	}
}
