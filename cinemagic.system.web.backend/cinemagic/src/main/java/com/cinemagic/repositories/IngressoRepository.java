package com.cinemagic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemagic.domain.Ingresso;

@Repository
public interface IngressoRepository extends JpaRepository<Ingresso, Integer>{
	
}
