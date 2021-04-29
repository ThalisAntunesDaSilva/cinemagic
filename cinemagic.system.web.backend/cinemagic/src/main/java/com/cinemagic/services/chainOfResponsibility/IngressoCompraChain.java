package com.cinemagic.services.chainOfResponsibility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cinemagic.domain.Compra;
import com.cinemagic.domain.Compra.CompraBuilder;
import com.cinemagic.domain.Ingresso;
import com.cinemagic.domain.Sessao;
import com.cinemagic.domain.Enums.TipoIngresso;
import com.cinemagic.domain.Enums.TipoPagamento;
import com.cinemagic.dto.CompraNewDTO;
import com.cinemagic.dto.IngressoDTO;
import com.cinemagic.services.SessaoService;
import com.cinemagic.services.exceptions.SessaoClosedExcpetion;
import com.cinemagic.services.exceptions.SessaoFullCapacityException;

public class IngressoCompraChain extends CompraChain{
	
	private SessaoService sessaoService;
	public IngressoCompraChain(SessaoService sessaoService) {
		this.sessaoService = sessaoService;	
	}
	
	
	
	@Override
	public Compra rule(CompraBuilder compraBuilder, CompraNewDTO objDTO) {
		Compra compra = compraBuilder.getCompra();
		Sessao sessao = sessaoService.findById(objDTO.getSessaoId());
		int quantidade = 0;
		for(IngressoDTO ingressoDTO: objDTO.getIngressos() ) {
			quantidade += ingressoDTO.getQuantidade();
		}
		if ((sessao.getIngressos().size() + quantidade) > sessao.getSala().getCapacidade()) {
			throw new SessaoFullCapacityException("Sessão com capacidade máxima atingida Id" + sessao.getId());
		}
		if (sessao.isSessaoEncerrada()) {
			throw new SessaoClosedExcpetion("Sessão encerrada Id" + sessao.getId());
		}
		
		List<Ingresso> ingressos = new ArrayList<>();
		for(IngressoDTO ingressoDTO : objDTO.getIngressos()) {
			for(int i = 0; i < ingressoDTO.getQuantidade();i++) {
				Ingresso ingresso = new Ingresso(null, Integer.toString(sessao.getIngressos().size()), TipoIngresso.toEnum(ingressoDTO.getTipoIngresso()), sessao,compra );
				ingressos.add(ingresso);
				sessao.getIngressos().add(ingresso);
			}
		}
		sessaoService.updade(sessao);
		
		compra.setIngressos(ingressos);
		compra.setTipoPagamento(TipoPagamento.toEnum(objDTO.getTipoPagamento()));
		
		if(next == null) {
			
			compra.setInstante(new Date());
			return compra;
		}
		return next.rule(compraBuilder, objDTO);
	}

}
