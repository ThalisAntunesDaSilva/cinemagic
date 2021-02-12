package com.cinemagic.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cinemagic.services.exceptions.ObjectNotFoundException;
import com.cinemagic.services.exceptions.SessaoClosedExcpetion;

@ControllerAdvice
public class ResourceHandlerExcpetion {

	@ExceptionHandler(value = ObjectNotFoundException.class)
	public ResponseEntity<StandardErr> ObjectNotFound(ObjectNotFoundException ex) {
		StandardErr err = new StandardErr(HttpStatus.NOT_FOUND.value(), ex.getMessage(),System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	
	@ExceptionHandler(value = SessaoClosedExcpetion.class)
	public ResponseEntity<StandardErr> sessaoClosed(SessaoClosedExcpetion ex){
		StandardErr err = new StandardErr(HttpStatus.NOT_FOUND.value(),ex.getMessage(),System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	

}
