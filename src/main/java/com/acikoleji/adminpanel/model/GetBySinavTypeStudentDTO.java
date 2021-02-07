package com.acikoleji.adminpanel.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GetBySinavTypeStudentDTO extends GetBySinavTypeBaseModelDTO{
	
	private static final long serialVersionUID = 5015526435495011017L;

	private String schoolName;
	private LocalDate birthDate;
	private String tcNo;
	private GetBySinavTypeVeliDTO veli;
	
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	@JsonFormat(pattern = "yyyy-MM-dd")
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
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
