package com.acikoleji.adminpanel.model;

import java.util.List;

public class VeliDTO extends BaseModelDTO{

	private static final long serialVersionUID = -5792289420337317914L;
	private List<StudentDTO> students;

	public List<StudentDTO> getStudents() {
		return students;
	}

	public void setStudents(List<StudentDTO> students) {
		this.students = students;
	}
	
	
}
