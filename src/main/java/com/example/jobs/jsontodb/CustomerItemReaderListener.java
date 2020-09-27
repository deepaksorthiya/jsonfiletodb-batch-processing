package com.example.jobs.jsontodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerItemReaderListener implements ItemReadListener<Customer> {

	private static final Logger logger = LoggerFactory.getLogger(CustomerItemReaderListener.class);

	@Override
	public void beforeRead() {
		logger.info("beforeRead");
	}

	@Override
	public void afterRead(Customer item) {
		logger.info("afterRead");
	}

	@Override
	public void onReadError(Exception ex) {
		logger.info("onReadError");
	}
}
