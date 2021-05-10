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
	@Test
	@Order(2)
	public void efetuarCompraAuthenticatedWithAnotherCustomer() {
		List<IngressoDTO> ingressos = new ArrayList<>();
		IngressoDTO ingresso1 = new IngressoDTO(1, 0);
		IngressoDTO ingresso2 = new IngressoDTO(1, 1);
		ingressos.add(ingresso1);
		ingressos.add(ingresso2);
		CompraNewDTO dto = new CompraNewDTO(1, 1, ingressos, 0);
		
		ObjectMapper mapper = new ObjectMapper();
		
		HttpHeaders headerLogin = new HttpHeaders();
		List<MediaType> listMedia = new ArrayList<>();
		listMedia.add(MediaType.ALL);
		headerLogin.setAccept(listMedia);
		headerLogin.setContentType(MediaType.APPLICATION_JSON);
		
		
		JSONObject jsonLogin = new JSONObject();
		jsonLogin.put("email", "test@gmail.com");
		jsonLogin.put("senha", "123456");
		
		HttpEntity<String> requestLogin = new HttpEntity<>(jsonLogin.toString(),headerLogin);
		
		ResponseEntity<String> loginResponse = restTemplate.postForEntity("http://localhost:8080/login", requestLogin, String.class);
		
		String token = loginResponse.getHeaders().getFirst("authorization");
		
		try {
			String json = mapper.writeValueAsString(dto);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			header.setAccept(listMedia);
			header.add("authorization", token);
			
			HttpEntity<String> request = new HttpEntity<>(json,header);
			
			ResponseEntity<String> response = restTemplate.postForEntity(urlBase, request, String.class);
			assertTrue(response.getStatusCode().value() == 422);
			
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	@Order(3)
	public void efetuarCompraCloseSessao() {
		List<IngressoDTO> ingressos = new ArrayList<>();
		IngressoDTO ingresso1 = new IngressoDTO(1, 0);
		IngressoDTO ingresso2 = new IngressoDTO(1, 1);
		ingressos.add(ingresso1);
		ingressos.add(ingresso2);
		CompraNewDTO dto = new CompraNewDTO(1, 3, ingressos, 0);
		
		ObjectMapper mapper = new ObjectMapper();
		
		HttpHeaders headerLogin = new HttpHeaders();
		List<MediaType> listMedia = new ArrayList<>();
		listMedia.add(MediaType.ALL);
		headerLogin.setAccept(listMedia);
		headerLogin.setContentType(MediaType.APPLICATION_JSON);
		
		
		JSONObject jsonLogin = new JSONObject();
		jsonLogin.put("email", "gabriel@gmail.com");
		jsonLogin.put("senha", "123456");
		
		HttpEntity<String> requestLogin = new HttpEntity<>(jsonLogin.toString(),headerLogin);
		
		ResponseEntity<String> loginResponse = restTemplate.postForEntity("http://localhost:8080/login", requestLogin, String.class);
		
		String token = loginResponse.getHeaders().getFirst("authorization");
		
		try {
			String json = mapper.writeValueAsString(dto);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			header.setAccept(listMedia);
			header.add("authorization", token);
			
			HttpEntity<String> request = new HttpEntity<>(json,header);
			
			ResponseEntity<String> response = restTemplate.postForEntity(urlBase, request, String.class);
			assertTrue(response.getStatusCode().value() == 400);
			
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	@Order(4)
	public void efetuarCompraSessaoFull() {
		List<IngressoDTO> ingressos = new ArrayList<>();
		IngressoDTO ingresso1 = new IngressoDTO(1, 0);
		IngressoDTO ingresso2 = new IngressoDTO(1, 1);
		ingressos.add(ingresso1);
		ingressos.add(ingresso2);
		CompraNewDTO dto = new CompraNewDTO(1, 2, ingressos, 0);
		
		ObjectMapper mapper = new ObjectMapper();
		
		HttpHeaders headerLogin = new HttpHeaders();
		List<MediaType> listMedia = new ArrayList<>();
		listMedia.add(MediaType.ALL);
		headerLogin.setAccept(listMedia);
		headerLogin.setContentType(MediaType.APPLICATION_JSON);
		
		
		JSONObject jsonLogin = new JSONObject();
		jsonLogin.put("email", "gabriel@gmail.com");
		jsonLogin.put("senha", "123456");
		
		HttpEntity<String> requestLogin = new HttpEntity<>(jsonLogin.toString(),headerLogin);
		
		ResponseEntity<String> loginResponse = restTemplate.postForEntity("http://localhost:8080/login", requestLogin, String.class);
		
		String token = loginResponse.getHeaders().getFirst("authorization");
		
		try {
			String json = mapper.writeValueAsString(dto);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			header.setAccept(listMedia);
			header.add("authorization", token);
			
			HttpEntity<String> request = new HttpEntity<>(json,header);
			
			restTemplate.postForEntity(urlBase, request, String.class);
			ResponseEntity<String> response = restTemplate.postForEntity(urlBase, request, String.class);
			assertTrue(response.getStatusCode().value() == 400 && response.getBody().contains("Capacidade máxima alcançada"));
			
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	@Order(5)
	public void efetuarCompraNotPromotionPoints() {
		List<IngressoDTO> ingressos = new ArrayList<>();
		IngressoDTO ingresso1 = new IngressoDTO(1, 0);
		IngressoDTO ingresso2 = new IngressoDTO(1, 1);
		ingressos.add(ingresso1);
		ingressos.add(ingresso2);
		CompraNewDTO dto = new CompraNewDTO(1, 2, ingressos, 1);
		
		ObjectMapper mapper = new ObjectMapper();
		
		HttpHeaders headerLogin = new HttpHeaders();
		List<MediaType> listMedia = new ArrayList<>();
		listMedia.add(MediaType.ALL);
		headerLogin.setAccept(listMedia);
		headerLogin.setContentType(MediaType.APPLICATION_JSON);
		
		
		JSONObject jsonLogin = new JSONObject();
		jsonLogin.put("email", "gabriel@gmail.com");
		jsonLogin.put("senha", "123456");
		
		HttpEntity<String> requestLogin = new HttpEntity<>(jsonLogin.toString(),headerLogin);
		
		ResponseEntity<String> loginResponse = restTemplate.postForEntity("http://localhost:8080/login", requestLogin, String.class);
		
		String token = loginResponse.getHeaders().getFirst("authorization");
		
		try {
			String json = mapper.writeValueAsString(dto);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			header.setAccept(listMedia);
			header.add("authorization", token);
			
			HttpEntity<String> request = new HttpEntity<>(json,header);
			
			ResponseEntity<String> response = restTemplate.postForEntity(urlBase, request, String.class);
			assertTrue(response.getStatusCode().value() == 400 && response.getBody().contains("Promoção não encontrada"));
			
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	@Order(6)
	public void efetuarCompraClienteNotPoints() {
		List<IngressoDTO> ingressos = new ArrayList<>();
		IngressoDTO ingresso1 = new IngressoDTO(1, 0);
		IngressoDTO ingresso2 = new IngressoDTO(1, 1);
		ingressos.add(ingresso1);
		ingressos.add(ingresso2);
		CompraNewDTO dto = new CompraNewDTO(1, 1, ingressos, 1);
		
		ObjectMapper mapper = new ObjectMapper();
		
		HttpHeaders headerLogin = new HttpHeaders();
		List<MediaType> listMedia = new ArrayList<>();
		listMedia.add(MediaType.ALL);
		headerLogin.setAccept(listMedia);
		headerLogin.setContentType(MediaType.APPLICATION_JSON);
		
		
		JSONObject jsonLogin = new JSONObject();
		jsonLogin.put("email", "gabriel@gmail.com");
		jsonLogin.put("senha", "123456");
		
		HttpEntity<String> requestLogin = new HttpEntity<>(jsonLogin.toString(),headerLogin);
		
		ResponseEntity<String> loginResponse = restTemplate.postForEntity("http://localhost:8080/login", requestLogin, String.class);
		
		String token = loginResponse.getHeaders().getFirst("authorization");
		
		try {
			String json = mapper.writeValueAsString(dto);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(MediaType.APPLICATION_JSON);
			header.setAccept(listMedia);
			header.add("authorization", token);
			
			HttpEntity<String> request = new HttpEntity<>(json,header);
			
			ResponseEntity<String> response = restTemplate.postForEntity(urlBase, request, String.class);
			
			assertTrue(response.getStatusCode().value() == 400);
			
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
