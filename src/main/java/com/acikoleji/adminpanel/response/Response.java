package com.acikoleji.adminpanel.response;

import java.io.Serializable;

public abstract class Response implements Serializable{
	private static final long serialVersionUID = -3223130375353412923L;
	
	private String message;
	private boolean success;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
