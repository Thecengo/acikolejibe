package com.acikoleji.adminpanel.service;

import java.time.LocalTime;
import java.util.List;

import com.acikoleji.adminpanel.model.StudentDTO;
import com.acikoleji.adminpanel.request.RequstStudentApplication;
import com.acikoleji.adminpanel.response.ResponseStudentApplyed;
import com.acikoleji.adminpanel.response.StudentResponse;

public interface StudentService {

	List<StudentDTO> getAll();
	List<ResponseStudentApplyed> findBySinavTypeAndSessionStartTime(String burs, LocalTime startTime);
	StudentResponse create(StudentDTO student);
	StudentResponse update(StudentDTO student);
	StudentResponse delete(Long id);
	StudentResponse sinavaBasvuruYap(RequstStudentApplication student);
	
}
