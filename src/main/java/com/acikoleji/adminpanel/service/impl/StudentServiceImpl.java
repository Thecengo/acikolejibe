package com.acikoleji.adminpanel.service.impl;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.acikoleji.adminpanel.entity.Sinav;
import com.acikoleji.adminpanel.entity.Student;
import com.acikoleji.adminpanel.model.StudentDTO;
import com.acikoleji.adminpanel.repository.SinavRepository;
import com.acikoleji.adminpanel.repository.StudentRepository;
import com.acikoleji.adminpanel.request.RequstStudentApplication;
import com.acikoleji.adminpanel.response.ResponseStudentApplyed;
import com.acikoleji.adminpanel.response.StudentResponse;
import com.acikoleji.adminpanel.service.SinavService;
import com.acikoleji.adminpanel.service.StudentService;
import com.acikoleji.adminpanel.util.CheckUtils;
import com.acikoleji.adminpanel.util.MapperUtils;

@Transactional
@Service
public class StudentServiceImpl implements StudentService {
	
	private static class Mapper {

		public static StudentDTO mapToStudentDTO(RequstStudentApplication request) {
			StudentDTO studentDTO = new StudentDTO();
			studentDTO.setId(request.getId());
			studentDTO.setName(request.getName());
			studentDTO.setSchoolName(request.getSchoolName());
			studentDTO.setSinif(request.getSinif());
			studentDTO.setTcNo(request.getTcNo());
			studentDTO.setTelNo(request.getTelNo());
			studentDTO.setVeli(request.getVeli());
			return studentDTO;
		}

		public static ResponseStudentApplyed mapToResponseStudentApplied(Student student) {
			ResponseStudentApplyed response = new ResponseStudentApplyed();
			response.setStudentName(student.getName());
			response.setSchoolName(student.getSchoolName());
			response.setTcNo(student.getTcNo());
			response.setStudentTelNo(student.getTelNo());
			response.setSinif(student.getSinif());
			response.setVeliAdi(student.getVeli().getName());
			response.setVeliTelNo(student.getVeli().getTelNo());
			return response;
		}
		
	}

	private final StudentRepository studentRepository;

	private final SinavService sinavService;

	private final SinavRepository sinavRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository, SinavService sinavService,
			SinavRepository sinavRepository) {
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
	public StudentResponse sinavaBasvuruYap(RequstStudentApplication request) {
		StudentResponse studentResponse = new StudentResponse();
		if (CheckUtils.isNotNull(request)) {
			Sinav sinav = sinavService.findBySinavTypeForApply(request.getSinavType());
			if (Objects.nonNull(sinav)) {
				StudentDTO studentDTO = Mapper.mapToStudentDTO(request);
				sinav.getStudents().add(MapperUtils.mapToStudent(studentDTO));
				sinavRepository.save(sinav);
				if (CheckUtils.isNotNull(sinav)) {
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
		return studentResponse;
	}

	@Override
	public List<ResponseStudentApplyed> findBySinavTypeAndSessionStartTime(String burs, LocalTime startTime) {
		List<Student> students = studentRepository.findBySinavsTipiAndSinavsSessionsStartTime(burs, startTime);
		return students.stream().map(s -> Mapper.mapToResponseStudentApplied(s)).collect(Collectors.toList());
	}
}
