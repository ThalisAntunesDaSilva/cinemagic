package com.cinemagic.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinemagic.domain.Cidade;
import com.cinemagic.domain.Cinema;
import com.cinemagic.domain.Cliente;
import com.cinemagic.domain.Sala;
import com.cinemagic.domain.Sugestao;
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
}
