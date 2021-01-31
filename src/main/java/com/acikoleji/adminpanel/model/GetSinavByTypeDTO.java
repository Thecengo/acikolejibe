package com.acikoleji.adminpanel.model;

import java.util.List;

public class GetSinavByTypeDTO {
	
	private List<GetBySinavTypeStudentDTO> students;

	public GetSinavByTypeDTO(List<GetBySinavTypeStudentDTO> students) {
		this.students = students;
	}

	public List<GetBySinavTypeStudentDTO> getStudents() {
		return students;
	}

}
