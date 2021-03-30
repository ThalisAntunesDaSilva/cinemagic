package com.centertransmition.cinemagic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.centertransmition.cinemagic.entity.Ator;



public interface AtorRepository extends JpaRepository<Ator, Integer> {
	Ator findById(int id);
}
