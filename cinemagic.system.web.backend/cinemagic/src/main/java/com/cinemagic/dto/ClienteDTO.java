package com.cinemagic.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cinemagic.domain.Cidade;
import com.cinemagic.domain.Compra;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nome;
	private String email;
	private int pontos;
	private Cidade cidade;
	List<Compra> compras = new ArrayList<>();
	private String pathImage;
	
	public ClienteDTO() {
		
	}

	public ClienteDTO(Integer id, String nome, String email,int pontos, Cidade cidade,
			List<Compra> compras,String pathImage) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.pontos = pontos;
		this.cidade = cidade;
		this.compras = compras;
		this.pathImage = pathImage;
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


	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	
}
