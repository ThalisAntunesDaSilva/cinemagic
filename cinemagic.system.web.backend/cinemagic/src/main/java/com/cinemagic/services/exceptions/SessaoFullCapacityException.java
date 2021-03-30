package com.cinemagic.services.exceptions;

public class SessaoFullCapacityException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public SessaoFullCapacityException() {
		
	}
	
	public SessaoFullCapacityException(String message) {
		super(message);
	}
	
}
