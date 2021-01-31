package com.acikoleji.adminpanel.model;

public class SinavOgrenciRelationDTO {
	
	private Long id;
	private StudentDTO student;
	private SınavDTO sinav;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public StudentDTO getStudent() {
		return student;
	}
	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	public SınavDTO getSinav() {
		return sinav;
	}
	public void setSinav(SınavDTO sinav) {
		this.sinav = sinav;
	}

	
}
