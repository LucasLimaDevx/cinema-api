package com.lucasdevx.cinema_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucasdevx.cinema_api.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{

}
