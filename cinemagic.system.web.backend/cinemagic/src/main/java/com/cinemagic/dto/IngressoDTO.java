package com.cinemagic.dto;

import java.io.Serializable;

public class IngressoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int quantidade;
	private Integer tipoIngresso;
	
	public IngressoDTO() {
		
	}
	

	public IngressoDTO(int quantidade, Integer tipoIngresso) {
		super();
		this.quantidade = quantidade;
		this.tipoIngresso = tipoIngresso;
	}


	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getTipoIngresso() {
		return tipoIngresso;
	}

	public void setTipoIngresso(Integer tipoIngresso) {
		this.tipoIngresso = tipoIngresso;
	}
	
	
	
	
}
