package com.acikoleji.adminpanel.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin  extends BaseEntity{

	private static final long serialVersionUID = -3289625067810330704L;

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
