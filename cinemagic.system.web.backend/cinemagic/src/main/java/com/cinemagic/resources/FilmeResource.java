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
import com.cinemagic.dto.FilmeDTO;
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
	
	@GetMapping("/filmes")
	public List<Filme> listarFilmes(){
		return repo.findAll();
	}
	
	@GetMapping("/filme/{id}")
	public Filme buscaFilme(@PathVariable(value = "id") int id) {
		return repo.findById(id);
	}
	
	@PostMapping("/filme")
	public Filme salvarFilme(@RequestBody Filme filme) {
		return repo.save(filme);
	}
	
	@DeleteMapping("/filme")
	public void deletarFilme(@RequestBody Filme filme) {
		repo.delete(filme);
	}
	
	@PutMapping("/filme")
	public Filme atualizarFilme(@RequestBody Filme filme) {
		return repo.save(filme);
	}
	
}
