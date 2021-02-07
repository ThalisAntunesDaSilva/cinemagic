package com.centertransmition.cinemagic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centertransmition.cinemagic.entity.Atua;

public interface AtuaRepository extends JpaRepository<Atua, Integer> {
	Atua findById(int id);
}

