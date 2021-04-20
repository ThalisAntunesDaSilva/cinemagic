package com.cinemagic.Resources;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.cinemagic.domain.Cidade;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CidadeResourceTest {
	

	@Autowired
	private TestRestTemplate restTemplate;
	
	private String urlBase = "http://localhost:8080";
	
	
	@Test
	public void testGetCidadeByState() {
		String url = "/cidades/1";
		
		List<Cidade> cidades = (List<Cidade>) restTemplate.getForObject("http://localhost:8080"+url, List.class);
		
		assertThat(cidades.size() > 0);
		
	}
	
	@Test
	public void testGetCidadeByStateNotFound() {
		String url = "/cidades/3";
		ResponseEntity<Cidade[]> cidades= restTemplate.getForEntity(urlBase+url, Cidade[].class);
		assertThat(cidades.getStatusCode().value() == 404);
	}
	
	
}
