package com.cinemagic.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemagic.domain.Filme;
import com.cinemagic.domain.Sala;
import com.cinemagic.domain.Sessao;
import com.cinemagic.dto.SessaoNewDTO;
import com.cinemagic.repositories.SessaoRepository;
import com.cinemagic.services.exceptions.ObjectNotFoundException;

@Service
public class SessaoService {
	@Autowired
	SessaoRepository repo;
	@Autowired
	FilmeService filmeService;

	@Autowired
	SalaService salaService;
	
	
	public Sessao findById(Integer id) {
		Optional<Sessao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado Id "+id+" Tipo "+Sessao.class.getName()));
	}
	
	public Sessao insert(Sessao sessao) {
		sessao.setId(null);
		return repo.save(sessao);
	}
	
	public Sessao updade(Sessao obj) {
		Sessao newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public Sessao fromDTO(SessaoNewDTO objDTO) {
		Filme filme = filmeService.findById(objDTO.getFilmeId());
		Sala sala = salaService.findById(objDTO.getSalaId());
		Sessao sessao = new Sessao(null, objDTO.getData(), objDTO.getHora(), objDTO.getValorInteira(), objDTO.getValorMeia(), filme, sala);
		sessao.setTrocaPorCupons(objDTO.isTrocarCupons());
		sessao.setValorEmCupons(objDTO.getValorEmCupons());
		return sessao;
	}
	
	private void updateData(Sessao newObj, Sessao obj) {
		newObj.setIngressos(obj.getIngressos());
	}
	
}
