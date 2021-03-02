package com.cinemagic.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.cinemagic.domain.Compra;
import com.cinemagic.domain.Endereco;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nome;
	private String email;
	private String cpf;
	private int pontos;
	private Endereco endereco;
	List<Compra> compras = new ArrayList<>();
	
	public ClienteDTO() {
		
	}

	public ClienteDTO(Integer id, String nome, String email, String cpf, int pontos, Endereco endereco,
			List<Compra> compras) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.pontos = pontos;
		this.endereco = endereco;
		this.compras = compras;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

}
