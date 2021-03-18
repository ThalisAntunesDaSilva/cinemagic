package com.cinemagic.services.exceptions;

public class PromotionClosedException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PromotionClosedException() {
		
	}
	public PromotionClosedException(String message) {
		super(message);
	}
	
}
