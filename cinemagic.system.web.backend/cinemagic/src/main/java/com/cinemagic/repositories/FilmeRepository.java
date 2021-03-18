package com.cinemagic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemagic.domain.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer>{

	//metodo que procura uma sugestao apenas pelo id
	Filme findById(int id);
}
