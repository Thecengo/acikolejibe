package com.acikoleji.adminpanel.service;

import java.time.LocalTime;
import java.util.List;

import com.acikoleji.adminpanel.entity.Session;
import com.acikoleji.adminpanel.model.SessionDTO;
import com.acikoleji.adminpanel.response.Response;

public interface SessionService {

	List<SessionDTO> findBySinavType(String type);
	Session findByStartTime(LocalTime startTime);
	Response save(SessionDTO session);
	Response update(SessionDTO session);
	Response delete(Long id);
}
