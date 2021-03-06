package com.cinemagic.domain;

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
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sessao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	
	@JsonFormat(pattern = "dd/MM/yyy HH:mm")
	private Date hora;
	
	private double valorInteira;
	private double valorMeia;
	private boolean sessaoEncerrada;
	
	private boolean trocaPorCupons;
	private int valorEmCupons;
	
	@ManyToOne
	@JoinColumn(name = "filme_id")
	private Filme filme;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sessao")
	private List<Ingresso> ingressos = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "sala_id")
	private Sala sala;
	
	public Sessao() {
		
	}

	public Sessao(Integer id, Date data, Date hora, double valorInteira, 
			double valorMeia,Filme filme,Sala sala) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.valorInteira = valorInteira;
		this.valorMeia = valorMeia;
		this.sessaoEncerrada = false;
		this.filme = filme;
		this.sala = sala;
		this.trocaPorCupons = false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public double getValorInteira() {
		return valorInteira;
	}

	public void setValorInteira(double valorInteira) {
		this.valorInteira = valorInteira;
	}

	public double getValorMeia() {
		return valorMeia;
	}

	public void setValorMeia(double valorMeia) {
		this.valorMeia = valorMeia;
	}

	public boolean isSessaoEncerrada() {
		return sessaoEncerrada;
	}
	

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public void setSessaoEncerrada(boolean sessaoEncerrada) {
		this.sessaoEncerrada = sessaoEncerrada;
	}
	
	

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}
	

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	
	
	public boolean isTrocaPorCupons() {
		return trocaPorCupons;
	}

	public void setTrocaPorCupons(boolean trocaPorCupons) {
		this.trocaPorCupons = trocaPorCupons;
	}

	public int getValorEmCupons() {
		return valorEmCupons;
	}

	public void setValorEmCupons(int valorEmCupons) {
		this.valorEmCupons = valorEmCupons;
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
		Sessao other = (Sessao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
