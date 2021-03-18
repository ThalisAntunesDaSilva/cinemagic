package com.cinemagic.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemagic.domain.Ingresso;
import com.cinemagic.repositories.IngressoRepository;
import com.cinemagic.services.exceptions.ObjectNotFoundException;

@Service
public class IngressoService {
	@Autowired
	IngressoRepository repo;

	public Ingresso findById(Integer id) {
		Optional<Ingresso> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado Id "+id+ " Tipo"+Ingresso.class.getName()));
			
	}
	public Ingresso insert(Ingresso ingresso) {
		ingresso.setId(null);
		return repo.save(ingresso);
	}
}
