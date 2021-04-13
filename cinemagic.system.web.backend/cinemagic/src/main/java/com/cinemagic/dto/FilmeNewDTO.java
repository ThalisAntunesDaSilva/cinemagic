package com.cinemagic.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.cinemagic.domain.Genero;




public class FilmeNewDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String titulo;
	@NotEmpty(message = "Preenchimento obrigatório")
	private String duracao;
	//novo
	private Genero genero;

	private List<GeneroDTO> generos = new ArrayList<>();

	
	public FilmeNewDTO(){
		
	}
	
	

	public FilmeNewDTO(String titulo, String duracao, List<GeneroDTO> generos) {
		super();
		this.titulo = titulo;
		this.duracao = duracao;
		this.generos = generos;
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

	public List<GeneroDTO> getGeneros() {
		return generos;
	}

	public void setGeneros(List<GeneroDTO> salas) {
		this.generos = salas;
	}
	
	
	public Genero getGenero() {
		return genero;
	}



	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
}
