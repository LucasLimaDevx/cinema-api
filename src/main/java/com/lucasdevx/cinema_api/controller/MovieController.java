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
	public ResponseEntity<MovieResponseDTO> insert(@RequestBody MovieRequestDTO movieRequestDTO) {
		
		return new ResponseEntity<>(movieService.insert(movieRequestDTO), HttpStatus.CREATED);
	}
	
	@GetMapping(
			value = "/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MovieResponseDTO> findById(@PathVariable Long id) {
		if(id <= 0) {
			throw new IllegalArgumentException("Invalid id: " + id);
		}
		return ResponseEntity.ok(movieService.findById(id));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<MovieResponseDTO>> findAll() {
		
		return ResponseEntity.ok(movieService.findAll());
	}
	
	@PutMapping(
			value = "/{id}",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<MovieResponseDTO> update(@PathVariable Long id, @RequestBody MovieRequestDTO movieRequestDTO) {
		if(id <= 0) {
			throw new IllegalArgumentException("Invalid id: " + id);
		}
		return ResponseEntity.ok(movieService.update(movieRequestDTO, id));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		if(id <= 0) {
			throw new IllegalArgumentException("Invalid id: " + id);
		}
		movieService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
}
