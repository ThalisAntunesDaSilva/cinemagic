package com.cinemagic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemagic.domain.Estado;
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
