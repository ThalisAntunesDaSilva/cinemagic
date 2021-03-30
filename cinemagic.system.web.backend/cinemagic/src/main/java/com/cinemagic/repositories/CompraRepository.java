package com.cinemagic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemagic.domain.Compra;
@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer>{

}
