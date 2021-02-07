package com.centertransmition.cinemagic.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.centertransmition.cinemagic.entity.Genero;
import com.centertransmition.cinemagic.repository.GeneroRepository;

	@RestController
	@CrossOrigin(origins = "*", allowedHeaders = "")

	@RequestMapping(value = "/generos")
	public class GeneroResource {
		  @Autowired
		    GeneroRepository generoRepository;
		  

		 
		    @GetMapping
		    public List<Genero> listaGeneros() {
		        return generoRepository.findAll();

		    }
		    
		    public Genero buscarGenero(int id){
				  return generoRepository.findById(id);
			}
		 

		  

}

