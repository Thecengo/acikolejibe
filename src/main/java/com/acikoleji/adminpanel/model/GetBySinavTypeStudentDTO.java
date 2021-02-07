package com.acikoleji.adminpanel.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GetBySinavTypeStudentDTO extends GetBySinavTypeBaseModelDTO{
	
	private static final long serialVersionUID = 5015526435495011017L;

	private String schoolName;
	private String sinif;
	private LocalDate birthDate;
	private String tcNo;
	private GetBySinavTypeVeliDTO veli;
	
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public String getSinif() {
		return sinif;
	}
	public void setSinif(String sinif) {
		this.sinif = sinif;
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
