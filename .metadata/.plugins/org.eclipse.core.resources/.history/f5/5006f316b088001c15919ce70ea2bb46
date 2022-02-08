package com.demo.producer.excpetion;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		List<String> errors = new ArrayList<String>();
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			errors.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": "
					+ violation.getMessage());
		}

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler({ ProducerException.class })
	public ResponseEntity<Object> handleExceptions(Exception exp, WebRequest req) {
		if (exp instanceof ProducerException) {
			return buildErrorResponse(HttpStatus.BAD_REQUEST, exp.getMessage(), exp);
		}
		return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exp.getMessage(), exp);

	}

	public ResponseEntity<Object> buildErrorResponse(HttpStatus status, String message, Exception exp) {
		return ResponseEntity.status(status).body((Object) new ApiError(status, message, exp.getMessage()));
	}

}
