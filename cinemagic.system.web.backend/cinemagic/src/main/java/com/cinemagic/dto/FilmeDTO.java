package com.cinemagic.dto;

import java.io.Serializable;

public class FilmeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private String duracao;
	
	public FilmeDTO() {
		
	}

	public FilmeDTO(String titulo, String duracao) {
		super();
		this.titulo = titulo;
		this.duracao = duracao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
	
	
}
