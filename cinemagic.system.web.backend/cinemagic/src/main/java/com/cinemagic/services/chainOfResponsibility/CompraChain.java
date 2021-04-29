package com.cinemagic.services.chainOfResponsibility;

import org.springframework.beans.factory.annotation.Autowired;

import com.cinemagic.domain.Compra;
import com.cinemagic.domain.Compra.CompraBuilder;
import com.cinemagic.domain.Sessao;
import com.cinemagic.dto.CompraNewDTO;
import com.cinemagic.services.SessaoService;

public abstract class CompraChain {
	protected CompraChain next;
	
	public CompraChain setNext(CompraChain next) {
		this.next = next;
		return next;
	}
	
	public abstract Compra rule(CompraBuilder compraBuilder,CompraNewDTO objDTO);
	
	

}
