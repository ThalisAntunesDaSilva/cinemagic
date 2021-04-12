package com.cinemagic;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cinemagic.domain.Filme;
import com.cinemagic.domain.Genero;
import com.cinemagic.services.FilmeService;

class FilmeTests {
	
	@Autowired
	private SessionFactory session;
	
	@Autowired
	private FilmeService filmeService;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		
		Genero comedia = new Genero(null, "engraçado");

		Filme filme = new Filme(null,"a casa","14:30", comedia );
		filme=filmeService.insert(filme);
		assertFalse(filme.getId()!=null);

		
	}

}
