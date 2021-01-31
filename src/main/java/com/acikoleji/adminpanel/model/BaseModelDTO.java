package com.acikoleji.adminpanel.model;

import java.io.Serializable;

public class BaseModelDTO implements Serializable{

	private static final long serialVersionUID = 8550859622837347071L;
	
	private Long id;
	private String name;
	private String telNo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
