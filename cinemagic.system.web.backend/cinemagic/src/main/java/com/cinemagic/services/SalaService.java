package com.cinemagic.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemagic.domain.Sala;
import com.cinemagic.repositories.SalaRepository;
import com.cinemagic.services.exceptions.ObjectNotFoundException;

@Service
public class SalaService {
	
	@Autowired
	SalaRepository repo;
	
	public Sala findById(Integer id) {
		Optional<Sala> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado Id: "+id+" Tipo: "+Sala.class.getName()));
	}
		
	
	
}
