package com.cinemagic.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinemagic.domain.Filme;
import com.cinemagic.domain.Genero;
import com.cinemagic.domain.Sessao;
import com.cinemagic.dto.FilmeDTO;
import com.cinemagic.dto.FilmeNewDTO;
import com.cinemagic.dto.GeneroDTO;
import com.cinemagic.dto.GeneroNewDTO;
import com.cinemagic.repositories.GeneroRepository;
import com.cinemagic.services.exceptions.ObjectNotFoundException;

@Service
public class GeneroService {

	@Autowired
	GeneroRepository repo;

	public Genero findById(Integer id) {
		Optional<Genero> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado Id " + id + " Tipo" + Filme.class.getName()));
	}

	// Procura todos
	public List<Genero> findAll() {
		return repo.findAll();
	}

	public Genero update(Genero obj) {
		Genero newObj = findById(obj.getId());
		updadeData(newObj, obj);
		return repo.save(newObj);
	}

	public void updadeData(Genero newObj, Genero obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setFilmes(obj.getFilmes());
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

	public Genero insert(Genero genero) {
		genero.setId(null);
		return repo.save(genero);
	}

	public Genero fromDTO(GeneroDTO objDto) {
		return new Genero(null, objDto.getDescricao());

	}

	@Transactional
	public Genero fromDTO(GeneroNewDTO objDto) {
		Genero genero = new Genero(null, objDto.getDescricao());
		return genero;
	}

}
