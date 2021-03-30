package com.cinemagic.dto.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paymentMethod")
@XmlAccessorType(XmlAccessType.FIELD)
public class PaymentMethodDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	@XmlElement
	private int type;
	@XmlElement
	private int code;
	
	public PaymentMethodDTO() {
		
	}

	public PaymentMethodDTO(int type, int code) {
		super();
		this.type = type;
		this.code = code;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
}
