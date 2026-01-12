package com.lucasdevx.cinema_api.dto.request;

public record MovieRequestDTO(String title, int duration, int rating, Long genreId) {
}
