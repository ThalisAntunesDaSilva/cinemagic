package com.centertransmition.cinemagic.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.centertransmition.cinemagic.entity.Filme;
import com.centertransmition.cinemagic.services.FilmeService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "")

@RequestMapping(value = "/filmes")
public class FilmeResource {
	@Autowired
	FilmeService service;

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ResponseEntity<List<Filme>> listaFilmes() {
		List<Filme> obj = service.findAll();
		return ResponseEntity.ok().body(obj);
	}
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Filme> buscarFilme(@PathVariable int id) {
		Filme obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	

}
