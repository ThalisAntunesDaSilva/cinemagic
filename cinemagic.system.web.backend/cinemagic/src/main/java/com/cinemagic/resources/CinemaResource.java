package com.cinemagic.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cinemagic.domain.Cinema;
import com.cinemagic.dto.CinemaDTO;
import com.cinemagic.dto.CinemaNewDTO;
import com.cinemagic.services.CinemaService;

@RestController
@RequestMapping(value = "/cinemas")
public class CinemaResource {
	@Autowired
	private CinemaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cinema> findById(@PathVariable Integer id){
		Cinema cinema = service.findById(id);
		return ResponseEntity.ok().body(cinema);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody CinemaNewDTO objDTO){
		Cinema cinema = service.fromDTO(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cinema.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CinemaDTO>> findAll(){
		List<CinemaDTO> objDTO = service.findAll();
		return ResponseEntity.ok().body(objDTO);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Cinema> update(@RequestBody CinemaDTO objDTO,@PathVariable Integer id){
		Cinema cinema = service.fromDTO(objDTO);
		cinema.setId(id);
		cinema = service.update(cinema);
		return ResponseEntity.ok().body(cinema);
	}
	
	
	
	
	
}
