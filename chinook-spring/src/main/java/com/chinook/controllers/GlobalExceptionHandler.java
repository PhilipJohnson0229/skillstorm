package com.chinook.controllers;



import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)//lets us specify what code will be returned back along with a reason string
	@ExceptionHandler(IllegalArgumentException.class)
	//@AfterThrowing(thowing = "e")
	public ErrorResponse illegalArgument(Exception e) 
	{
		return new ErrorResponse(e, e.getMessage());
	}
	
	
	class ErrorResponse
	{
		Throwable cause;
		String message;
		Date timeStamp;
		
		public ErrorResponse() {
			super();
			this.timeStamp = new Date();
			
			
		}

		public ErrorResponse(Throwable cause, String message) {
			super();
			this.cause = cause;
			this.message = message;
			this.timeStamp = new Date();
		}
		
		
		
		
	}
}
