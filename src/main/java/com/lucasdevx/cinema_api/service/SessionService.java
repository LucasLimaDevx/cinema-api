package com.lucasdevx.cinema_api.service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lucasdevx.cinema_api.dto.request.SessionRequestDTO;
import com.lucasdevx.cinema_api.dto.response.SessionResponseDTO;
import com.lucasdevx.cinema_api.entity.Session;
import com.lucasdevx.cinema_api.exception.ObjectNotFoundException;
import com.lucasdevx.cinema_api.repository.SessionRepository;

@Service
public class SessionService {
	
	private SessionRepository sessionRepository;
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	public SessionService(SessionRepository sessionRepository) {
		this.sessionRepository = sessionRepository;
	}
	
	public SessionResponseDTO insert(SessionRequestDTO sessionRequestDTO) {
		Session session = toSession(sessionRequestDTO);
		
		return toDTO(sessionRepository.save(session));
	}
	
	public SessionResponseDTO findById(Long id) {

		Session messionDB = sessionRepository.findById(id)
				.orElseThrow(()-> new ObjectNotFoundException("Object not found"));
		
		return toDTO(messionDB);
	}
	
	public List<SessionResponseDTO> findAll(){
		
		List<Session> sessions = sessionRepository.findAll();
		
		
		return sessions.stream().map((session) -> {
			return toDTO(session);
		}).collect(Collectors.toList());
	}
	
	public SessionResponseDTO update(SessionRequestDTO sessionRequestDTO, Long id) {
		Session sessionDB = sessionRepository.findById(id)
				.orElseThrow(()-> new ObjectNotFoundException("Object not found"));
		
		sessionDB.setStartTime(sessionRequestDTO.startTime());
		
		return toDTO(sessionRepository.save(sessionDB));
	}
	
	public void deleteById(Long id) {
		sessionRepository.deleteById(id);
	}
	
	public SessionResponseDTO toDTO(Session session) {
		
		return new SessionResponseDTO(session.getId(), session.getStartTime().format(formatter), null, null);
	}
	
	public Session toSession(SessionRequestDTO sessionRequestDTO) {
		Session session = new Session();
		
		session.setStartTime(sessionRequestDTO.startTime());
;
		
		return session;
	}
	
	
	
	
	
	
	
	
	
	
}
