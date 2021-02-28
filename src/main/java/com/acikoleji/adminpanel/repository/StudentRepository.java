package com.acikoleji.adminpanel.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acikoleji.adminpanel.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	List<Student> findBySinavsTipiAndExamTime(String type, LocalTime time);

}
