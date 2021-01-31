package com.acikoleji.adminpanel.service.impl;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.acikoleji.adminpanel.entity.Admin;
import com.acikoleji.adminpanel.model.AdminDTO;
import com.acikoleji.adminpanel.repository.AdminRepository;
import com.acikoleji.adminpanel.response.AdminResponse;
import com.acikoleji.adminpanel.response.Response;
import com.acikoleji.adminpanel.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	private final AdminRepository adminRepository;

	public AdminServiceImpl(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	@Override
	public Response findByPasswordAndMail(String password, String mail) {
		Response adminResponse = new AdminResponse();
		Admin admin = adminRepository.findByPasswordAndMail(password, mail);
		if (Objects.nonNull(admin)) {
			adminResponse.setMessage("Giris basarili");
			adminResponse.setSuccess(Boolean.TRUE);
		}
		else {
			adminResponse.setMessage("Giris basarisiz. Lütfen tekrar deneyiniz");
			adminResponse.setSuccess(Boolean.FALSE);
		}
		return adminResponse;
	}

	@Override
	public Response create(AdminDTO admin) {
		return null;
	}

	@Override
	public Response update(AdminDTO admin) {
		return null;
	}

	@Override
	public Response delete(Long id) {
		return null;
	}

}
