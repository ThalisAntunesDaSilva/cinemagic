package com.cinemagic.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cinemagic.services.validation.ClienteInsert;

@ClienteInsert
public class ClienteNewDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	String nome;
	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "E-mail inválido")
	String email;
	@NotEmpty(message = "Preenchimento obrigatório")
	String senha;
	@NotNull
	Integer cidadeId;
	public ClienteNewDTO(){
		
	}
	public ClienteNewDTO(String nome, String email, String senha, Integer cidadeId) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.cidadeId = cidadeId;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getCidadeId() {
		return cidadeId;
	}
	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}
	
}
