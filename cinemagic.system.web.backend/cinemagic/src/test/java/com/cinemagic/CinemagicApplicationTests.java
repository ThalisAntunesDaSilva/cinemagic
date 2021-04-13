package com.cinemagic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cinemagic.domain.Ator;
import com.cinemagic.domain.Cidade;
import com.cinemagic.domain.Cliente;
import com.cinemagic.domain.Compra;
import com.cinemagic.domain.Estado;
import com.cinemagic.domain.Pais;
import com.cinemagic.domain.Enums.StatusCompra;
import com.cinemagic.domain.Enums.TipoPagamento;

@SpringBootTest
class CinemagicApplicationTests {

	@Test
	void contextLoads() {
		String nome = "Thalis";

		Ator ator = new Ator(1, "Thalis");

		String nomeTest = ator.getNome();

		assertEquals(nome, nomeTest);

	}
	
	
	//Cliente(Integer id, String nome, String email,
	//Cidade cidade,String senha,String areaCode,String phone,String cpf)
	
	
	@Test
	public void compraTest() throws ParseException {
		java.util.Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("14/04/2021 01:00");
		Pais pais = new Pais(1,"brasil");
		Estado estado = new Estado(1, "Rio grande do Sul","RS", pais);
		Cidade cidade = new Cidade(1,"Alegrete",estado);
		Cliente cliente = new Cliente(1,"Maria", "maria@gmail.com",cidade,"123456","55","984325687","03454323443"); 
		Compra compra = new Compra(1, date,cliente,TipoPagamento.CARTAO );
		assertEquals(compra.getStatusCompra(), StatusCompra.ESPERANDO_PAGAMENTO);
	}

	@Test
	public void compraTest2() throws ParseException {
		java.util.Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse("14/04/2021 01:00");
		Pais pais = new Pais(1,"brasil");
		Estado estado = new Estado(1, "Rio grande do Sul","RS", pais);
		Cidade cidade = new Cidade(1,"Alegrete",estado);
		Cliente cliente = new Cliente(1,"Maria", "maria@gmail.com",cidade,"123456","55","984325687","03454323443"); 
		Compra compra = new Compra(1, date,cliente,TipoPagamento.CARTAO );
		compra.setStatusCompra(StatusCompra.PAGO);
		assertEquals(compra.getStatusCompra(), StatusCompra.PAGO);
	}
}
