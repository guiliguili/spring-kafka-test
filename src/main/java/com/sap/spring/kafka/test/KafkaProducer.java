package com.sap.spring.kafka.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class KafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

	private final KafkaTemplate<String, String> kafkaTemplate;

	private final String topic;

	public KafkaProducer(final KafkaTemplate<String, String> kafkaTemplate, @Value("${test.topic}") final String topic)
	{
		this.kafkaTemplate = kafkaTemplate;
		this.topic = topic;
	}

	public void send(String key, String payload) {
		LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);
		kafkaTemplate.send(topic, key, payload);
	}
}
