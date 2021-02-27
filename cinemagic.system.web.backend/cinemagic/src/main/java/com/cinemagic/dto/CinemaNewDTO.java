package com.cinemagic.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CinemaNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Integer cidadeId;
	List<SalaDTO> salas = new ArrayList<>();
	public CinemaNewDTO() {
		
	}
	public CinemaNewDTO(String nome, Integer cidadeId, List<SalaDTO> salas) {
		super();
		this.nome = nome;
		this.cidadeId = cidadeId;
		this.salas = salas;
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
	public List<SalaDTO> getSalas() {
		return salas;
	}
	public void setSalas(List<SalaDTO> salas) {
		this.salas = salas;
	}
	
	
}
