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

import com.cinemagic.domain.Sugestao;
import com.cinemagic.dto.CinemaDTO;
import com.cinemagic.dto.SugestaoDTO;
import com.cinemagic.repositories.SugestaoRepository;
import com.cinemagic.services.CinemaService;
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
	
	@GetMapping("/sugestoes")
	public List<Sugestao> listaSugestoes(){
		return repo.findAll();
		
	}
	
	@GetMapping("/sugestao/{id}")
	public Sugestao sugestaoUnica(@PathVariable(value = "id") int id) {
		return repo.findById(id);
		
	}
	
	@PostMapping("/sugestao")
	public Sugestao salvarSugestao(@RequestBody Sugestao sugestao) {
		return repo.save(sugestao);
	}
	
	@DeleteMapping("/sugestao")
	public void deletarSugestao(@RequestBody Sugestao sugestao) {
		repo.delete(sugestao);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Sugestao> update(@RequestBody SugestaoDTO objDTO,@PathVariable Integer id){
		Sugestao sugestao = service.fromDTO(objDTO);
		sugestao.setId(id);
		sugestao = service.update(sugestao);
		return ResponseEntity.ok().body(sugestao);
		
	}
	
	@PutMapping("/sugestao")
	public Sugestao atualizarSugestao(@RequestBody Sugestao sugestao) {
		return repo.save(sugestao);
	}
	
}
