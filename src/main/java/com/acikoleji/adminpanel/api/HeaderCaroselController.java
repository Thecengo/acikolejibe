package com.acikoleji.adminpanel.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acikoleji.adminpanel.model.HeaderCaroselDTO;
import com.acikoleji.adminpanel.response.Response;
import com.acikoleji.adminpanel.service.HeaderCaroselService;

@RequestMapping("/carosel")
@RestController()
public class HeaderCaroselController {
	
	private final HeaderCaroselService headerCaroselService;
	
	public HeaderCaroselController(HeaderCaroselService headerCaroselService) {
		this.headerCaroselService = headerCaroselService;
	}

	@GetMapping
	public List<HeaderCaroselDTO> getAll() {
		return headerCaroselService.findAll();
	}
	
	@PostMapping
	public Response create(@RequestBody HeaderCaroselDTO headerCaroselDTO) {
		return headerCaroselService.create(headerCaroselDTO);
	}
	
	@PutMapping
	public Response update(@RequestBody HeaderCaroselDTO headerCaroselDTO) {
		return headerCaroselService.update(headerCaroselDTO);
	}
	
	@DeleteMapping
	public Response delete(Long id) {
		return headerCaroselService.delete(id);
	}
}
