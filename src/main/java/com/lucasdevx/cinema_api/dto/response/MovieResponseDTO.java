package com.lucasdevx.cinema_api.dto.response;

public record MovieResponseDTO(
		Long id, 
		String title,
		String duration,
		int rating,
		GenreResponseDTO genreResponseDTO) {

}
