package com.acikoleji.adminpanel.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.acikoleji.adminpanel.entity.HeaderCarosel;
import com.acikoleji.adminpanel.model.HeaderCaroselDTO;
import com.acikoleji.adminpanel.repository.HeaderCaroselRepository;
import com.acikoleji.adminpanel.response.HeaderCaroselResponse;
import com.acikoleji.adminpanel.response.Response;
import com.acikoleji.adminpanel.service.HeaderCaroselService;

@Service
public class HeaderCaroselServiceImpl implements HeaderCaroselService {

	private static class Mapper {

		public static List<HeaderCaroselDTO> mapToHeaderDTOs(List<HeaderCarosel> findAll) {
			return findAll.stream().map(h -> mapToHeaderCaroselDTO(h)).collect(Collectors.toList());
		}

		private static HeaderCaroselDTO mapToHeaderCaroselDTO(HeaderCarosel h) {
			HeaderCaroselDTO dto = new HeaderCaroselDTO();
			
			dto.setSrc(h.getImageUrl());
			dto.setAltText(h.getImgAlt());
			return dto;
		}

		public static HeaderCarosel mapToHeaderCarosel(HeaderCaroselDTO dto) {
			HeaderCarosel headerCarosel = new HeaderCarosel();
			headerCarosel.setImageUrl(dto.getSrc());
			headerCarosel.setImgAlt(dto.getAltText());
			return headerCarosel;
		}
		
		
	}
	
	private final HeaderCaroselRepository headerCaroselRepository;
	
	public HeaderCaroselServiceImpl(HeaderCaroselRepository headerCaroselRepository) {
		this.headerCaroselRepository = headerCaroselRepository;
	}
	
	@Override
	public List<HeaderCaroselDTO> findAll() {
		return Mapper.mapToHeaderDTOs(headerCaroselRepository.findAll());
	}

	@Override
	public Response create(HeaderCaroselDTO dto) {
		HeaderCarosel savedCarosel = headerCaroselRepository.save(Mapper.mapToHeaderCarosel(dto));
		Response response = new HeaderCaroselResponse();
		if (Objects.nonNull(savedCarosel)) {
			response.setMessage("basari ile olusturuldu");
			response.setSuccess(true);
		}
		else {
			response.setMessage("Olustururken bir hata olustu");
			response.setSuccess(false);
		}
		return response;
	}

	@Override
	public Response update(HeaderCaroselDTO dto) {
		Optional<HeaderCarosel> existedCarosel = headerCaroselRepository.findById(dto.getKey());
		Response response = new HeaderCaroselResponse();
		if (existedCarosel.isPresent()) {
			headerCaroselRepository.save(Mapper.mapToHeaderCarosel(dto));
			response.setMessage("basari ile guncellendi");
			response.setSuccess(true);
		}
		else {
			response.setMessage("Olustururken bir hata olustu");
			response.setSuccess(false);
		}
		return response;
	}

	@Override
	public Response delete(Long id) {
		headerCaroselRepository.deleteById(id);
		return new HeaderCaroselResponse();
	}

}
