package com.cinemagic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemagic.domain.Cinema;
@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer>{

}
