package com.sap.spring.kafka.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class KafkaApplication
{
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KafkaConfig.class);
		context.getBean(KafkaProducer.class).send("42", "test");
	}
}
