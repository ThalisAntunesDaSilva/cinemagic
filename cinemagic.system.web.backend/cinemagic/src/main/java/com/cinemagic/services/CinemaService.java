package com.cinemagic.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinemagic.domain.Cidade;
import com.cinemagic.domain.Cinema;
import com.cinemagic.domain.Sala;
import com.cinemagic.dto.CinemaDTO;
import com.cinemagic.dto.CinemaNewDTO;
import com.cinemagic.repositories.CinemaRepository;
import com.cinemagic.repositories.SalaRepository;
import com.cinemagic.services.exceptions.ObjectNotFoundException;

@Service
public class CinemaService {
	@Autowired
	private CinemaRepository repo;
	@Autowired
	private CidadeService cidadeService;
	@Autowired
	private SalaRepository salaRepository;
	@Transactional
	public Cinema insert(Cinema cinema) {
		cinema.setId(null);
		salaRepository.saveAll(cinema.getSalas());
		return repo.save(cinema);
	}
	
	public Cinema findById(Integer id) {
		Optional<Cinema> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado Id: "+id+" Tipo: "+Cinema.class.getName()));
	}
	public List<CinemaDTO> findAll(){
		List<Cinema> cinemas = repo.findAll();
		List<CinemaDTO> cinemasDTO = new ArrayList<>();
		List<Integer> salasIds = new ArrayList<>();
		cinemas.stream().forEach(obj -> obj.getSalas().stream().forEach(objSala -> salasIds.add(objSala.getId())));
		cinemas.stream().forEach(obj -> cinemasDTO.add(new CinemaDTO(obj.getId(), obj.getNome(), obj.getCidade().getId(), salasIds)));
		return cinemasDTO;
	}
	

	public Cinema update(Cinema obj) {
		Cinema newObj = findById(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	public Cinema fromDTO(CinemaDTO objDTO) {
		return new Cinema(objDTO.getId(), objDTO.getNome(), null);
	}
	
	@Transactional
	public Cinema fromDTO(CinemaNewDTO objDTO) {
		Cidade cidade = cidadeService.findById(objDTO.getCidadeId());
		Cinema cinema = new Cinema(null, objDTO.getNome(), cidade);
		objDTO.getSalas().stream().map((obj)-> cinema.getSalas().add(new Sala(null, obj.getNumero(), obj.getCapacidade(), cinema)));
		return cinema;
	}
	
	
	private void updateData(Cinema newObj,Cinema obj) {
		newObj.setNome(obj.getNome());
		newObj.getSalas().addAll(obj.getSalas());
	}
	
	
}
