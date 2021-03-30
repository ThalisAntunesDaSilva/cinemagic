package com.cinemagic.dto;

import java.io.Serializable;

import com.cinemagic.domain.Genero;

public class FilmeDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String titulo;
	private String duracao;
	private String pathImage;
	//novo
	private Genero genero;
	public FilmeDTO() {
		
	}

	public FilmeDTO(String titulo, String duracao,String pathImage, Genero genero) {
		super();
		this.titulo = titulo;
		this.duracao = duracao;
		this.pathImage = pathImage;
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

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	//novos
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	
	
	
}
