package com.cinemagic.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class GeneroNewDTO  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String descricao;
	
	

	public GeneroNewDTO(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
