package com.acikoleji.adminpanel.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acikoleji.adminpanel.model.SessionDTO;
import com.acikoleji.adminpanel.response.Response;
import com.acikoleji.adminpanel.service.SessionService;

@RestController
@RequestMapping("/session")
public class SessionController {
	
	private final SessionService sessionService;
	
	public SessionController(SessionService sessionService) {
		this.sessionService = sessionService;
	}

	@GetMapping("/")
	public List<SessionDTO> getSessionsBySinavType(@RequestParam(name = "type") String type) {
		return sessionService.findBySinavType(type);
	}
	
	@PostMapping()
	public Response create(SessionDTO sessionDTO) {
		return sessionService.save(sessionDTO);
	}
	
	@PutMapping()
	public Response update(SessionDTO sessionDTO) {
		return sessionService.update(sessionDTO);
	}
	
	@DeleteMapping()
	public Response delete(Long id) {
		return sessionService.delete(id);
	}


}
