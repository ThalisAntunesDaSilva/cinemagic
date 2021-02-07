package com.centertransmition.cinemagic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.centertransmition.cinemagic.entity.Filme;
import com.centertransmition.cinemagic.repositories.FilmeRepository;
import com.centertransmition.cinemagic.services.expetions.ObjectNotFoundException;
import com.centertransmition.cinemagic.services.interfaces.FilmeInterface;

@Service
public class FilmeService implements FilmeInterface{
	@Autowired
	private FilmeRepository repo;

	@Override
	public Filme findById(Integer id) {
		Optional<Filme> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objecto não encontrado Id: "+id+" Tipo: "+Filme.class.getName()));
	}
	@Override
	public List<Filme> findAll() {
		return repo.findAll();	
	}
	
}
