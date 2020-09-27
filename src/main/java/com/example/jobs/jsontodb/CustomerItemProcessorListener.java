package com.example.jobs.jsontodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerItemProcessorListener implements ItemProcessListener<Customer, Customer> {

	private static final Logger logger = LoggerFactory.getLogger(CustomerItemProcessorListener.class);

	@Override
	public void beforeProcess(Customer item) {
		logger.info("beforeProcess");
	}

	@Override
	public void afterProcess(Customer item, Customer result) {
		logger.info("afterProcess");
	}

	@Override
	public void onProcessError(Customer item, Exception e) {
		logger.info("onProcessError");
	}

}
