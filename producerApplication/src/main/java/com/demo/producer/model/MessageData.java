package com.demo.producer.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@Entity
public class MessageData {

	@NotNull
    @Size(min = 1, max = 60)
	int id;
	String message;
	String custName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
}
