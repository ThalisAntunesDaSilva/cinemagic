package com.cinemagic.dto.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShippingDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	@XmlElement
	private int type;
	@XmlElement
	private double cost;
	
	public ShippingDTO() {
		
	}

	public ShippingDTO(int type, double cost) {
		super();
		this.type = type;
		this.cost = cost;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	
}
