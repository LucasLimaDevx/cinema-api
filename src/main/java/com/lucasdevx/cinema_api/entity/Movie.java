package com.lucasdevx.cinema_api.entity;

import java.io.Serializable;

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
public class Movie implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "movie_title", nullable = false, length = 255)
	private String title;
	
	@Column(name = "movie_duration", nullable = false, length = 11)
	private int duration;
	
	@Column(name = "movie_rating", nullable = false, length = 2)
	private int rating;
	
}
