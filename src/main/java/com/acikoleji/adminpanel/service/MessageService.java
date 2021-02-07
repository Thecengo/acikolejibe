package com.acikoleji.adminpanel.service;

import java.util.List;

import com.acikoleji.adminpanel.model.MessageDTO;
import com.acikoleji.adminpanel.response.Response;

public interface MessageService {

	  List<MessageDTO> findAll();
	  Response create(MessageDTO message);
	  Response update(MessageDTO message);
	  Response delete(Long id);
}
