package com.cinemagic.dto.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	@XmlElement
	private Integer id;
	@XmlElement
	private String description;
	@XmlElement
	private int quantity;
	@XmlElement
	private double amount;
	
	public ItemDTO() {
		
	}
	

	public ItemDTO(Integer id, String description, int quantity, double amount) {
		super();
		this.id = id;
		this.description = description;
		this.quantity = quantity;
		this.amount = amount;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
