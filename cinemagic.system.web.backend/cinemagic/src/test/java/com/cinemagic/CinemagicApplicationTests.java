package com.cinemagic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cinemagic.domain.Ator;

@SpringBootTest
class CinemagicApplicationTests {

	@Test
	void contextLoads() {
		String nome = "Thalis";

		Ator ator = new Ator(1, "Thalis");

		String nomeTest = ator.getNome();

		assertEquals(nome, nomeTest);

	}

}
