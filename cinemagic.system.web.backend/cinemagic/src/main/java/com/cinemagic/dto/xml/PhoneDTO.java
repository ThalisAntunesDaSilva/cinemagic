package com.cinemagic.dto.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	@XmlElement
	private int areaCode;
	@XmlElement
	private Integer number;
	
	public PhoneDTO() {
		
	}

	public PhoneDTO(int areaCode, Integer number) {
		super();
		this.areaCode = areaCode;
		this.number = number;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
}
