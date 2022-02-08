package com.demo.consumer.exception;

public class ConsumerException  extends RuntimeException{
	
	public ConsumerException() {
		super();
	}

	public ConsumerException(String message) {
		super(message);
	}
	
	public ConsumerException(String message, int status,String details) {
		super(details);
	}
}
