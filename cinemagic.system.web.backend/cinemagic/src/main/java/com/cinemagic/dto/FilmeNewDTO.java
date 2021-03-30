package com.cinemagic.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.cinemagic.domain.Genero;



public class FilmeNewDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	String titulo;
	@NotEmpty(message = "Preenchimento obrigatório")
	String duracao;
	//novo
	Genero genero;
	
	public FilmeNewDTO(){
		
	}
	
	public FilmeNewDTO(String titulo, String duracao, Genero genero) {
		super();
		this.titulo = titulo;
		this.duracao = duracao;
		this.genero = genero;
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

	//novo
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	

	
	
	
	
	
	

}
