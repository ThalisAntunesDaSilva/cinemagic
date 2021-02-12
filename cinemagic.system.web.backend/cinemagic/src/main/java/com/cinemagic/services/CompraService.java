package com.cinemagic.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemagic.domain.Cliente;
import com.cinemagic.domain.Compra;
import com.cinemagic.domain.Ingresso;
import com.cinemagic.domain.Sessao;
import com.cinemagic.domain.Enums.TipoIngresso;
import com.cinemagic.dto.CompraNewDTO;
import com.cinemagic.dto.IngressoDTO;
import com.cinemagic.repositories.CompraRepository;
import com.cinemagic.repositories.IngressoRepository;
import com.cinemagic.services.exceptions.ObjectNotFoundException;
import com.cinemagic.services.rn.CompraRN;

@Service
public class CompraService {
	@Autowired
	private CompraRepository repo;
	@Autowired
	private SessaoService sessaoService;
	@Autowired
	private IngressoRepository ingressoRepository;
	@Autowired
	private ClienteService clienteService;
	public Compra findById(Integer id) {
		Optional<Compra> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado ID:"+id+"Tipo "+Compra.class.getName()));
	}
	public Compra insert(Compra compra) {
		compra.setId(null);
		ingressoRepository.saveAll(compra.getIngressos());
		compra = repo.save(compra);
		return compra;
		
	}
	public Compra fromDTO(CompraNewDTO objDto) {
		Cliente cliente = clienteService.findById(objDto.getClienteId());
		Sessao sessao = sessaoService.findById(objDto.getSessaoId());
		int quantidade = getQuantidadeIngressos(objDto.getIngressos());
		CompraRN.validarRN(sessao,quantidade);
		Compra compra = new Compra(null, new Date(), cliente);
		for(IngressoDTO i: objDto.getIngressos()) {
			for(int index = 0; index < i.getQuantidade(); index++) {
				Ingresso ingresso = new Ingresso(null,Integer.toString(sessao.getIngressos().size()+1),TipoIngresso.toEnum(i.getTipoIngresso()),sessao,compra);
				sessao.getIngressos().add(ingresso);
				compra.getIngressos().add(ingresso);
			}
			
		}
		sessaoService.updade(sessao);
		return compra;
	}
	private int getQuantidadeIngressos(List<IngressoDTO> ingressos) {
		int quantidade = 0;
		for(IngressoDTO i : ingressos) {
			quantidade += i.getQuantidade();
		}
		return quantidade;
	}
	
}
