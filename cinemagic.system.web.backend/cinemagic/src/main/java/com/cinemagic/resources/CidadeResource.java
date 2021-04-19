package com.cinemagic.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinemagic.domain.Cidade;
import com.cinemagic.services.CidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeResource {
	@Autowired
	private CidadeService service;


	@RequestMapping(value = "/{idState}", method = RequestMethod.GET)
	public ResponseEntity<List<Cidade>> findByState(@PathVariable Integer idState){
		List<Cidade> obj = service.findByState(idState);
		return ResponseEntity.ok().body(obj);
	}


}