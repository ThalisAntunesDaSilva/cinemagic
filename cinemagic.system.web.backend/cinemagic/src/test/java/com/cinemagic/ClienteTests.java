package com.cinemagic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.cinemagic.domain.Cliente;

class ClienteTests {

	@Test
	void test1() {
		boolean client;
		
		
		Cliente cliente = new Cliente(1, "flavia", "flavia@email.com", null, "senha1", "666666", "5599999-0000", "666666666-10");
		
		String nome = cliente.getNome();
		assertEquals("flavia", nome);
		
		String email = cliente.getEmail();
		assertEquals("flavia@email.com", email);

		String cpf = cliente.getCpf();
		assertEquals("666666666-10", cpf);

		String senha = cliente.getSenha();
		assertEquals("senha1", senha);
		
		String phone = cliente.getPhone();
		assertEquals("5599999-0000", phone);

		client = cliente.equals(cliente);
		assertTrue(client);

		Cliente cliente1 = new Cliente(null, null, null, null, null, null, null, null);
		client = cliente.equals(cliente1);
		assertFalse(client);
		
		
		

	}
	
	
	
	

}

