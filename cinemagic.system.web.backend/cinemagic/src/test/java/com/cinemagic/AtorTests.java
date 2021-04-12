package com.cinemagic;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.cinemagic.domain.Ator;

class AtorTests {


	@Test
	void ObjTrue() {
		boolean nomeTest;
		
		Ator ator = new Ator(1, "Flavia");
		Ator ator1 = new Ator(2, "");
		Ator ator2 = new Ator(3, "51545");
		Ator ator3 = new Ator(4, null);
		Ator ator4 = new Ator(4, "Thalis");
		
		nomeTest = ator.equals(ator);
		assertTrue(nomeTest);
		
		nomeTest = ator1.equals(ator1);
		assertFalse(nomeTest);
		
		nomeTest = ator2.equals(ator2);
		assertTrue(nomeTest);
		
		nomeTest = ator3.equals(ator3);
		assertFalse(nomeTest);
		
		nomeTest = ator4.equals(ator4);
		assertTrue(nomeTest);
	}

}
