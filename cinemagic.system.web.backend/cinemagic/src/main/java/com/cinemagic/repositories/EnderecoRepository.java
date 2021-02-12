package com.cinemagic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cinemagic.domain.Endereco;
@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}
