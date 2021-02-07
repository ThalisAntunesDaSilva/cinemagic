package com.centertransmition.cinemagic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centertransmition.cinemagic.entity.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {
	Genero findById(int id);

}

