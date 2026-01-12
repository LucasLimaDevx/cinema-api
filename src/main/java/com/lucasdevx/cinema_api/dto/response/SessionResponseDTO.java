package com.lucasdevx.cinema_api.dto.response;

public record SessionResponseDTO(
		Long id,
		String startTime,
		MovieResponseDTO movieResponseDTO,
		RoomResponseDTO roomResponseDTO) {

}
