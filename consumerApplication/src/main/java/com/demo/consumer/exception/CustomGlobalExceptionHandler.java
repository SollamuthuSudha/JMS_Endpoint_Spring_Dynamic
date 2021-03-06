package com.demo.consumer.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleExceptions(Exception exp, WebRequest req) {
		if (exp instanceof ConsumerException) {
			return buildErrorResponse(HttpStatus.BAD_REQUEST, exp.getMessage(), exp);
		}
		return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exp.getMessage(), exp);

	}

	public ResponseEntity<Object> buildErrorResponse(HttpStatus status, String message, Exception exp) {
		return ResponseEntity.status(status).body((Object) new ApiError(status, message, exp.getMessage()));
	}

}
