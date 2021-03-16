package com.cinemagic.dto.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "checkout")
@XmlAccessorType(XmlAccessType.NONE)
public class CheckoutDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@XmlElement
	private String code;
	@XmlElement
	private String date;
	
	public CheckoutDTO(){
		
	}

	public CheckoutDTO(String code, String date) {
		super();
		this.code = code;
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
