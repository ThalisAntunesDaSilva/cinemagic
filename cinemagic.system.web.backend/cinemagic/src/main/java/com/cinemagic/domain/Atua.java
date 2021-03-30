package com.cinemagic.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Atua implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String papel;
	
	@ManyToOne
	@JoinColumn(name = "ator_id")
	private Ator ator;
	
	@ManyToOne
	@JoinColumn(name = "filme_id")
	private Filme filme;
	
	public Atua() {
		
	}

	
	public Atua(Integer id, String papel,Ator ator,Filme filme) {
		super();
		this.id = id;
		this.papel = papel;
		this.ator = ator;
		this.filme = filme;
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


	public Ator getAtor() {
		return ator;
	}


	public void setAtor(Ator ator) {
		this.ator = ator;
	}


	public Filme getFilme() {
		return filme;
	}


	public void setFilme(Filme filme) {
		this.filme = filme;
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
