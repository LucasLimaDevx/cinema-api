package com.lucasdevx.cinema_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_MOVIE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title_movie", nullable = false, length = 255)
	private String title;
	
	@Column(name = "duratin_movie", nullable = false, length = 11)
	private int duration;
	
	@Column(name = "rating_movie", nullable = false, length = 2)
	private int rating;
	
	@Column(name = "genre_movie", nullable = false, length = 20)
	private String genre;
	
}
