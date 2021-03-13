package com.cinemagic.resources.exceptions;

public class StandardErr {

	private Integer status;
	private Integer errorId;
	private String message;
	private Long timeStamp;
	

	
	
	public StandardErr(Integer status, String message, Long timeStamp,Integer errorId) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
		this.errorId = errorId;
	}


	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}


	public Integer getErrorId() {
		return errorId;
	}


	public void setErrorId(Integer errorId) {
		this.errorId = errorId;
	}
	
	
	
	
}
