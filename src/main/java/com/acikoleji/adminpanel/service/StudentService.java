package com.acikoleji.adminpanel.service;

import java.util.List;

import com.acikoleji.adminpanel.model.StudentDTO;
import com.acikoleji.adminpanel.response.StudentResponse;

public interface StudentService {

	List<StudentDTO> getAll();
	StudentResponse create(StudentDTO student);
	StudentResponse update(StudentDTO student);
	StudentResponse delete(Long id);
	StudentResponse sinavaBasvuruYap(StudentDTO student);
	
}
