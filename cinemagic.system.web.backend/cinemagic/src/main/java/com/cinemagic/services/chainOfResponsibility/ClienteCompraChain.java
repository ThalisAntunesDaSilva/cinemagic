package com.cinemagic.services.chainOfResponsibility;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.cinemagic.domain.Cliente;
import com.cinemagic.domain.Compra;
import com.cinemagic.domain.Compra.CompraBuilder;
import com.cinemagic.dto.CompraNewDTO;
import com.cinemagic.services.ClienteService;

public class ClienteCompraChain extends CompraChain{
	
	@Autowired
	private ClienteService clienteService;
	
	public ClienteCompraChain(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@Override
	public Compra rule(CompraBuilder compraBuilder, CompraNewDTO objDTO) {
		Cliente cliente = clienteService.findById(objDTO.getClienteId());
		compraBuilder.cliente(cliente);
		if(next == null) {
			compraBuilder.instante(new Date());
			return compraBuilder.getCompra();
		}
		return next.rule(compraBuilder, objDTO);
	}

}
