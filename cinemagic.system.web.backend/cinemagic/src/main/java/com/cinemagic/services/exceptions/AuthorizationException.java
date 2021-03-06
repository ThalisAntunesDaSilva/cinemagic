package com.cinemagic.services.exceptions;

public class AuthorizationException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public AuthorizationException() {
		
	}
	public AuthorizationException(String message) {
		super(message);
	}
	
}
