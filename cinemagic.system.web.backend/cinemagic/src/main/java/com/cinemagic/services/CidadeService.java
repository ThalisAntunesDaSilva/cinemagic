package com.cinemagic.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemagic.domain.Cidade;
import com.cinemagic.repositories.CidadeRepository;
import com.cinemagic.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
	@Autowired
	private CidadeRepository repo;
	
	public Cidade findById(Integer id) {
		Optional<Cidade> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado Id: "+id+ " Tipo: " +Cidade.class.getName()));
	}
	
	
}
