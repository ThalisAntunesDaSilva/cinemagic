package com.centertransmition.cinemagic.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Filme implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	String titulo;
	String urlFilme;
	@JsonFormat(pattern = "HH:mm")
	Date duracao;
	
	@ManyToOne
	@JoinColumn(name = "id_genero")
	Genero genero;
	
	@OneToMany(mappedBy = "filme")
	List<Atua> atuacoes = new ArrayList<>();
	
	
	public Filme() {
		
	}
	
	

	public Filme(Integer id, String titulo, String urlFilme, Date duracao,Genero genero) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.urlFilme = urlFilme;
		this.duracao = duracao;
		this.genero = genero;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUrlFilme() {
		return urlFilme;
	}

	public void setUrlFilme(String urlFilme) {
		this.urlFilme = urlFilme;
	}

	public Date getDuracao() {
		return duracao;
	}

	public void setDuracao(Date duracao) {
		this.duracao = duracao;
	}


	public Genero getGenero() {
		return genero;
	}



	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	


	public List<Atua> getAtuacoes() {
		return atuacoes;
	}



	public void setAtuacoes(List<Atua> atuacoes) {
		this.atuacoes = atuacoes;
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
		Filme other = (Filme) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
