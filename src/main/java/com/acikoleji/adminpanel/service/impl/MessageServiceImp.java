package com.acikoleji.adminpanel.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.acikoleji.adminpanel.entity.Message;
import com.acikoleji.adminpanel.model.MessageDTO;
import com.acikoleji.adminpanel.repository.MessageRepository;
import com.acikoleji.adminpanel.response.MessageResponse;
import com.acikoleji.adminpanel.response.Response;
import com.acikoleji.adminpanel.service.MessageService;

@Service
public class MessageServiceImp implements MessageService {
	private final MessageRepository messageRepository;

	public MessageServiceImp(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	private static class Mapper {

		public static List<MessageDTO> mapToMessageDTOS(List<Message> findAll) {
			return findAll.stream().map(m -> mapToMessageDTO(m)).collect(Collectors.toList());
		}

		private static MessageDTO mapToMessageDTO(Message m) {
			MessageDTO messageDTO = new MessageDTO();
			messageDTO.setId(m.getId());
			messageDTO.setEmail(m.getEmail());
			messageDTO.setMessage(m.getMessage());
			messageDTO.setName(m.getName());
			return messageDTO;
		}

		public static Message mapToMessage(MessageDTO messageDTO) {
			Message message = new Message();
			message.setEmail(messageDTO.getEmail());
			message.setName(messageDTO.getName());
			message.setMessage(messageDTO.getMessage());
			return message;
		}

	}

	@Override
	public List<MessageDTO> findAll() {
		return Mapper.mapToMessageDTOS(messageRepository.findAll());
	}

	@Override
	public Response create(MessageDTO message) {
		Message savedMessage = messageRepository.save(Mapper.mapToMessage(message));
		Response response = new MessageResponse();
		if (Objects.nonNull(savedMessage)) {
			response.setMessage("Mesajınız başarı ile gönderildi");
			response.setSuccess(Boolean.TRUE);
		}
		else {
			response.setMessage("Mesajınız oluşturulamadı");
			response.setSuccess(Boolean.TRUE);
		}
		return response;
	}

	@Override
	public Response update(MessageDTO message) {
	    Optional<Message> savedMessageBefore = messageRepository.findById(message.getId());
		Response response = new MessageResponse();
		if (savedMessageBefore.isPresent()) {
	        messageRepository.save(Mapper.mapToMessage(message));
			response.setMessage("Mesajınız başarı ile güncellendi");
			response.setSuccess(Boolean.TRUE);
		}
		else {
			response.setMessage("Mesajınız oluşturulamadı");
			response.setSuccess(Boolean.TRUE);
		}
		return response;
	}

	@Override
	public Response delete(Long id) {
		 Optional<Message> savedMessageBefore = messageRepository.findById(id);
			Response response = new MessageResponse();
			if (savedMessageBefore.isPresent()) {
		        messageRepository.deleteById(id);
				response.setMessage("Mesajınız başarı ile silindi");
				response.setSuccess(Boolean.TRUE);
			}
			else {
				response.setMessage("Mesajınız silinemedi");
				response.setSuccess(Boolean.TRUE);
			}
			return response;
	}

}
