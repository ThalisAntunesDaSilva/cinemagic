package com.cinemagic.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.cinemagic.domain.Compra;
import com.cinemagic.dto.CompraNewDTO;
import com.cinemagic.services.CompraService;

@RestController()
@RequestMapping(value = "/compras")
public class CompraResource {
	@Autowired
	CompraService service;

	// V
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Compra> findById(@PathVariable Integer id) {
		Compra obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	// V
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody CompraNewDTO compra) {
		Compra obj = service.fromDTO(compra);
		service.insert(obj);
		URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(url).build();
	}
	
	// V
	@GetMapping
	public ResponseEntity<List<Compra>> listaClientes() {
		return ResponseEntity.ok().body(service.findAll());
	}

	// V
	@DeleteMapping
	public void deletaCompra(@RequestBody Compra compra) {
		service.delete(compra);
	}

	
	@PutMapping
	public Compra editaCompra(@RequestBody Compra compra) {
		return service.edit(compra);
	}

}
