package com.demo.producer.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.demo.producer.controller.ProducerController;
import com.demo.producer.excpetion.ProducerException;
import com.demo.producer.service.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService {

	private static final Logger LOG = LogManager.getLogger(ProducerServiceImpl.class);
	
	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public void sendMessage(String message) {
		// send message to default Queue
	}

	@Override
	public void createDestinationWithMessage(String destinationName, String message) {
		try {
			jmsTemplate.convertAndSend(destinationName, message);
		} catch (JmsException exp) {
			LOG.error("Unreachable to destination : " +destinationName,exp.getMessage());
			throw new ProducerException("Unreachable to destination : " +destinationName);
		}

	}

	@Override
	public void createDestination(String destinationName) {
		// Create Queue/topic only without message
	}

}
