package com.cinemagic.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CinemaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Integer cidadeId;
	List<Integer> salasId = new ArrayList<>();
	
	public CinemaDTO() {
		
	}

	public CinemaDTO(Integer id, String nome, Integer cidadeId, List<Integer> salasId) {
		super();
		this.id = id;
		this.nome = nome;
		this.cidadeId = cidadeId;
		this.salasId = salasId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

	public List<Integer> getSalasId() {
		return salasId;
	}

	public void setSalasId(List<Integer> salasId) {
		this.salasId = salasId;
	}
	
	
		
	
}
