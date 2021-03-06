package com.demo.producer.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.producer.model.MessageData;
import com.demo.producer.service.ProducerService;

@Validated
@RestController("/producer")
public class ProducerController {

	private static final Logger LOG = LogManager.getLogger(ProducerController.class);

	@Autowired
	ProducerService producerService;

	@PostMapping("/{queuename}/{message}")
	public ResponseEntity<?> sendMessage(@PathVariable("queuename") @Size(max = 10) String queuename,
			@PathVariable("message") @Size(max = 100) String messages) {
		LOG.info(" Publish Message to Queue : " + queuename);
		try {
			producerService.createDestinationWithMessage(queuename, messages);
			return ResponseEntity.ok().body("Sucesss");
		} catch (Exception exp) {
			LOG.error("Error sending message to queue : " + queuename, exp.getMessage());
			return ResponseEntity.ok().body(exp.getMessage());
		}
	}

}
