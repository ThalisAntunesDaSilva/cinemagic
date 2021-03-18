package com.centertransmition.cinemagic.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.centertransmition.cinemagic.services.expetions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExpetionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException ex){
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), ex.getMessage(),System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
}
