package com.cinemagic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinemagic.domain.Compra;
import com.cinemagic.domain.Compra.CompraBuilder;
import com.cinemagic.dto.CompraNewDTO;
import com.cinemagic.dto.IngressoDTO;
import com.cinemagic.repositories.CompraRepository;
import com.cinemagic.repositories.IngressoRepository;
import com.cinemagic.security.UserSS;
import com.cinemagic.services.chainOfResponsibility.ClienteCompraChain;
import com.cinemagic.services.chainOfResponsibility.CompraChain;
import com.cinemagic.services.chainOfResponsibility.IngressoCompraChain;
import com.cinemagic.services.chainOfResponsibility.PagamentoCompraChain;
import com.cinemagic.services.exceptions.AuthorizationException;
import com.cinemagic.services.exceptions.ObjectNotFoundException;

@Service
public class CompraService {
	@Autowired
	private CompraRepository repo;
	@Autowired
	private IngressoRepository ingressoRepository;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private SessaoService sessaoService;
	
	public Compra findById(Integer id) {
		Optional<Compra> obj = repo.findById(id);
		UserSS user = UserService.authenticated();
		if(obj.get() != null && !obj.get().getCliente().getId().equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		return obj.orElseThrow(
				() -> new ObjectNotFoundException("Objeto não encontrado ID:" + id + "Tipo " + Compra.class.getName()));
	}

	@Transactional
	public Compra insert(Compra compra) {
		compra.setId(null);
		ingressoRepository.saveAll(compra.getIngressos());
		clienteService.update(compra.getCliente());
		compra = repo.save(compra);
		return compra;
	}

	@Transactional
	public Compra update(Compra compra) {	
		Compra newObj = findById(compra.getId());
		updateData(newObj, compra);
		newObj = repo.save(newObj);
		return newObj;
	}

	
	
	// Procura todos
		public List<Compra> findAll() {
			return repo.findAll();
		}

		// Exclui
		public void delete(Integer id) {	
			repo.deleteById(id);
		}
	
	@Transactional
	public Compra fromDTO(CompraNewDTO objDto) {
		CompraBuilder compraBuilder = new Compra.CompraBuilder();
		CompraChain compraChain = new ClienteCompraChain(clienteService);
		compraChain.setNext(new PagamentoCompraChain(sessaoService,clienteService)).setNext(new IngressoCompraChain(sessaoService));
		Compra compra = compraChain.rule(compraBuilder, objDto);
		return compra;
//		Cliente cliente = clienteService.findById(objDto.getClienteId());
//		Sessao sessao = sessaoService.findById(objDto.getSessaoId());
//		int quantidade = getQuantidadeIngressos(objDto.getIngressos());
//		CompraRN.validarRN(sessao, quantidade);
//		Compra compra = new Compra(null, new Date(), cliente, TipoPagamento.toEnum(objDto.getTipoPagamento()));
//		CompraRN.validarPagamento(compra, sessao, cliente);
//		for (IngressoDTO i : objDto.getIngressos()) {
//			for (int index = 0; index < i.getQuantidade(); index++) {
//				Ingresso ingresso = new Ingresso(null, Integer.toString(sessao.getIngressos().size() + 1),
//						TipoIngresso.toEnum(i.getTipoIngresso()), sessao, compra);
//				sessao.getIngressos().add(ingresso);
//				compra.getIngressos().add(ingresso);
//
//			}
//
//		}
//		if (compra.getTipoPagamento().equals(TipoPagamento.PONTOS)) {
//			compra.getCliente().setPontos(compra.getCliente().getPontos() - sessao.getValorEmCupons());
//		}
//		cliente.getCompras().add(compra);
//		sessaoService.updade(sessao);
//		return compra;
	}

	private int getQuantidadeIngressos(List<IngressoDTO> ingressos) {
		int quantidade = 0;
		for (IngressoDTO i : ingressos) {
			quantidade += i.getQuantidade();
		}
		return quantidade;
	}
	
	private void updateData(Compra newObj, Compra obj) {
		newObj.setStatusCompra(obj.getStatusCompra());
	}

}
