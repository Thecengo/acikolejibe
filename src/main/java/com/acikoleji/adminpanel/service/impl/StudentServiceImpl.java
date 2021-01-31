package com.acikoleji.adminpanel.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.acikoleji.adminpanel.entity.Student;
import com.acikoleji.adminpanel.entity.Sınav;
import com.acikoleji.adminpanel.model.StudentDTO;
import com.acikoleji.adminpanel.repository.SinavRepository;
import com.acikoleji.adminpanel.repository.StudentRepository;
import com.acikoleji.adminpanel.response.StudentResponse;
import com.acikoleji.adminpanel.service.SinavService;
import com.acikoleji.adminpanel.service.StudentService;
import com.acikoleji.adminpanel.util.CheckUtils;
import com.acikoleji.adminpanel.util.MapperUtils;


@Transactional
@Service
public class StudentServiceImpl implements StudentService {

	private final StudentRepository studentRepository;

	private final SinavService sinavService;

	private final SinavRepository sinavRepository;

	public StudentServiceImpl(StudentRepository studentRepository, SinavService sinavService, SinavRepository sinavRepository) {
		this.studentRepository = studentRepository;
		this.sinavService = sinavService;
		this.sinavRepository = sinavRepository;
	}

	@Override
	public List<StudentDTO> getAll() {
		List<Student> findAll = studentRepository.findAll();
		List<StudentDTO> studentDtos = new ArrayList<>();
		for (Student student : findAll) {
			studentDtos.add(MapperUtils.mapToStudentDTO(student));
		}
		return studentDtos;
	}

	@Override
	public StudentResponse create(StudentDTO student) {
		return null;
	}

	@Override
	public StudentResponse update(StudentDTO student) {
		return null;
	}

	@Override
	public StudentResponse delete(Long id) {
		return null;
	}
	
	@Override
	public StudentResponse sinavaBasvuruYap(StudentDTO studentDTO) {
		StudentResponse studentResponse = new StudentResponse();
		if (CheckUtils.isNotNull(studentDTO)) {
			List<Sınav> activeExamns = sinavService.findActiveSinav(new Date());
			if (CheckUtils.isNotEmpty(activeExamns)) {
				if (!activeExamns.isEmpty()) {
				    Sınav sınav = activeExamns.get(0);
					sınav.getStudents().add(MapperUtils.mapToStudent(studentDTO));
					sinavRepository.save(sınav);
					if (CheckUtils.isNotNull(sınav)) {
						studentResponse.setSuccess(Boolean.TRUE);
						studentResponse.setMessage("Kaydiniz basari ile olusturulmustur");
					} else {
						studentResponse.setSuccess(Boolean.FALSE);
						studentResponse.setMessage("Kayit bilgileriniz hatalidir. Lütfen gozden geçiriniz");
					}
				} else {
					studentResponse.setSuccess(false);
					studentResponse.setMessage(" aktif sinav bulunmamaktadir");
				}
			}
		} else {
			studentResponse.setSuccess(false);
			studentResponse.setMessage(" bilgiler yetersizdir.");
		}
		return studentResponse;
	}
}
