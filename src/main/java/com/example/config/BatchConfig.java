package com.example.config;

import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;

public class BatchConfig implements BatchConfigurer {

	@Autowired
	javax.sql.DataSource dataSource;

	@Autowired
	PlatformTransactionManager platformTransactionManager;

	@Override
	public PlatformTransactionManager getTransactionManager() throws Exception {
		return platformTransactionManager;
	}

	@Override
	public JobLauncher getJobLauncher() throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(getJobRepository());
		jobLauncher.afterPropertiesSet();
		return jobLauncher;
	}

	@Override
	public JobRepository getJobRepository() throws Exception {
		JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
		factory.setDataSource(dataSource);
		factory.setTransactionManager(getTransactionManager());
		factory.afterPropertiesSet();
		return factory.getObject();
	}

	@Override
	public JobExplorer getJobExplorer() throws Exception {
		JobExplorerFactoryBean jobExplorerFactoryBean = new JobExplorerFactoryBean();
		jobExplorerFactoryBean.setDataSource(this.dataSource);
		jobExplorerFactoryBean.afterPropertiesSet();
		return jobExplorerFactoryBean.getObject();
	}
}
