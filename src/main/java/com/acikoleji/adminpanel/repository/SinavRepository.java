package com.acikoleji.adminpanel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acikoleji.adminpanel.entity.Sinav;


public interface SinavRepository extends JpaRepository<Sinav, Long> {
	
	//@Query("SELECT sinav from Sınav sinav where sinav.tipi = :tipi")
	Sinav findByTipi(String type);
	
	List<Sinav> findByStatusNot(String status);
	
}
