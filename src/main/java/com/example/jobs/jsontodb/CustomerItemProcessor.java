package com.example.jobs.jsontodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class CustomerItemProcessor implements ItemProcessor<Customer, Customer> {

	private static final Logger logger = LoggerFactory.getLogger(CustomerItemProcessor.class);

	@Override
	public Customer process(final Customer customer) throws Exception {
		// process record here
		logger.info("I will process the record here : ", customer);
		return customer;
	}

}
