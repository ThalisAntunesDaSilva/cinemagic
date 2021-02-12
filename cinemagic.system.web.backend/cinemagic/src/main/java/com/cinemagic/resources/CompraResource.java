package com.cinemagic.resources;


import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	CompraService compraService;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Compra> findById(@PathVariable Integer id){
		Compra obj = compraService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	public ResponseEntity<Void> insert(@RequestBody CompraNewDTO compra){
		Compra obj = compraService.fromDTO(compra);
		compraService.insert(obj);
		URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(url).build();
	}
	
}
