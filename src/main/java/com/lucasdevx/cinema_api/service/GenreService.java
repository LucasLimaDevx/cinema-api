package com.lucasdevx.cinema_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lucasdevx.cinema_api.dto.request.GenreRequestDTO;
import com.lucasdevx.cinema_api.dto.response.GenreResponseDTO;
import com.lucasdevx.cinema_api.entity.Genre;
import com.lucasdevx.cinema_api.exception.ObjectNotFoundException;
import com.lucasdevx.cinema_api.repository.GenreRepository;

@Service
public class GenreService {
	
	private GenreRepository genreRepository;

	public GenreService(GenreRepository genreRepository) {
		this.genreRepository = genreRepository;
	}
	
	public GenreResponseDTO insert(GenreRequestDTO genreRequestDTO) {
		Genre genre = toGenre(genreRequestDTO);
		
		return toDTO(genreRepository.save(genre));
	}
	
	public GenreResponseDTO findById(Long id) {

		Genre genreDB = genreRepository.findById(id)
				.orElseThrow(()-> new ObjectNotFoundException("Object not found"));
		
		return toDTO(genreDB);
	}
	
	public List<GenreResponseDTO> findAll(){
		
		List<Genre> genres = genreRepository.findAll();
		
		
		return genres.stream().map((genre) -> {
			return toDTO(genre);
		}).collect(Collectors.toList());
	}
	
	public GenreResponseDTO update(GenreRequestDTO genreRequestDTO, Long id) {
		Genre genreDB = genreRepository.findById(id)
				.orElseThrow(()-> new ObjectNotFoundException("Object not found"));
		
		genreDB.setName(genreRequestDTO.name());
		
		
		return toDTO(genreRepository.save(genreDB));
	}
	
	public void deleteById(Long id) {
		genreRepository.deleteById(id);
	}
	
	public GenreResponseDTO toDTO(Genre genre) {
		
		return new GenreResponseDTO(genre.getId(),genre.getName());
	}
	
	public Genre toGenre(GenreRequestDTO genreRequestDTO) {
		Genre genre = new Genre();
		
		genre.setName(genreRequestDTO.name());
		
		return genre;
	}
	
	
}
