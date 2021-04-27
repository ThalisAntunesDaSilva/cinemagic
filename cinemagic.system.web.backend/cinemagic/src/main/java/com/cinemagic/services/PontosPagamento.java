package com.cinemagic.services;

import com.cinemagic.domain.Cliente;
import com.cinemagic.domain.Compra;
import com.cinemagic.domain.Sessao;
import com.cinemagic.domain.Enums.TipoPagamento;
import com.cinemagic.dto.xml.CheckoutDTO;
import com.cinemagic.services.exceptions.InsufficientCouponException;
import com.cinemagic.services.exceptions.PromotionClosedException;

public class PontosPagamento implements IcompraStrategy{

	public static void validarPagamento(Compra compra, Sessao sessao,Cliente cliente) {
		}

	@Override
	public CheckoutDTO criarPagamento(Cliente cliente, Sessao sessao, Compra compra) {
		if(compra.getTipoPagamento() == TipoPagamento.PONTOS) {
			if(!sessao.isTrocaPorCupons()) {
				throw new PromotionClosedException("Essa sessão não está com promoção disponível");
			}
			if(cliente.getPontos() < sessao.getValorEmCupons()) {
				throw new InsufficientCouponException("Cliente não tem pontos suficientes");
			}
	
}
	}

	@Override
	public void atualizarTransacao(String code) {
		// TODO Auto-generated method stub
		
	}
}