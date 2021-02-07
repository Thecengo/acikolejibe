package com.acikoleji.adminpanel.service;

import java.time.LocalDate;
import java.util.List;

import com.acikoleji.adminpanel.entity.Sinav;
import com.acikoleji.adminpanel.model.GetSinavByTypeDTO;
import com.acikoleji.adminpanel.model.StudentDTO;
import com.acikoleji.adminpanel.model.SınavDTO;
import com.acikoleji.adminpanel.response.Response;

public interface SinavService {

	//Page<SınavDTO> getAll(Pageable page);
	
	List<SınavDTO> getAll();
	
	GetSinavByTypeDTO findBySinavType(String type);
	
	Boolean isExistActiveExams();

	List<SınavDTO> findActiveExamns(LocalDate date);
	
	List<Sinav> findActiveSinav(LocalDate date);
	
	Response createSinav(SınavDTO sinavDTO);
	
	Response updateSinav(SınavDTO sinavDTO);
	
	Response deleteSinav(Long id);
	
	List<StudentDTO> findStudentsByType(String type);
	
	
	
	
}
