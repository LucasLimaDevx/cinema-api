package com.lucasdevx.cinema_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucasdevx.cinema_api.entity.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long>{

}
