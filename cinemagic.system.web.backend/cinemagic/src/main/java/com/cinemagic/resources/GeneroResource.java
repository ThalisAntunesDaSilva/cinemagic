package com.cinemagic.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cinemagic.domain.Genero;
import com.cinemagic.repositories.GeneroRepository;

@RestController()
@RequestMapping(value = "/generos")
public class GeneroResource {

	GeneroRepository generoRepository;

	@RequestMapping(value ="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Genero> findById(@PathVariable Integer id){
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Genero genero){
		return null; 
	}
	
	@GetMapping("/produtos")
	public List<Genero> listaGeneros(){
		return generoRepository.findAll();
		
	}
}
