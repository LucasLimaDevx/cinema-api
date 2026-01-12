package com.lucasdevx.cinema_api.dto.request;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record SessionRequestDTO(
		Long movieId, 
		Long roomId,
		@JsonFormat(pattern = "dd/MM/yyyy HH:mm") LocalDateTime startTime) {

}
