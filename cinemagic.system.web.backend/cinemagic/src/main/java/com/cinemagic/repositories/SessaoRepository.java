package com.cinemagic.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinemagic.domain.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer>{
	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT obj FROM sessao obj JOIN obj.sala ON obj.id = obj.sala.id obj JOIN cinema ON obj.sala.cinema.id = obj.sala.id WHERE obj.sala.cinema.cidade_id = :cidadeid")
	Page<Sessao> findByCity(@Param("cidadeid") Integer id,Pageable page);
}
