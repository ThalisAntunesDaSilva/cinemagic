package com.cinemagic.services;

import com.cinemagic.domain.Cliente;
import com.cinemagic.domain.Compra;
import com.cinemagic.domain.Sessao;
import com.cinemagic.dto.xml.CheckoutDTO;

public interface IcompraStrategy {
	
	public CheckoutDTO criarPagamento(Cliente cliente, Sessao sessao, Compra compra);
	public void atualizarTransacao(String code);
}
