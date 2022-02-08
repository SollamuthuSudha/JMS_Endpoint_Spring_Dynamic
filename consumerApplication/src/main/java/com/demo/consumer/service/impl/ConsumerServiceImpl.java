package com.demo.consumer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.demo.consumer.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private JmsTemplate jmsTemplate;

	public String readMessage(String queueName) {
		try {
			return jmsTemplate.receiveAndConvert(queueName).toString();
		} catch (JmsException ex) {
			return "FAIL";
		}
	}
}
