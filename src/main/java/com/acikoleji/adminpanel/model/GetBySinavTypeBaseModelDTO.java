package com.acikoleji.adminpanel.model;

import java.io.Serializable;

public class GetBySinavTypeBaseModelDTO implements Serializable{

	private static final long serialVersionUID = 8550859622837347071L;
	
	private String name;
	private String telNo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	
}
