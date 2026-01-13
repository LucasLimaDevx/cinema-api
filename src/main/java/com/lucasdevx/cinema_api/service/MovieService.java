package com.lucasdevx.cinema_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lucasdevx.cinema_api.dto.request.MovieRequestDTO;
import com.lucasdevx.cinema_api.dto.response.MovieResponseDTO;
import com.lucasdevx.cinema_api.entity.Movie;
import com.lucasdevx.cinema_api.repository.MovieRepository;

@Service
public class MovieService {
	
	private MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public MovieResponseDTO insert(MovieRequestDTO movieRequestDTO) {
		Movie movie = toMovie(movieRequestDTO);
		
		return toDTO(movieRepository.save(movie));
	}
	
	public MovieResponseDTO findById(Long id) {

		Movie movieDB = movieRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("Object not found"));
		
		return toDTO(movieDB);
	}
	
	public List<MovieResponseDTO> findAll(){
		
		List<Movie> movies = movieRepository.findAll();
		
		
		return movies.stream().map((movie) -> {
			return toDTO(movie);
		}).collect(Collectors.toList());
	}
	
	public MovieResponseDTO update(MovieRequestDTO movieRequestDTO, Long id) {
		Movie movieDB = movieRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("Object not found"));
		
		movieDB.setTitle(movieRequestDTO.title());
		movieDB.setDuration(movieRequestDTO.duration());
		movieDB.setRating(movieRequestDTO.rating());
		
		return toDTO(movieRepository.save(movieDB));
	}
	
	public void deleteById(Long id) {
		movieRepository.deleteById(id);
	}
	
	public MovieResponseDTO toDTO(Movie movie) {
		
		return new MovieResponseDTO(
				movie.getId(),
				movie.getTitle(),
				String.valueOf(movie.getDuration()),
				movie.getRating(),
				null);
	}
	
	public Movie toMovie(MovieRequestDTO movieRequestDTO) {
		Movie movie = new Movie();
		
		movie.setTitle(movieRequestDTO.title());
		movie.setDuration(movieRequestDTO.duration());
		movie.setRating(movieRequestDTO.rating());
		
		return movie;
	}
	
	
	
}
