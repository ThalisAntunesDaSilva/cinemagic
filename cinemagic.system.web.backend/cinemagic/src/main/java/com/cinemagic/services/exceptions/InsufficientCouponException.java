package com.cinemagic.services.exceptions;

public class InsufficientCouponException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public InsufficientCouponException() {
		
	}
	public InsufficientCouponException(String message) {
		super(message);
	}
	
}
