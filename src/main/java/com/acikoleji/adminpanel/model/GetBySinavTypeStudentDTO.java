package com.acikoleji.adminpanel.model;

import java.util.Date;

public class GetBySinavTypeStudentDTO extends GetBySinavTypeBaseModelDTO{
	
	private static final long serialVersionUID = 5015526435495011017L;

	private String schoolName;
	private Date birthDate;
	private String tcNo;
	private GetBySinavTypeVeliDTO veli;
	
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getTcNo() {
		return tcNo;
	}
	public void setTcNo(String tcNo) {
		this.tcNo = tcNo;
	}
	public GetBySinavTypeVeliDTO getVeli() {
		return veli;
	}
	public void setVeli(GetBySinavTypeVeliDTO veli) {
		this.veli = veli;
	}
	
}
