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

import com.lucasdevx.cinema_api.dto.request.MovieRequestDTO;
import com.lucasdevx.cinema_api.dto.response.MovieResponseDTO;
import com.lucasdevx.cinema_api.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {
	
	private MovieService movieService;

	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MovieResponseDTO insert(@RequestBody MovieRequestDTO movieRequestDTO) {
		
		return movieService.insert(movieRequestDTO);
	}
	
	@GetMapping(
			value = "/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MovieResponseDTO findById(@PathVariable Long id) {
		
		return movieService.findById(id);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MovieResponseDTO> findAll() {
		
		return movieService.findAll();
	}
	
	@PutMapping(
			value = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public MovieResponseDTO update(@PathVariable Long id, @RequestBody MovieRequestDTO movieRequestDTO) {
		
		return movieService.update(movieRequestDTO, id);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		
		movieService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
}
