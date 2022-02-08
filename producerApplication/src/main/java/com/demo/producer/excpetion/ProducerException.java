package com.demo.producer.excpetion;

public class ProducerException  extends RuntimeException{
	
	public ProducerException() {
		super();
	}

	public ProducerException(String message) {
		super(message);
	}
	
	public ProducerException(String message, int status,String details) {
		super(details);
	}
}
