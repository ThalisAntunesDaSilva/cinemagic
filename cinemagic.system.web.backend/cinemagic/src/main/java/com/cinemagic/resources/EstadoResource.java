package com.cinemagic.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinemagic.domain.Estado;
import com.cinemagic.services.EstadoService;

@RestController
@RequestMapping(value = "/estados")
public class EstadoResource {
	@Autowired
	private EstadoService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Estado>> findByState(){
		List<Estado> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}


}