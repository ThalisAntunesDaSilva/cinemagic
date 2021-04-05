package com.cinemagic.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cinemagic.domain.Filme;

public class GeneroDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	private List<Filme> filmes = new ArrayList<>();

	public GeneroDTO() {

	}

	public GeneroDTO(Integer id, String descricao, List<Filme> filmes) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.filmes = filmes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}
	
	
}
