package com.abc.employeemanagement.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException{

	private final HttpStatus status;
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(HttpStatus status, String message) {
		super();
		this.status = status;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	
	
	
	
	
}
