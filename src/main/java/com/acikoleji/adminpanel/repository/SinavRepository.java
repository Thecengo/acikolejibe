package com.acikoleji.adminpanel.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.acikoleji.adminpanel.entity.Sinav;


public interface SinavRepository extends JpaRepository<Sinav, Long> {
	
	//@Query("SELECT sinav from Sınav sinav where sinav.tipi = :tipi")
	Sinav findByTipi(String type);
	
	@Query("SELECT s from Sinav s where s.startDate <=:today and s.endDate >=:today")
	List<Sinav>findActiveExamns(@Param("today") Date date);
	
}
