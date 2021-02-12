package com.cinemagic.services.rn;

import com.cinemagic.domain.Sessao;
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

}
