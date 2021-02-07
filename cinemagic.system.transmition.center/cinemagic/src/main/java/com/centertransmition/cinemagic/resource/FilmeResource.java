package com.centertransmition.cinemagic.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.centertransmition.cinemagic.entity.Filme;
import com.centertransmition.cinemagic.repository.FilmeRepository;


	@RestController
	@CrossOrigin(origins = "*", allowedHeaders = "")

	@RequestMapping(value = "/filmes")
	public class FilmeResource {
		  @Autowired
		  FilmeRepository filmeRepository;
		  

		 
		    @GetMapping
		    public List<Filme> listaFilmes() {
		        return filmeRepository.findAll();

		    }
		    
		    public Filme buscarFilme(int id){
				  return filmeRepository.findById(id);
			}
		 

		    @PostMapping("/filme")
		    public Filme salvaFIlme(@RequestBody final Filme filme) {
		        return filmeRepository.save(filme);
		    }

		    @DeleteMapping("/filme")
		    public void deletaFilme(@RequestBody final Filme filme) {
		        filmeRepository.delete(filme);
		    }

		    @PutMapping("/filme")
		    public Filme atualizaFilme(@RequestBody final Filme filme) {
		       return  filmeRepository.save(filme);
		    }


	}

