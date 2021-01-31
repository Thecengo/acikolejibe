package com.acikoleji.adminpanel.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acikoleji.adminpanel.model.GetBySinavTypeStudentDTO;
import com.acikoleji.adminpanel.model.SınavDTO;
import com.acikoleji.adminpanel.response.Response;
import com.acikoleji.adminpanel.service.SinavService;

@RequestMapping("/sinav")
@RestController
public class SinavController {

	private final SinavService sinavService;

	public SinavController(SinavService sinavService) {
		this.sinavService = sinavService;
	}
	
	
	@GetMapping()
	public List<SınavDTO> getAll() {
		return sinavService.getAll();
	}
	
	@GetMapping("/{type}")
	public List<String> getStudentsNameBySinavType(@PathVariable("type") String type) {
		return sinavService.findBySinavType(type).getStudents().stream()
				.map(s -> s.getName())
				.collect(Collectors.toList());
	}
	
	@GetMapping("/tip")
	public List<GetBySinavTypeStudentDTO> getStudentsBySinavType(@RequestParam(name = "type") String type) {
		return sinavService.findBySinavType(type).getStudents().stream()
				.collect(Collectors.toList());
	}
	
	@PostMapping()
	public Response save(@RequestBody SınavDTO sınavDTO) {
		return sinavService.createSinav(sınavDTO);
	}
	
	@PutMapping
	public Response update(@RequestBody SınavDTO sinavDTO) {
		return sinavService.updateSinav(sinavDTO);
	}
	
	@DeleteMapping("/{id}")
	public Response delete(Long id) {
		return sinavService.deleteSinav(id);
	}
	
}
