package com.cinemagic.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemagic.domain.Sessao;
import com.cinemagic.repositories.SessaoRepository;
import com.cinemagic.services.exceptions.ObjectNotFoundException;

@Service
public class SessaoService {
	@Autowired
	SessaoRepository repo;
	
	public Sessao findById(Integer id) {
		Optional<Sessao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado Id "+id+" Tipo "+Sessao.class.getName()));
	}
	
	public Sessao updade(Sessao obj) {
		Sessao newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Sessao newObj, Sessao obj) {
		newObj.setIngressos(obj.getIngressos());
	}
	
}
