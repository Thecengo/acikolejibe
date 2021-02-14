package com.acikoleji.adminpanel.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.acikoleji.adminpanel.entity.Session;
import com.acikoleji.adminpanel.model.SessionDTO;
import com.acikoleji.adminpanel.repository.SessionRepository;
import com.acikoleji.adminpanel.response.Response;
import com.acikoleji.adminpanel.response.SessionResponse;
import com.acikoleji.adminpanel.util.MapperUtils;

@Service
public class SessionServiceImpl implements SessionService {

	private static class Mapper {

		public static List<SessionDTO> mapToSessionDTOs(List<Session> sessions) {
			return sessions.stream().map(s -> mapToSessionDTO(s)).collect(Collectors.toList());
		}

		private static SessionDTO mapToSessionDTO(Session session) {
			SessionDTO sessionDTO = new SessionDTO();
			sessionDTO.setId(session.getId());
			sessionDTO.setStartTime(session.getStartTime());
			//sessionDTO.setSinav(session.getSinav());
			return sessionDTO;
		}

		public static Session mapToSessionDTO(SessionDTO sessionDTO) {
			Session session = new Session();
			session.setId(sessionDTO.getId());
			session.setStartTime(sessionDTO.getStartTime());
			session.setSinav(MapperUtils.mapToSinav(sessionDTO.getSinav()));
			return session;
		}
		
	}
	private final SessionRepository sessionRepository;
	
	public SessionServiceImpl(SessionRepository sessionRepository) {
		this.sessionRepository = sessionRepository;
	}
	
	@Override
	public List<SessionDTO> findBySinavType(String type) {
		return Mapper.mapToSessionDTOs(sessionRepository.findBySinavTipi(type));
	}

	@Override
	public Response save(SessionDTO session) {
		Session savedSession = sessionRepository.save(Mapper.mapToSessionDTO(session));
		Response response = new SessionResponse();
		if (Objects.nonNull(savedSession)) {
			response.setMessage("Oturum başarı ile oluşturuldu");
			response.setSuccess(Boolean.TRUE);
		}
		else {
			response.setMessage("Oturum oluşturulamadı");
			response.setSuccess(Boolean.FALSE);
		}
		return response;
		
	}

	@Override
	public Response update(SessionDTO session) {
	    Optional<Session> findedSession = sessionRepository.findById(session.getId());
		Response response = new SessionResponse();
		if (findedSession.isPresent()) {
			sessionRepository.save(Mapper.mapToSessionDTO(session));
			response.setMessage("Oturum başarı ile güncellendi");
			response.setSuccess(Boolean.TRUE);
		}
		else {
			response.setMessage("Oturum bulunamadı");
			response.setSuccess(Boolean.FALSE);
		}
		return response;
	}

	@Override
	public Response delete(Long id) {
		   Optional<Session> findedSession = sessionRepository.findById(id);
			Response response = new SessionResponse();
			if (findedSession.isPresent()) {
			    sessionRepository.deleteById(id);
				response.setMessage("Oturum başarı ile silindi");
				response.setSuccess(Boolean.TRUE);
			}
			else {
				response.setMessage("Oturum bulunamadı");
				response.setSuccess(Boolean.FALSE);
			}
			return response;
	}

	@Override
	public Session findByStartTime(LocalTime startTime) {
		return sessionRepository.findByStartTime(startTime);
	}

}
