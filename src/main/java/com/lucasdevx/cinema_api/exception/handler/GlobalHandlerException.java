package com.lucasdevx.cinema_api.exception.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.lucasdevx.cinema_api.exception.ObjectNotFoundException;
import com.lucasdevx.cinema_api.exception.ResponseException;

@ControllerAdvice
public class GlobalHandlerException {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ResponseException> objectNotFoundException(ObjectNotFoundException ex, WebRequest request){
		String message = ex.getMessage();
		String details = request.getDescription(false);
		LocalDateTime timestamp = LocalDateTime.now();
		
		ResponseException response = new ResponseException(timestamp, message, details);
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseException> handleAllException(Exception ex , WebRequest request){
		String message = ex.getMessage();
		String details = request.getDescription(false);
		LocalDateTime timestamp = LocalDateTime.now();
		
		ResponseException response = new ResponseException(timestamp, message, details);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
}
