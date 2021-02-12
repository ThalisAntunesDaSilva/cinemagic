package com.cinemagic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemagic.domain.Pais;
@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer>{

}
