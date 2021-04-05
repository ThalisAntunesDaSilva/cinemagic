package com.cinemagic.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cinemagic.domain.Genero;
import com.cinemagic.dto.GeneroDTO;
import com.cinemagic.repositories.GeneroRepository;
import com.cinemagic.services.GeneroService;

@RestController()
@RequestMapping(value = "/generos")
public class GeneroResource {

	@Autowired
	GeneroService generoService;
	GeneroRepository repo;
	

	@RequestMapping(value ="/{id}",method = RequestMethod.GET)
	public ResponseEntity<Genero> findById(@PathVariable Integer id){
		Genero obj = generoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Genero>> listaGeneros(){
		return ResponseEntity.ok().body(generoService.findAll());
		
	}
	
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody GeneroDTO genero){
		Genero obj = generoService.fromDTO(genero);
		generoService.insert(obj);
		URI url = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(url).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		generoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Genero> update(@RequestBody GeneroDTO objDTO, @PathVariable Integer id) {
		Genero genero =generoService.fromDTO(objDTO);
		genero.setId(id);
		genero = generoService.update(genero);
		return ResponseEntity.ok().body(genero);

	}
	
	
	
	
}
