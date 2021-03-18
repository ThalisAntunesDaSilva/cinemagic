package com.cinemagic.dto.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "sender")
@XmlAccessorType(XmlAccessType.FIELD)
public class SenderDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	@XmlElement
	private String email;
	@XmlElement
	private String name;
	@XmlElement
	private PhoneDTO phone;
	
	public SenderDTO() {
		
	}

	public SenderDTO(String email, String name, PhoneDTO phone) {
		super();
		this.email = email;
		this.name = name;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PhoneDTO getPhone() {
		return phone;
	}

	public void setPhone(PhoneDTO phone) {
		this.phone = phone;
	}
	
}
