package com.cinemagic.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cinemagic.domain.Enums.TipoIngresso;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ingresso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String codigoAssentoIngresso;
	
	private Integer tipoIngresso;
	
	@ManyToOne
	@JoinColumn(name = "sessao_id")
	private Sessao sessao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "compra_id")
	private Compra compra;
	
	public Ingresso() {
		
	}

	public Ingresso(Integer id, String codigoAssentoIngresso, 
			TipoIngresso tipoIngresso,Sessao sessao,Compra compra) {
		super();
		this.id = id;
		this.codigoAssentoIngresso = codigoAssentoIngresso;
		this.tipoIngresso = tipoIngresso.getCod();
		this.sessao = sessao;
		this.compra = compra;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoAssentoIngresso() {
		return codigoAssentoIngresso;
	}

	public void setCodigoAssentoIngresso(String codigoAssentoIngresso) {
		this.codigoAssentoIngresso = codigoAssentoIngresso;
	}

	public TipoIngresso getTipoIngresso() {
		return TipoIngresso.toEnum(tipoIngresso);
	}

	public void setTipoIngresso(TipoIngresso tipoIngresso) {
		this.tipoIngresso = tipoIngresso.getCod();
	}

	
	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	
	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingresso other = (Ingresso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
