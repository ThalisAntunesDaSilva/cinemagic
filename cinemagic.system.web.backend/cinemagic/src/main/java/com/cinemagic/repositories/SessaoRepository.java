package com.cinemagic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cinemagic.domain.Sessao;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer>{
	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT obj FROM Sessao obj INNER JOIN obj.sala sala ON obj.sala.id = sala.id INNER JOIN sala.cinema cinema ON cinema.id = sala.cinema.id WHERE cinema.cidade.id = :cidade_id")
	List<Sessao> findByCity(@Param("cidade_id") Integer cidade_id);

	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT obj FROM Sessao obj INNER JOIN obj.filme filme ON obj.filme.id = filme.id WHERE filme.titulo LIKE :filme%")
	List<Sessao> findByFilme(@Param("filme") String filme);
	
	@Transactional(readOnly = true)
	@Query("SELECT DISTINCT obj FROM Sessao obj INNER JOIN obj.sala sala ON obj.sala.id = sala.id INNER JOIN sala.cinema cinema ON cinema.id = sala.cinema.id WHERE cinema.cidade.nome LIKE :cidade_nome%")
	List<Sessao> findByCityName(@Param("cidade_nome") String cidade_nome);
	
	
}
