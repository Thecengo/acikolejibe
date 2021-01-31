package com.acikoleji.adminpanel.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acikoleji.adminpanel.model.AdminCredentialsDTO;
import com.acikoleji.adminpanel.response.Response;
import com.acikoleji.adminpanel.service.AdminService;

@RequestMapping("/admin")
@RestController
public class AdminController {

	private final AdminService adminService;

	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}

	@PostMapping()
	public Response getByPasswordAndMail(@RequestBody AdminCredentialsDTO admin) {
		return adminService.findByPasswordAndMail(admin.getPassword(), admin.getMail());
	}
}
