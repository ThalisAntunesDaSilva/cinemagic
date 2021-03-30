package com.centertransmition.cinemagic;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.centertransmition.cinemagic.entity.Ator;
import com.centertransmition.cinemagic.entity.Atua;
import com.centertransmition.cinemagic.entity.Filme;
import com.centertransmition.cinemagic.entity.Genero;
import com.centertransmition.cinemagic.repositories.AtorRepository;
import com.centertransmition.cinemagic.repositories.AtuaRepository;
import com.centertransmition.cinemagic.repositories.FilmeRepository;
import com.centertransmition.cinemagic.repositories.GeneroRepository;

@SpringBootApplication
public class CinemagicApplication implements CommandLineRunner{
	@Autowired
	private FilmeRepository filmeRepo;
	@Autowired
	private AtuaRepository atuaRepo;
	@Autowired
	private AtorRepository atorRepo;
	@Autowired
	private GeneroRepository generoRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CinemagicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");	
	
		
		
		Genero genero1 = new Genero(null, "Herói");
		Filme filme1 = new Filme(null, "Homem Aranha 3", 
				"gs://militwit-b3998.appspot.com/filmes/"
				+ "Os gatos mais adoráveis __do mundo EP1 vida bonito.mp4",
				sdf.parse("01:30"), genero1);
		genero1.getFilmes().addAll(Arrays.asList(filme1));
		
		Ator ator1 = new Ator(null, "Tom Holland");
		
		Atua atua1 = new Atua(null,"Peter Parker", filme1, ator1);	
		filme1.getAtuacoes().addAll(Arrays.asList(atua1));
		ator1.getAtuacoes().addAll(Arrays.asList(atua1));
		
		generoRepo.save(genero1);
		filmeRepo.save(filme1);
		atorRepo.save(ator1);
		atuaRepo.save(atua1);
		
		
	}

}
