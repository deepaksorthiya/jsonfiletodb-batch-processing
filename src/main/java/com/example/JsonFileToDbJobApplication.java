package com.example;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.PlatformTransactionManager;

@SpringBootApplication
public class JsonFileToDbJobApplication implements CommandLineRunner {

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job jsonToDbJob;

	@Autowired
	PlatformTransactionManager transactionManager;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(JsonFileToDbJobApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(transactionManager);
		JobExecution execution = this.jobLauncher.run(jsonToDbJob, new JobParameters());
		System.out.println(execution);
	}
}
