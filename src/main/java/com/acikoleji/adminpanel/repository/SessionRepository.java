package com.acikoleji.adminpanel.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acikoleji.adminpanel.entity.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {

	List<Session> findBySinavTipi(String type);
	
	Session findByStartTime(LocalTime startTime);
}
