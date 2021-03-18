package com.cinemagic.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinemagic.domain.Compra;
import com.cinemagic.domain.Genero;
import com.cinemagic.domain.Sessao;
import com.cinemagic.repositories.GeneroRepository;
import com.cinemagic.services.exceptions.ObjectNotFoundException;

@Service
public class GeneroService {
	
	@Autowired
	GeneroRepository repo;
	
	public Genero findById(Integer id) {
		Optional<Genero> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado Id "+id+" Tipo "+Sessao.class.getName()));
	}
	
	
	public Genero updade(Genero obj) {
		Genero newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Genero newObj, Genero obj) {
		newObj.setDescricao(obj.getDescricao());
	}
	
}
