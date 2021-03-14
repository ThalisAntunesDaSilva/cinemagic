package com.cinemagic.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cinemagic.domain.Cliente;
import com.cinemagic.dto.ClienteNewDTO;
import com.cinemagic.resources.utils.URL;
import com.cinemagic.services.ClienteService;

@RestController()
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	ClienteService service;


	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
		Cliente cliente = service.findById(id);
		return ResponseEntity.ok().body(cliente);

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Cliente> findByEmail(@RequestParam(value = "email",required = true) String email){
		String emailDecoded = URL.decodeParam(email);
		Cliente cliente = service.findByEmail(emailDecoded);
		return ResponseEntity.ok().body(cliente);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvaCliente(@Valid @RequestBody ClienteNewDTO objDTO) {
		Cliente obj = service.fromDTO(objDTO);
		service.insert(obj);
		URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(url).build();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping
	public void deletaCliente(@RequestBody Cliente cliente) {
		service.delete(cliente);
	}

	
	@PutMapping
	public Cliente editaCliente(@RequestBody Cliente cliente) {
		return service.edit(cliente);
	}

}
