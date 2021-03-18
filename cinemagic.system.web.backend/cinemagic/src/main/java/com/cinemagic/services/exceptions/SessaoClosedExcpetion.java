package com.cinemagic.services.exceptions;

public class SessaoClosedExcpetion extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public SessaoClosedExcpetion() {
		
	}
	public SessaoClosedExcpetion(String message) {
		super(message);
	}
	
}
