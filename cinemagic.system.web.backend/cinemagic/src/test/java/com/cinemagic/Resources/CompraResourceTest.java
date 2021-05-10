package com.cinemagic.Resources;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.cinemagic.dto.CompraNewDTO;
import com.cinemagic.dto.IngressoDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.minidev.json.JSONObject;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CompraResourceTest {
	@Autowired
	private TestRestTemplate restTemplate;

	private String urlBase = "http://localhost:8080/compras";
	
	@Test
	@Order(1)
	public void efetuarCompraNotAuthenticated() {
		List<IngressoDTO> ingressos = new ArrayList<>();
		IngressoDTO ingresso1 = new IngressoDTO(1, 0);
		IngressoDTO ingresso2 = new IngressoDTO(1, 1);
		ingressos.add(ingresso1);
		ingressos.add(ingresso2);
		CompraNewDTO dto = new CompraNewDTO(1, 1, ingressos, 0);
		
		ObjectMapper mapper = new ObjectMapper();
		
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		
		
		try {
			String json = mapper.writeValueAsString(dto);
			
			HttpEntity<String> request = new HttpEntity<>(json,header);
			
			ResponseEntity<String> response = restTemplate.postForEntity(urlBase, request, String.class);
			assertTrue(response.getStatusCode().value() == 403);
			
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
