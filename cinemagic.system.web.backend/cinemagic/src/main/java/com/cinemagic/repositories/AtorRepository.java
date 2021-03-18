package com.cinemagic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemagic.domain.Ator;

@Repository
public interface AtorRepository extends JpaRepository<Ator, Integer> {

}
