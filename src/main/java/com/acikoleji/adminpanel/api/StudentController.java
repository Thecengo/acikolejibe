package com.acikoleji.adminpanel.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acikoleji.adminpanel.model.StudentDTO;
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

	@PostMapping
	public StudentResponse sinavaBasvuruYap(@RequestBody StudentDTO studentDTO) {
		return studentService.sinavaBasvuruYap(studentDTO);
	}
}
