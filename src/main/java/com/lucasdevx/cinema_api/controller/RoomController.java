package com.lucasdevx.cinema_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
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
	public ResponseEntity<RoomResponseDTO> insert(@RequestBody RoomRequestDTO roomRequestDTO) {
		
		return new ResponseEntity<>(roomService.insert(roomRequestDTO), HttpStatus.CREATED);
	}
	
	@GetMapping(
			value = "/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RoomResponseDTO> findById(@PathVariable Long id) {
		if(id <= 0) {
			throw new IllegalArgumentException("Invalid id: " + id);
		}
		return ResponseEntity.ok(roomService.findById(id));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RoomResponseDTO>> findAll() {
		
		return ResponseEntity.ok(roomService.findAll());
	}
	
	@PutMapping(
			value = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RoomResponseDTO> update(@PathVariable Long id, @RequestBody RoomRequestDTO roomRequestDTO) {
		if(id <= 0) {
			throw new IllegalArgumentException("Invalid id: " + id);
		}
		return ResponseEntity.ok(roomService.update(roomRequestDTO, id));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		if(id <= 0) {
			throw new IllegalArgumentException("Invalid id: " + id);
		}
		roomService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
}
