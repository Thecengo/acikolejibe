package com.acikoleji.adminpanel.service;

import com.acikoleji.adminpanel.model.AdminDTO;
import com.acikoleji.adminpanel.response.Response;

public interface AdminService {
	
	Response findByPasswordAndMail(String password, String mail);
	Response create(AdminDTO admin);
	Response update(AdminDTO admin);
	Response delete(Long id);

}
