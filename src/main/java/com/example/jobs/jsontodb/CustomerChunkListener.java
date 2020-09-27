package com.example.jobs.jsontodb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ChunkListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.stereotype.Component;

@Component
public class CustomerChunkListener implements ChunkListener {

	private static final Logger logger = LoggerFactory.getLogger(CustomerChunkListener.class);

	@Override
	public void beforeChunk(ChunkContext context) {
		logger.info("before chunk " + context);
	}

	@Override
	public void afterChunk(ChunkContext context) {
		logger.info("after chunk " + context);
	}

	@Override
	public void afterChunkError(ChunkContext context) {
		logger.info("after chunk error" + context);
	}

}
