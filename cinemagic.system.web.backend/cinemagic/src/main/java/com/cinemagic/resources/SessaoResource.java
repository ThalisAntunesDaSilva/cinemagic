package com.cinemagic.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cinemagic.domain.Sessao;
import com.cinemagic.dto.SessaoNewDTO;
import com.cinemagic.services.SessaoService;

@RestController()
@RequestMapping(value = "/sessoes")
public class SessaoResource {
	
	@Autowired
	SessaoService service;
	
	@RequestMapping(value ="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Sessao> findById(@PathVariable Integer id){
		return findById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody SessaoNewDTO objDTO){
		Sessao obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(url).build();
	}
	

	@GetMapping("/sessoes")
	public List<Sessao> listaGeneros(){
		return null;
	}

	
//	@DeleteMapping("/sessoes")
//	public void deletarSessao(@RequestBody Sessao sessao) {
//		return repo.delete(sessao);
//	}
	
}
