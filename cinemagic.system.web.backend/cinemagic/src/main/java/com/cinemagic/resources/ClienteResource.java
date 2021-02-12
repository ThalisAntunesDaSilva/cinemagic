package com.cinemagic.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinemagic.domain.Cliente;

@RestController()
@RequestMapping(value = "/clientes")
public class ClienteResource {

	
	@RequestMapping(value ="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Cliente> findById(@PathVariable Integer id){
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Cliente cliente){
		return null;
	}
	
	
}
