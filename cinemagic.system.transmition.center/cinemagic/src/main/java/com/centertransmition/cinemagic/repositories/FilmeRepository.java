package com.centertransmition.cinemagic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centertransmition.cinemagic.entity.Filme;



public interface FilmeRepository extends JpaRepository<Filme, Integer> {
	Filme findById(int id);
}