package com.acikoleji.adminpanel.model;

import java.time.LocalDate;
import java.util.List;

public class StudentDTO extends BaseModelDTO{
	
	private static final long serialVersionUID = 5015526435495011017L;

	private String schoolName;
	private String sinif;
	private LocalDate birthDate;
	private String tcNo;
	private VeliDTO veli;
	private List<SınavDTO> sinavs;
	
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
	
	public VeliDTO getVeli() {
		return veli;
	}
	public void setVeli(VeliDTO veli) {
		this.veli = veli;
	}
	public List<SınavDTO> getSinavs() {
		return sinavs;
	}
	public void setSinavs(List<SınavDTO> sinavs) {
		this.sinavs = sinavs;
	}
	
	
	
}
