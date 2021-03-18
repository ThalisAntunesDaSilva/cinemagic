package com.cinemagic.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cinemagic.domain.Compra;
import com.cinemagic.domain.Enums.TipoPagamento;
import com.cinemagic.dto.CompraNewDTO;
import com.cinemagic.dto.xml.CheckoutDTO;
import com.cinemagic.services.CompraService;
import com.cinemagic.services.PagSeguroService;

@RestController()
@RequestMapping(value = "/compras")
public class CompraResource {
	@Autowired
	CompraService service;
	@Autowired
	PagSeguroService pagSeguroService;
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Compra> findById(@PathVariable Integer id) {
		Compra obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<CheckoutDTO> insert(@RequestBody CompraNewDTO compra) {
		Compra obj = service.fromDTO(compra);
		service.insert(obj);
		URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		CheckoutDTO checkout = null;
		if(compra.getTipoPagamento() == 0) {
			checkout = pagSeguroService.criarPagamento(obj.getCliente(),obj);
		}
		return ResponseEntity.created(url).body(checkout);
	}
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Compra>> listaClientes() {
		return ResponseEntity.ok().body(service.findAll());
	}

}
