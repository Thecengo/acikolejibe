package com.acikoleji.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acikoleji.adminpanel.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Long>{
	
	Admin findByPasswordAndMail(String password, String mail);

}
