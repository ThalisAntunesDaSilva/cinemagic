package com.cinemagic.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinemagic.domain.Sugestao;
import com.cinemagic.repositories.SugestaoRepository;

/*
 * Essa classe trabalha como controller, vai receber as requisiçoes HTTP
 */
@RestController
@RequestMapping(value = "/sugestao")
public class SugestaoResource {

	//criar um ponto de ingesao do nosso repository 
	@Autowired
	SugestaoRepository repo;
	
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
	
	@PutMapping("/sugestao")
	public Sugestao atualizarSugestao(@RequestBody Sugestao sugestao) {
		return repo.save(sugestao);
	}
	
}
