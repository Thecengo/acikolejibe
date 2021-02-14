package com.acikoleji.adminpanel.util;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.acikoleji.adminpanel.entity.Sinav;
import com.acikoleji.adminpanel.entity.Student;
import com.acikoleji.adminpanel.entity.Veli;
import com.acikoleji.adminpanel.model.GetBySinavTypeStudentDTO;
import com.acikoleji.adminpanel.model.GetBySinavTypeVeliDTO;
import com.acikoleji.adminpanel.model.StudentDTO;
import com.acikoleji.adminpanel.model.SınavDTO;
import com.acikoleji.adminpanel.model.VeliDTO;

public class MapperUtils {

	public static Sinav mapToSinav(SınavDTO sinavDTO) {
		Sinav sinav = new Sinav();
		sinav.setStartDate(sinavDTO.getStartDate());
		sinav.setEndDate(sinavDTO.getEndDate());
		sinav.setTipi(sinavDTO.getTipi());
		return sinav;
	}

	public static Student mapToStudent(StudentDTO studentDTO) {
		Student student = new Student();
		student.setName(studentDTO.getName());
		student.setSchoolName(studentDTO.getSchoolName());
		student.setTcNo(studentDTO.getSchoolName());
		student.setSinif(studentDTO.getSinif());
		student.setTelNo(studentDTO.getTelNo());
		student.setVeli(Objects.nonNull(studentDTO.getVeli())?mapToVeli(studentDTO.getVeli()) : null);
		return student;
	}

	public static Veli mapToVeli(VeliDTO veliDTO) {
		Veli veli = new Veli();
		veli.setName(veliDTO.getName());
		veli.setTelNo(veliDTO.getTelNo());
		return veli;
	}


	public static StudentDTO mapToStudentDTO(Student student) {
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setName(student.getName());
		studentDTO.setSchoolName(student.getSchoolName());
		studentDTO.setSinif(student.getSinif());
		studentDTO.setTcNo(student.getSchoolName());
		studentDTO.setTelNo(student.getTelNo());
		studentDTO.setVeli(mapToVeliDTO(student.getVeli()));
		return studentDTO;
	}


	public static VeliDTO mapToVeliDTO(Veli veli) {
		VeliDTO veliDTO = new VeliDTO();
		veliDTO.setName(veli.getName());
		veliDTO.setTelNo(veli.getTelNo());
		//veliDTO.setStudents(mapToStudentDTOs(veli.getStudents()));
		return veliDTO;
	}

	private static List<StudentDTO> mapToStudentDTOs(List<Student> students) {
		return students.stream().map(s -> mapToStudentDTO(s)).collect(Collectors.toList());
	}

	public static SınavDTO mapToSinavDTO(Sinav sinav) {
		SınavDTO sinavDTO = new SınavDTO();
		sinavDTO.setStartDate(sinav.getStartDate());
		sinavDTO.setEndDate(sinav.getEndDate());
		sinavDTO.setTipi(sinav.getTipi());
		sinavDTO.setStudents(mapToStudentDTOs(sinav.getStudents()));
		return sinavDTO;
	}
	
	public static List<SınavDTO> mapToSinavDTOs(List<Sinav> sinavs) {
		return sinavs.stream().map(s -> mapToSinavDTO(s)).collect(Collectors.toList());
	}

	public static Collection<? extends Sinav> mapToSinavs(List<SınavDTO> activeExamns) {
		return activeExamns.stream().map(s -> mapToSinav(s)).collect(Collectors.toList());
	}

	public static List<GetBySinavTypeStudentDTO> mapToGetSinavByTypeSTudentDTOs(List<Student> students) {
		return students.stream().map(s -> mapToGetSinavByTypeStudentDTO(s)).collect(Collectors.toList());
	}

	public static GetBySinavTypeStudentDTO mapToGetSinavByTypeStudentDTO(Student student) {
		GetBySinavTypeStudentDTO getBySinavTypeStudentDTO = new GetBySinavTypeStudentDTO();
		getBySinavTypeStudentDTO.setName(student.getName());
		getBySinavTypeStudentDTO.setSchoolName(student.getSchoolName());
		getBySinavTypeStudentDTO.setTcNo(student.getSchoolName());
		getBySinavTypeStudentDTO.setTelNo(student.getTelNo());
		getBySinavTypeStudentDTO.setVeli(mapToGetBySinavTypeVeliDTO(student.getVeli()));
		return getBySinavTypeStudentDTO;
	}

	private static GetBySinavTypeVeliDTO mapToGetBySinavTypeVeliDTO(Veli veli) {
		GetBySinavTypeVeliDTO getBySinavTypeVeliDTO = new GetBySinavTypeVeliDTO();
		getBySinavTypeVeliDTO.setName(veli.getName());
		getBySinavTypeVeliDTO.setTelNo(veli.getTelNo());
		return getBySinavTypeVeliDTO;
	}
}
