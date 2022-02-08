package com.demo.producer.service;

public interface ProducerService {
	
	public void sendMessage(String message);
	public void createDestination(String destinationName);
	public void createDestinationWithMessage(String destinationName,String message);

}
