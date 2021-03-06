package com.cinemagic.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CinemaNewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Integer cidadeId;
	private String email;
	private String senha;
	List<SalaDTO> salas = new ArrayList<>();
	
	
	public CinemaNewDTO() {
		
	}
	public CinemaNewDTO(String nome, Integer cidadeId, String email,List<SalaDTO> salas,String senha) {
		super();
		this.nome = nome;
		this.cidadeId = cidadeId;
		this.email = email;
		this.salas = salas;
		this.senha = senha;
		
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
