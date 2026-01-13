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

import com.lucasdevx.cinema_api.dto.request.RoomRequestDTO;
import com.lucasdevx.cinema_api.dto.response.RoomResponseDTO;
import com.lucasdevx.cinema_api.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {
	
	private RoomService roomService;

	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public RoomResponseDTO insert(@RequestBody RoomRequestDTO roomRequestDTO) {
		
		return roomService.insert(roomRequestDTO);
	}
	
	@GetMapping(
			value = "/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public RoomResponseDTO findById(@PathVariable Long id) {
		
		return roomService.findById(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<RoomResponseDTO> findAll() {
		
		return roomService.findAll();
	}
	
	@PutMapping(
			value = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public RoomResponseDTO update(@PathVariable Long id, @RequestBody RoomRequestDTO roomRequestDTO) {
		
		return roomService.update(roomRequestDTO, id);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		
		roomService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
