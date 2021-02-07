package com.centertransmition.cinemagic.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.centertransmition.cinemagic.entity.Atua;
import com.centertransmition.cinemagic.repository.AtuaRepository;


	@RestController
	@CrossOrigin(origins = "*", allowedHeaders = "")

	@RequestMapping(value = "/atua")
	public class AtuaResource {
		  @Autowired
		    AtuaRepository atuaRepository;
		  

		 
		    @GetMapping
		    public List<Atua> listaAtuacoes() {
		        return atuaRepository.findAll();

		    }
		    
		    public Atua buscarAtuacao(int id){
				  return atuaRepository.findById(id);
			}
		 

		  

}
