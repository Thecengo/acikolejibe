package com.acikoleji.adminpanel.service;

import java.util.Date;
import java.util.List;

import com.acikoleji.adminpanel.entity.Sınav;
import com.acikoleji.adminpanel.model.GetSinavByTypeDTO;
import com.acikoleji.adminpanel.model.StudentDTO;
import com.acikoleji.adminpanel.model.SınavDTO;
import com.acikoleji.adminpanel.response.Response;

public interface SinavService {

	//Page<SınavDTO> getAll(Pageable page);
	
	List<SınavDTO> getAll();
	
	GetSinavByTypeDTO findBySinavType(String type);
	
	Boolean isExistActiveExams();

	List<SınavDTO> findActiveExamns(Date date);
	
	List<Sınav> findActiveSinav(Date date);
	
	Response createSinav(SınavDTO sinavDTO);
	
	Response updateSinav(SınavDTO sinavDTO);
	
	Response deleteSinav(Long id);
	
	List<StudentDTO> findStudentsByType(String type);
	
	
	
	
}
