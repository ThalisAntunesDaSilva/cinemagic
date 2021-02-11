package com.cinemagic.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemagic.domain.Compra;
import com.cinemagic.domain.Ingresso;
import com.cinemagic.domain.Sessao;
import com.cinemagic.domain.Enums.TipoIngresso;
import com.cinemagic.repositories.CompraRepository;
import com.cinemagic.services.exceptions.ObjectNotFoundException;
import com.cinemagic.services.rn.CompraRN;

@Service
public class CompraService {
	@Autowired
	CompraRepository repo;
	@Autowired
	SessaoService sessaoService;
	@Autowired
	IngressoService ingressoService;
	public Compra findById(Integer id) {
		Optional<Compra> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado ID:"+id+"Tipo "+Compra.class.getName()));
	}
	public Compra insert(Compra compra,Integer idSessao,Integer tipoIngresso) {
		compra.setId(null);
		Sessao sessao = sessaoService.findById(idSessao);
		CompraRN.validarRN(compra, sessao);
		Ingresso ingresso = new Ingresso(null,Integer.toString(sessao.getIngressos().size()+1),TipoIngresso.toEnum(tipoIngresso),sessao,compra);
		ingresso = ingressoService.insert(ingresso);
		sessao.getIngressos().add(ingresso);
		compra.getIngressos().add(ingresso);
		return compra;
		
	}
	
}
