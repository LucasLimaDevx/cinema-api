package com.lucasdevx.cinema_api.service;

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
