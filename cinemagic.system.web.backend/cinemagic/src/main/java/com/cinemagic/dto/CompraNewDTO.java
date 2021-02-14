package com.cinemagic.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CompraNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer clienteId;
	private Integer sessaoId;
	private List<IngressoDTO> ingressos = new ArrayList<>();
	private Integer tipoPagamento;
	
	public CompraNewDTO() {
		
	}

	public CompraNewDTO(Integer clienteId,Integer sessaoId, List<IngressoDTO> ingressos,Integer tipoPagamento) {
		super();
		this.clienteId = clienteId;
		this.ingressos = ingressos;
		this.sessaoId = sessaoId;
		this.tipoPagamento = tipoPagamento;
	}

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public List<IngressoDTO> getIngressos() {
		return ingressos;
	}

	public void setIngressos(List<IngressoDTO> ingressos) {
		this.ingressos = ingressos;
	}

	public Integer getSessaoId() {
		return sessaoId;
	}

	public void setSessaoId(Integer sessaoId) {
		this.sessaoId = sessaoId;
	}

	public Integer getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(Integer tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	
	
	
}
