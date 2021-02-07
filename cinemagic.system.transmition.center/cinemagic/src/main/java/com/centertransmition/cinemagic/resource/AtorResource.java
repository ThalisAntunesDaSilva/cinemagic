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
import com.centertransmition.cinemagic.repository.AtorRepository;
import com.centertransmition.cinemagic.entity.Ator;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "")

@RequestMapping(value = "/atores")
public class AtorResource {
	  @Autowired
	    AtorRepository atorRepository;
	  

	 
	    @GetMapping
	    public List<Ator> listaAtores() {
	        return atorRepository.findAll();

	    }
	    
	    public Ator buscarAtor(int id){
			  return atorRepository.findById(id);
		}
	 

	    @PostMapping("/ator")
	    public Ator salvaAtor(@RequestBody final Ator ator) {
	        return atorRepository.save(ator);
	    }

	    @DeleteMapping("/ator")
	    public void deletaAtor(@RequestBody final Ator ator) {
	        atorRepository.delete(ator);
	    }

	    @PutMapping("/ator")
	    public Ator atualizaAtor(@RequestBody final Ator ator) {
	       return  atorRepository.save(ator);
	    }


}
