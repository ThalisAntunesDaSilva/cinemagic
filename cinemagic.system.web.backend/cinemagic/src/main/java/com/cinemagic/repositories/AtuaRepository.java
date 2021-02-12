package com.cinemagic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemagic.domain.Atua;
@Repository
public interface AtuaRepository extends JpaRepository<Atua, Integer>{

}
