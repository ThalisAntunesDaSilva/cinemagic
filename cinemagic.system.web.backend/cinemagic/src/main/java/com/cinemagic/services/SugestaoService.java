package com.cinemagic.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinemagic.domain.Cidade;
import com.cinemagic.domain.Cinema;
import com.cinemagic.domain.Cliente;
import com.cinemagic.domain.Sala;
import com.cinemagic.domain.Sugestao;
import com.cinemagic.dto.CinemaDTO;
import com.cinemagic.dto.CinemaNewDTO;
import com.cinemagic.dto.SugestaoDTO;
import com.cinemagic.repositories.SugestaoRepository;
import com.cinemagic.services.exceptions.ObjectNotFoundException;

@Service
public class SugestaoService {
	
	@Autowired
	SugestaoRepository repo;
	@Autowired
	private ClienteService clienteservic;
	
	
	public Sugestao findById(Integer id) {
		Optional<Sugestao> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado Id: "+id+" Tipo: "+Sugestao.class.getName()));
	}

	public Sugestao  update(Sugestao  obj) {
		Sugestao  newObj = findById(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	@Transactional
	public Sugestao fromDTO(SugestaoDTO objDTO) {
		Cliente cliente = clienteservic.findById(objDTO.getId());
		Sugestao sugestao = new Sugestao(null, objDTO.getSugestao(), cliente);		
		return sugestao;
	}
	
	
	private void updateData(Sugestao newObj, Sugestao obj) {
		newObj.setAutor(obj.getAutor());
		newObj.setSugestao(obj.getSugestao());
	}
	
	public List<SugestaoDTO> findAll(){
		List<Sugestao> sugestao = repo.findAll();
		List<SugestaoDTO> sugestaoDTO = new ArrayList<>();
		List<Integer> sugestoesIds = new ArrayList<>();
		sugestao.stream().forEach(obj -> sugestaoDTO.add(new SugestaoDTO(obj.getId(), obj.getSugestao(), obj.getAutor())));
		
		
		return sugestaoDTO;
	}
}
