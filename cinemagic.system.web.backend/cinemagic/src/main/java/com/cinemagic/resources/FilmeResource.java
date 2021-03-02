package com.cinemagic.resources;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.cinemagic.domain.Filme;
import com.cinemagic.domain.Sugestao;
import com.cinemagic.dto.FilmeDTO;
import com.cinemagic.dto.SugestaoDTO;
import com.cinemagic.repositories.FilmeRepository;
import com.cinemagic.services.FilmeService;

import java.util.List;

@RestController()
@RequestMapping(value = "/filmes")
public class FilmeResource {

	@Autowired
	FilmeService filmeService;
	FilmeRepository repo;
	
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
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<FilmeDTO>> findAll(){
		List<FilmeDTO> objDTO = filmeService.findAll();
		return ResponseEntity.ok().body(objDTO);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		filmeService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Filme> update(@RequestBody FilmeDTO objDTO,@PathVariable Integer id){
		Filme filme = filmeService.fromDTO(objDTO);
		filme.setId(id);
		filme = filmeService.update(filme);
		return ResponseEntity.ok().body(filme);
		
	}
	
}
