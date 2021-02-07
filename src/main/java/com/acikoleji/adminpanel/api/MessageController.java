package com.acikoleji.adminpanel.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acikoleji.adminpanel.model.MessageDTO;
import com.acikoleji.adminpanel.response.Response;
import com.acikoleji.adminpanel.service.MessageService;

@RequestMapping("/message")
@RestController
public class MessageController {

	private final MessageService messageService;
	
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
		
	} 
	
	@GetMapping
	public List<MessageDTO> getAll() {
		return messageService.findAll();
	}
	
	@PostMapping
	public Response create(@RequestBody MessageDTO messageDTO) {
		return messageService.create(messageDTO);
	}
	
	@PutMapping
	public Response update(@RequestBody MessageDTO messageDTO) {
		return messageService.update(messageDTO);
	}
	
	@DeleteMapping("/{id}")
	public Response delete(@PathVariable("id") Long id) {
		return messageService.delete(id);
	}
}
