package com.example.jobs.jsontodb;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerItemWriterListener implements ItemWriteListener<Customer> {

	private static final Logger logger = LoggerFactory.getLogger(CustomerItemWriterListener.class);

	@Override
	public void beforeWrite(List<? extends Customer> items) {
		logger.info("beforeWrite");
	}

	@Override
	public void afterWrite(List<? extends Customer> items) {
		logger.info("afterWrite");
	}

	@Override
	public void onWriteError(Exception exception, List<? extends Customer> items) {
		logger.info("onWriteError");
	}
}
