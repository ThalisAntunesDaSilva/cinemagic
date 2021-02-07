package com.centertransmition.cinemagic.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Atua implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String papel;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "filme_id")
	private Filme filme;
	
	@ManyToOne
	@JoinColumn(name = "ator_id")
	private Ator ator;
	
	public Atua() {
		
	}
	
	public Atua(Integer id, String papel,Filme filme,Ator ator) {
		super();
		this.id = id;
		this.papel = papel;
		this.filme = filme;
		this.ator = ator;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}
	

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	
	public Ator getAtor() {
		return ator;
	}

	public void setAtor(Ator ator) {
		this.ator = ator;
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
		Atua other = (Atua) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
