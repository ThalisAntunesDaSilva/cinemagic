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

import com.cinemagic.domain.Cliente;
import com.cinemagic.domain.Compra;
import com.cinemagic.domain.Filme;
import com.cinemagic.dto.CompraNewDTO;
import com.cinemagic.dto.FilmeDTO;
import com.cinemagic.services.CompraService;
import com.cinemagic.services.FilmeService;

@RestController()
@RequestMapping(value = "/filmes")
public class FilmeResource {

	@Autowired
	FilmeService filmeService;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Filme> findById(@PathVariable Integer id){
		Filme obj = filmeService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody FilmeDTO filme){
		Filme obj = filmeService.fromDTO(filme);
		filmeService.insert(obj);
		URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(url).build();
	}
}
