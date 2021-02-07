package com.acikoleji.adminpanel.model;

import java.io.Serializable;

public class HeaderCaroselDTO implements Serializable {
	private Long key;
	private String src;
	
	private String altText;

	
	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getAltText() {
		return altText;
	}

	public void setAltText(String altText) {
		this.altText = altText;
	}


}
