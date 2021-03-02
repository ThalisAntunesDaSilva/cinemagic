package com.cinemagic.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cinemagic.domain.Sugestao;
import com.cinemagic.dto.SugestaoDTO;
import com.cinemagic.repositories.SugestaoRepository;
import com.cinemagic.services.SugestaoService;

/*
 * Essa classe trabalha como controller, vai receber as requisiçoes HTTP
 */
@RestController
@RequestMapping(value = "/sugestao")
public class SugestaoResource {

	//criar um ponto de ingesao do nosso repository 
	@Autowired
	SugestaoRepository repo;
	@Autowired
	private SugestaoService service;
	
	//att 0.3
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SugestaoDTO>> listaSugestoes(){
		List<SugestaoDTO> objDTO = service.findAll();
		return ResponseEntity.ok().body(objDTO);
	}
	
	//att 0.3
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Sugestao> sugestaoUnica(@PathVariable Integer id){
		Sugestao sugestao = service.findById(id);
		return ResponseEntity.ok().body(sugestao);
	}
	
	//attvesao 0.3
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvarSugestao(@RequestBody SugestaoDTO objDTO){
		Sugestao sugestao = service.fromDTO(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sugestao.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	//att versao 0.3
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletarSugestao(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//att versao 0.3
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Sugestao> update(@RequestBody SugestaoDTO objDTO,@PathVariable Integer id){
		Sugestao sugestao = service.fromDTO(objDTO);
		sugestao.setId(id);
		sugestao = service.update(sugestao);
		return ResponseEntity.ok().body(sugestao);
		
	}
	
}
