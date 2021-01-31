package com.acikoleji.adminpanel.model;

public class AdminDTO  extends BaseModelDTO{

	private static final long serialVersionUID = 1349873314031808174L;

	private String password;
	
	private String mail;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
