package com.sap.spring.kafka.test;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

	private final CountDownLatch latch = new CountDownLatch(1);

	private String payload = null;

	@KafkaListener(topics = "${test.topic}")
	public void receive(ConsumerRecord<?, ?> consumerRecord) {
		LOGGER.info("received payload='{}'", consumerRecord.toString());
		setPayload(consumerRecord.toString());
		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

	public String getPayload() {
		return payload;
	}

	protected void setPayload(final String payload)
	{
		this.payload = payload;
	}
}
