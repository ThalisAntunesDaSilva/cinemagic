package com.cinemagic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemagic.domain.Sala;
@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer>{

}
