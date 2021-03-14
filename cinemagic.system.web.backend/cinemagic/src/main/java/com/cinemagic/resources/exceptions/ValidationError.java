package com.cinemagic.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardErr {
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> erros = new ArrayList<>();
	
	public ValidationError(Integer status, String message, Long timeStamp, Integer errorId, String error, String path) {
		super(status, message, timeStamp, errorId, error, path);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addErros(String fieldName, String messagem) {
		erros.add(new FieldMessage(fieldName,messagem));
	}
	
	
	
}
