package com.cinemagic.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinemagic.domain.Sessao;
import com.cinemagic.repositories.SessaoRepository;

@RestController()
@RequestMapping(value = "/sessoes")
public class SessaoResource {
	
	SessaoRepository repo;
	
	@RequestMapping(value ="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Sessao> findById(@PathVariable Integer id){
		return findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Sessao sessao){
		return insert(sessao);
	}
	

	@GetMapping("/sessoes")
	public List<Sessao> listaGeneros(){
		return repo.findAll();
		
	}

	
//	@DeleteMapping("/sessoes")
//	public void deletarSessao(@RequestBody Sessao sessao) {
//		return repo.delete(sessao);
//	}
	
}
