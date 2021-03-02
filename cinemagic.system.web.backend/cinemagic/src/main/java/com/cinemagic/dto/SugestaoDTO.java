package com.cinemagic.dto;

import java.io.Serializable;

import com.cinemagic.domain.Cliente;

public class SugestaoDTO implements Serializable{

private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String sugestao;
	private Cliente autor;
	
	public SugestaoDTO() {
		
	}

	public SugestaoDTO(Integer id, String sugestao, Cliente autor) {
		super();
		this.id = id;
		this.sugestao = sugestao;
		this.autor = autor;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSugestao() {
		return sugestao;
	}

	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}

	public Cliente getAutor() {
		return autor;
	}

	public void setAutor(Cliente autor) {
		this.autor = autor;
	}
	
	
}
