package com.acikoleji.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acikoleji.adminpanel.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	

}
