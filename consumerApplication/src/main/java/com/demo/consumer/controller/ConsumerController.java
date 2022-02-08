package com.demo.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.consumer.service.ConsumerService;

@RestController
public class ConsumerController {

	@Autowired
	ConsumerService consumerService;

	@GetMapping("/{queuename}")
	public ResponseEntity<?> readMessage(@PathVariable("queuename") String queuename) {
		try {
			String message = consumerService.readMessage(queuename);
			return ResponseEntity.ok().body(message);
		} catch (Exception exp) {
			return ResponseEntity.ok().body("Error consuming message from Queue"+queuename);
		}
	}
}
