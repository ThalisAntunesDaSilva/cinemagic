package com.cinemagic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemagic.domain.Cidade;
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

}
