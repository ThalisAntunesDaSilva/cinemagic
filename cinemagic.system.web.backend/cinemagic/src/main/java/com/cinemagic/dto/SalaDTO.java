package com.cinemagic.dto;

import java.io.Serializable;

public class SalaDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private int numero;
	private int capacidade;
	
	public SalaDTO() {
		
	}
	public SalaDTO(int numero, int capacidade) {
		super();
		this.numero = numero;
		this.capacidade = capacidade;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	
	
	
}
