package com.abc.employeemanagement.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Map<String, String>> handleArgumentValidException(MethodArgumentNotValidException ex){
	public ResponseEntity<Object> handleArgumentValidException(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			errors.put(error.getField(), error.getDefaultMessage());
		});
		Map<String, Object> allErrors = new HashMap<>();
		allErrors.put("timeStamp", LocalDateTime.now());
		allErrors.put("errors", errors);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(allErrors);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex){
		return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
	}
}
