package com.cinemagic.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinemagic.domain.Cliente;
import com.cinemagic.services.ClienteService;

@RestController()
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	ClienteService service;

	@GetMapping
	public ResponseEntity<List<Cliente>> listaClientes() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
		Cliente cliente = service.findById(id);
		return ResponseEntity.ok().body(cliente);

	}

	@PostMapping
	public Cliente salvaCliente(@RequestBody Cliente cliente) {
		return service.save(cliente);

	}

	@DeleteMapping
	public void deletaCliente(@RequestBody Cliente cliente) {
		service.delete(cliente);
	}

	@PutMapping
	public Cliente editaCliente(@RequestBody Cliente cliente) {
		return service.edit(cliente);
	}

}
