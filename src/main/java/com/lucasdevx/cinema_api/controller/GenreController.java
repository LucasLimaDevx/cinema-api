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

import com.lucasdevx.cinema_api.dto.request.GenreRequestDTO;
import com.lucasdevx.cinema_api.dto.response.GenreResponseDTO;
import com.lucasdevx.cinema_api.service.GenreService;

@RestController
@RequestMapping("/genre")
public class GenreController {
	
	private GenreService genreService;

	public GenreController(GenreService genreService) {
		this.genreService = genreService;
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenreResponseDTO> insert(@RequestBody GenreRequestDTO genreRequestDTO) {
		
		return new ResponseEntity<>(genreService.insert(genreRequestDTO), HttpStatus.CREATED);
	}
	
	@GetMapping(
			value = "/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenreResponseDTO> findById(@PathVariable Long id) {
		if(id <= 0) {
			throw new IllegalArgumentException("Invalid id: " + id);
		}
		return ResponseEntity.ok(genreService.findById(id));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GenreResponseDTO> findAll() {
		
		return genreService.findAll();
	}
	
	@PutMapping(
			value = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GenreResponseDTO> update(@PathVariable Long id, @RequestBody GenreRequestDTO genreRequestDTO) {
		if(id <= 0) {
			throw new IllegalArgumentException("Invalid id: " + id);
		}
		return ResponseEntity.ok(genreService.update(genreRequestDTO, id));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		if(id <= 0) {
			throw new IllegalArgumentException("Invalid id: " + id);
		}
		genreService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
