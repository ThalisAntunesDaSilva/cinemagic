package com.cinemagic.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.cinemagic.services.validation.ClienteInsert;

@ClienteInsert
public class FilmeNewDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	String titulo;
	@NotEmpty(message = "Preenchimento obrigatório")
	String duracao;
	
	public FilmeNewDTO(){
		
	}
	
	public FilmeNewDTO(String titulo, String duracao) {
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
