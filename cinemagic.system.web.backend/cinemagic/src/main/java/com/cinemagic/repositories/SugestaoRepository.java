package com.cinemagic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemagic.domain.Sugestao;

@Repository
public interface SugestaoRepository extends JpaRepository<Sugestao, Integer> {

	//metodo que procura uma sugestao apenas pelo id
	Sugestao findById(int id);
}
