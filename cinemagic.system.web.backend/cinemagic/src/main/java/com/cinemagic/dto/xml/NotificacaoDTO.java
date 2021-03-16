package com.cinemagic.dto.xml;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

@XmlRootElement(name = "transaction")
@XmlAccessorType(XmlAccessType.NONE)
public class NotificacaoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlElement
	private Date date;
	@XmlElement
	private Date lastEventDate;
	@XmlElement
	private String code;
	@XmlElement
	private String reference;
	@XmlElement
	private int type;
	@XmlElement
	private int status;
	@XmlElement
	private PaymentMethodDTO payment;
	@XmlElement
	private float grossAmount;
	@XmlElement
	private float discountAmount;
	@XmlElement
	private float feeAmount;
	@XmlElement
	private float netAmount;
	@XmlElement
	private Date escrowEndDate;
	@XmlElement
	private float extraAmount;
	@XmlElement
	private int installmentCount;
	@XmlElement
	private int itemCount;
	@XmlElementWrapper(name = "items")
	@XmlElement
	private Collection<Item> item;
	@XmlElement
	private SenderDTO sender;
	
	public NotificacaoDTO() {
		
	}

	
	public NotificacaoDTO(Date date, Date lastEventDate, String code, String reference, int type, int status,
			PaymentMethodDTO payment, float grossAmount, float discountAmount, float feeAmount, float netAmount,
			Date escrowEndDate, float extraAmount, int installmentCount, int itemCount, Collection<Item> item,
			SenderDTO sender) {
		super();
		this.date = date;
		this.lastEventDate = lastEventDate;
		this.code = code;
		this.reference = reference;
		this.type = type;
		this.status = status;
		this.payment = payment;
		this.grossAmount = grossAmount;
		this.discountAmount = discountAmount;
		this.feeAmount = feeAmount;
		this.netAmount = netAmount;
		this.escrowEndDate = escrowEndDate;
		this.extraAmount = extraAmount;
		this.installmentCount = installmentCount;
		this.itemCount = itemCount;
		this.item = item;
		this.sender = sender;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getLastEventDate() {
		return lastEventDate;
	}

	public void setLastEventDate(Date lastEventDate) {
		this.lastEventDate = lastEventDate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public PaymentMethodDTO getPayment() {
		return payment;
	}

	public void setPayment(PaymentMethodDTO payment) {
		this.payment = payment;
	}

	public float getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(float grossAmount) {
		this.grossAmount = grossAmount;
	}

	public float getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(float discountAmount) {
		this.discountAmount = discountAmount;
	}

	public float getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(float feeAmount) {
		this.feeAmount = feeAmount;
	}

	public float getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(float netAmount) {
		this.netAmount = netAmount;
	}

	public Date getEscrowEndDate() {
		return escrowEndDate;
	}

	public void setEscrowEndDate(Date escrowEndDate) {
		this.escrowEndDate = escrowEndDate;
	}

	public float getExtraAmount() {
		return extraAmount;
	}

	public void setExtraAmount(float extraAmount) {
		this.extraAmount = extraAmount;
	}

	public int getInstallmentCount() {
		return installmentCount;
	}

	public void setInstallmentCount(int installmentCount) {
		this.installmentCount = installmentCount;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public Collection<Item> getItem() {
		return item;
	}

	public void setItem(Collection<Item> item) {
		this.item = item;
	}

	public SenderDTO getSender() {
		return sender;
	}

	public void setSender(SenderDTO sender) {
		this.sender = sender;
	}
	
	
}
