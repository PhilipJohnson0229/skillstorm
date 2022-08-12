package com.InventoryManagement.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
//@ResponseStatus
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	//@AfterThrowing(throwing="e")
	public ErrorReponse illegalArgument(Exception e) {
		return new ErrorReponse(e.getClass(), e.getMessage());
	}

	// Data Transfer Object - data wrapper to transmit between client/server
	// NOT static class (concurrency issues/multithreading) -> so a nested inner class is perfect for this case
	//Look at OWASP top 10 going to need to live by this
	class ErrorReponse {
		private Class cause;
		private String message;
		private Date timestamp;

		public ErrorReponse() {
			super();
			this.timestamp = new Date();
		}

		public ErrorReponse(Class cause, String message) {
			this();
			this.cause = cause;
			this.message = message;
		}

		public Class getCause() {
			return cause;
		}

		public void setCause(Class cause) {
			this.cause = cause;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Date getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(Date timestamp) {
			this.timestamp = timestamp;
		}

	}

}