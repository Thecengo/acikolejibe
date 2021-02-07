package com.acikoleji.adminpanel.service;

import java.util.List;

import com.acikoleji.adminpanel.model.HeaderCaroselDTO;
import com.acikoleji.adminpanel.response.Response;

public interface HeaderCaroselService {

	List<HeaderCaroselDTO> findAll(); 
	Response create(HeaderCaroselDTO dto); 
	Response update(HeaderCaroselDTO dto); 
	Response delete(Long id); 
}
