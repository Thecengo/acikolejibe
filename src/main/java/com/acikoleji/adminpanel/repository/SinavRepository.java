package com.acikoleji.adminpanel.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.acikoleji.adminpanel.entity.Sınav;

public interface SinavRepository extends JpaRepository<Sınav, Long> {
	
	//@Query("SELECT sinav from Sınav sinav where sinav.tipi = :tipi")
	Sınav findByTipi(String type);
	
	@Query("SELECT s from Sınav s where s.startDate <=:today and s.endDate >=:today")
	List<Sınav>findActiveExamns(@Param("today") Date date);
	
}
