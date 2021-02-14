package com.acikoleji.adminpanel.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SınavDTO {

	private Long id;
	private String tipi;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate endDate;
	private List<StudentDTO> students; 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTipi() {
		return tipi;
	}
	public void setTipi(String tipi) {
		this.tipi = tipi;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public List<StudentDTO> getStudents() {
		return students;
	}
	public void setStudents(List<StudentDTO> students) {
		this.students = students;
	}
	
}
