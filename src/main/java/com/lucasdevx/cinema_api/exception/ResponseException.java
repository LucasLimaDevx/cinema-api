package com.lucasdevx.cinema_api.exception;

import java.time.LocalDateTime;

public record ResponseException(
		LocalDateTime timestamp,
		String message,
		String details) {

}
