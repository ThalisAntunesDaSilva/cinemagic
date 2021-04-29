package com.cinemagic.services.chainOfResponsibility;

import java.util.Date;

import com.cinemagic.domain.Cliente;
import com.cinemagic.domain.Compra;
import com.cinemagic.domain.Compra.CompraBuilder;
import com.cinemagic.domain.Sessao;
import com.cinemagic.domain.Enums.TipoPagamento;
import com.cinemagic.dto.CompraNewDTO;
import com.cinemagic.services.ClienteService;
import com.cinemagic.services.SessaoService;
import com.cinemagic.services.exceptions.InsufficientCouponException;
import com.cinemagic.services.exceptions.PromotionClosedException;

public class PagamentoCompraChain extends CompraChain {
	private SessaoService sessaoService;
	private ClienteService clienteService;
	public PagamentoCompraChain(SessaoService sessaoService,ClienteService clienteService) {
		this.sessaoService = sessaoService;
		this.clienteService = clienteService;
	}
	
	@Override
	public Compra rule(CompraBuilder compraBuilder, CompraNewDTO objDTO) {
		Sessao sessao = sessaoService.findById(objDTO.getSessaoId());
		Cliente cliente = clienteService.findById(objDTO.getClienteId());
		if (TipoPagamento.toEnum(objDTO.getTipoPagamento()).equals(TipoPagamento.PONTOS)) {
			if (!sessao.isTrocaPorCupons()) {
				throw new PromotionClosedException("Essa sessão não está com promoção disponível");
			}
			if (cliente.getPontos() < sessao.getValorEmCupons()) {
				throw new InsufficientCouponException("Cliente não tem pontos suficientes");
			}
			cliente.setPontos(cliente.getPontos() - sessao.getValorEmCupons());
			compraBuilder.cliente(cliente);
		}
		
		
		if(next == null) {
			compraBuilder.instante(new Date());
			return compraBuilder.getCompra();
		}
		return next.rule(compraBuilder, objDTO);
	}

}
