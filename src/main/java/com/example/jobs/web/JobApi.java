package com.example.jobs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobs")
public class JobApi {

	private static final Logger logger = LoggerFactory.getLogger(JobApi.class);

	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job jsonToDbJob;

	@Autowired
	PlatformTransactionManager platformTransactionManager;

	@GetMapping("run")
	public String startJob() throws Exception {
		System.out.println(platformTransactionManager);
		JobExecution execution = this.jobLauncher.run(jsonToDbJob, new JobParameters());
		logger.info("Job : ", execution);
		return "Job Completed";
	}

}
