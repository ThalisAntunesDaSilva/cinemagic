package com.cinemagic.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cinemagic.domain.Filme;
import com.cinemagic.domain.Genero;
import com.cinemagic.domain.Sala;
import com.cinemagic.dto.FilmeDTO;
import com.cinemagic.dto.FilmeNewDTO;
import com.cinemagic.repositories.FilmeRepository;
import com.cinemagic.services.exceptions.ObjectNotFoundException;

@Service
public class FilmeService {
	@Autowired
	FilmeRepository repo;
	
	@Autowired
	private GeneroService GeneroService;

	public Filme findById(Integer id) {
		Optional<Filme> obj = repo.findById(id);
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado Id " + id + " Tipo" + Filme.class.getName()));
	}

	// Procura todos
	public List<Filme> findAll() {
		return repo.findAll();
	}

	public Filme update(Filme obj) {
		Filme newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

	private void updateData(Filme newObj, Filme obj) {
		newObj.setTitulo(obj.getTitulo());
		newObj.setDuracao(obj.getDuracao());
	}

	public Filme insert(Filme filme) {
		filme.setId(null);
		return repo.save(filme);
	}
	
	
	public Filme fromDTO(FilmeDTO objDto) {
		return new Filme(null, objDto.getTitulo(), objDto.getDuracao(), objDto.getGenero());
	
	}
	
	
	@Transactional
	public Filme fromDTO(FilmeNewDTO objDto) {
		Genero newGenero = objDto.getGenero();
		Filme f = new Filme(null, objDto.getTitulo(), objDto.getDuracao(), objDto.getGenero());
		
		//List<Genero> generos = objDto.getGeneros().stream().map(obj -> new Genero(null, obj.getDescricao())).collect(Collectors.toList());
		//f.setGeneros(generos);
		return f;
	}

}
