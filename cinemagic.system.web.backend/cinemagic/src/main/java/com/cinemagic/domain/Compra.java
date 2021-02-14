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

import com.cinemagic.domain.Enums.TipoIngresso;
import com.cinemagic.domain.Enums.TipoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Compra implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date instante;
	
	
	private Integer tipoPagamento;
	
	
	
	@OneToMany(mappedBy = "compra")
	private List<Ingresso> ingressos = new ArrayList<>();
	
	@ManyToOne()
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	public Compra() {
		
	}

	public Compra(Integer id, Date instante,Cliente cliente,TipoPagamento tipoPagamento) {
		super();
		this.id = id;
		this.instante = instante;
		this.cliente = cliente;
		this.tipoPagamento = tipoPagamento.getCod();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public double getValor() {
		double valor = 0;
		for(Ingresso i: ingressos) {
			if(i.getTipoIngresso() == TipoIngresso.INTEIRA) {
				valor += i.getSessao().getValorInteira();
			}
			else {
				valor += i.getSessao().getValorMeia();
			}
		}
		return valor;
		
	}
	
	


	

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

	public TipoPagamento getTipoPagamento() {
		return TipoPagamento.toEnum(tipoPagamento);
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento.getCod();
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
		Compra other = (Compra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
