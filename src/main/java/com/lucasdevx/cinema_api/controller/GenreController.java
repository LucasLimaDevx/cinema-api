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
	public GenreResponseDTO insert(@RequestBody GenreRequestDTO genreRequestDTO) {
		
		return genreService.insert(genreRequestDTO);
	}
	
	@GetMapping(
			value = "/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public GenreResponseDTO findById(@PathVariable Long id) {
		
		return genreService.findById(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GenreResponseDTO> findAll() {
		
		return genreService.findAll();
	}
	
	@PutMapping(
			value = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public GenreResponseDTO update(@PathVariable Long id, @RequestBody GenreRequestDTO genreRequestDTO) {
		
		return genreService.update(genreRequestDTO, id);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		
		genreService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
