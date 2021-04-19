package com.cinemagic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinemagic.domain.Cidade;
@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT obj FROM Cidade obj WHERE obj.estado.id = :estado_id")
	List<Cidade> findByEstado(@Param("estado_id") Integer estado_id);
}
