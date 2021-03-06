package com.cinemagic.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SessaoNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date data;
	@JsonFormat(pattern = "HH:mm")
	private Date hora;
	private double valorInteira;
	private double valorMeia;
	private boolean trocarCupons;
	private int valorEmCupons;
	private Integer filmeId;
	private Integer salaId;
	
	public SessaoNewDTO() {
		
	}
	public SessaoNewDTO(Date data, Date hora, double valorInteira, double valorMeia, boolean trocarCupons,
			int valorEmCupons, Integer filmeId,Integer salaId) {
		super();
		this.data = data;
		this.hora = hora;
		this.valorInteira = valorInteira;
		this.valorMeia = valorMeia;
		this.trocarCupons = trocarCupons;
		this.valorEmCupons = valorEmCupons;
		this.filmeId = filmeId;
		this.salaId = salaId;
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
	public boolean isTrocarCupons() {
		return trocarCupons;
	}
	public void setTrocarCupons(boolean trocarCupons) {
		this.trocarCupons = trocarCupons;
	}
	public int getValorEmCupons() {
		return valorEmCupons;
	}
	public void setValorEmCupons(int valorEmCupons) {
		this.valorEmCupons = valorEmCupons;
	}
	public Integer getFilmeId() {
		return filmeId;
	}
	public void setFilmeId(Integer filmeId) {
		this.filmeId = filmeId;
	}
	public Integer getSalaId() {
		return salaId;
	}
	public void setSalaId(Integer salaId) {
		this.salaId = salaId;
	}
	
	
	

}
