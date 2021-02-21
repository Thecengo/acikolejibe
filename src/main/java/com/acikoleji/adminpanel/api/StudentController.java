package com.acikoleji.adminpanel.api;

import java.time.LocalTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acikoleji.adminpanel.model.StudentDTO;
import com.acikoleji.adminpanel.request.RequstStudentApplication;
import com.acikoleji.adminpanel.response.ResponseStudentApplyed;
import com.acikoleji.adminpanel.response.StudentResponse;
import com.acikoleji.adminpanel.service.StudentService;

@RequestMapping("/student")
@RestController
public class StudentController {

	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}


	@GetMapping() 
	public List<StudentDTO> getAllStudents() {
		return studentService.getAll();
	}
	
	@GetMapping("/applied") 
	public List<ResponseStudentApplyed> getAppliedStudents(@RequestParam("tip") String type, @RequestParam("startTime") String startTime) {
		return studentService.findBySinavTypeAndSessionStartTime(type, LocalTime.parse(startTime));
	}

	@PostMapping
	public StudentResponse sinavaBasvuruYap(@RequestBody RequstStudentApplication studentDTO) {
		return studentService.sinavaBasvuruYap(studentDTO);
	}
}
