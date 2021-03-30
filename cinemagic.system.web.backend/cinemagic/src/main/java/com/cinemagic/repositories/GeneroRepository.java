package com.cinemagic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemagic.domain.Genero;
@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer>{


}
