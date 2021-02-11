package com.cinemagic.services.rn;

import com.cinemagic.domain.Compra;
import com.cinemagic.domain.Sessao;
import com.cinemagic.services.exceptions.SessaoClosedExcpetion;
import com.cinemagic.services.exceptions.SessaoFullCapacityException;

public class CompraRN {

	public static void validarRN(Compra compra, Sessao sessao) {
		if (sessao.getIngressos().size() >= sessao.getSala().getCapacidade()) {
			throw new SessaoFullCapacityException("Sessão com capacidade máxima atingida ID"+sessao.getId());
		}
		if(sessao.isSessaoEncerrada()) {
			throw new SessaoClosedExcpetion("Sessão encerrada Id"+sessao.getId());
		}
	}

}
