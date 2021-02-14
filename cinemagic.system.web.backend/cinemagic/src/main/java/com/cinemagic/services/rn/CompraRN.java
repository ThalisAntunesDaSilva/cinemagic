package com.cinemagic.services.rn;

import com.cinemagic.domain.Cliente;
import com.cinemagic.domain.Compra;
import com.cinemagic.domain.Sessao;
import com.cinemagic.domain.Enums.TipoPagamento;
import com.cinemagic.services.exceptions.InsufficientCouponException;
import com.cinemagic.services.exceptions.PromotionClosedException;
import com.cinemagic.services.exceptions.SessaoClosedExcpetion;
import com.cinemagic.services.exceptions.SessaoFullCapacityException;

public class CompraRN {

	public static void validarRN(Sessao sessao,int quantidade) {
		if ((sessao.getIngressos().size()+quantidade) > sessao.getSala().getCapacidade()) {
			throw new SessaoFullCapacityException("Sessão com capacidade máxima atingida Id"+sessao.getId());
		}
		if(sessao.isSessaoEncerrada()) {
			throw new SessaoClosedExcpetion("Sessão encerrada Id"+sessao.getId());
		}
	}
	public static void validarPagamento(Compra compra, Sessao sessao,Cliente cliente) {
		if(compra.getTipoPagamento() == TipoPagamento.PONTOS) {
			if(!sessao.isTrocaPorCupons()) {
				throw new PromotionClosedException("Essa sessão não está com promoção disponível");
			}
			if(cliente.getPontos() < sessao.getValorEmCupons()) {
				throw new InsufficientCouponException("Cliente não tem pontos suficientes");
			}
		}
	}

}
