package com.lucasdevx.cinema_api.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasdevx.cinema_api.dto.request.SessionRequestDTO;
import com.lucasdevx.cinema_api.dto.response.SessionResponseDTO;
import com.lucasdevx.cinema_api.service.SessionService;

@RestController
@RequestMapping("session")
public class SessionController {
	private SessionService sessionService;

	public SessionController(SessionService sessionService) {
		this.sessionService = sessionService;
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public SessionResponseDTO insert(@RequestBody SessionRequestDTO sessionRequestDTO) {
		
		return sessionService.insert(sessionRequestDTO);
	}
	
	@GetMapping(
			value = "/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public SessionResponseDTO findById(@PathVariable Long id) {
		
		return sessionService.findById(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SessionResponseDTO> findAll() {
		
		return sessionService.findAll();
	}
	
	@PutMapping(
			value = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public SessionResponseDTO update(@PathVariable Long id, @RequestBody SessionRequestDTO sessionRequestDTO) {
		
		return sessionService.update(sessionRequestDTO, id);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		
		sessionService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
}
