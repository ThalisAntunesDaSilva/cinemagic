package com.cinemagic.resources.exceptions;

import java.io.Serializable;

public class StandardErr implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer status;
	private Integer errorId;
	private String error;
	private String message;
	private Long timeStamp;
	private String path;
	public StandardErr(Integer status, String message, Long timeStamp,Integer errorId,String error,String path) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
		this.errorId = errorId;
		this.error = error;
		this.path = path;
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


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}
	
	
	
	
}
