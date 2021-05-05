package com.cinemagic.Resources;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

import net.minidev.json.JSONObject;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ClienteResourceTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	private String urlBase = "http://localhost:8080";
	
	

	
	
	@Test
	@Order(1)
	public void createClienteInvalid() {
		String url = "/clientes";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject clienteJson = new JSONObject();
		
		clienteJson.putIfAbsent("nome", "Mohamed Salah");
		clienteJson.put("email", "mohamed@gmail.com");
		clienteJson.put("senha", "123456");
		clienteJson.put("cidadeId",1);
		clienteJson.put("areaCode", "55");
		clienteJson.put("phone", "999765189");
		clienteJson.put("cpf", "123123");
		
		HttpEntity<String> request = new HttpEntity<>(clienteJson.toString(),headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(urlBase+url, request, String.class);
		
		assertTrue(response.getStatusCode().value() == 422 && response.getBody().contains("Cpf inválido"));
		
	}
	@Test
	@Order(2)
	public void createClienteNomeEmpty() {
		String url = "/clientes";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject clienteJson = new JSONObject();
		
		clienteJson.putIfAbsent("nome", "");
		clienteJson.put("email", "mohamed@gmail.com");
		clienteJson.put("senha", "123456");
		clienteJson.put("cidadeId",1);
		clienteJson.put("areaCode", "55");
		clienteJson.put("phone", "999765189");
		clienteJson.put("cpf", "57284401001");
		
		HttpEntity<String> request = new HttpEntity<>(clienteJson.toString(),headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(urlBase+url, request, String.class);
		
		assertTrue(response.getStatusCode().value() == 422 && response.getBody().contains("Preenchimento obrigatório"));
		
	}
	@Test
	@Order(3)
	public void createClienteSenhaEmpty() {
		String url = "/clientes";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject clienteJson = new JSONObject();
		
		clienteJson.putIfAbsent("nome", "mohamed");
		clienteJson.put("email", "mohamed@gmail.com");
		clienteJson.put("senha", "");
		clienteJson.put("cidadeId",1);
		clienteJson.put("areaCode", "55");
		clienteJson.put("phone", "999765189");
		clienteJson.put("cpf", "57284401001");
		
		HttpEntity<String> request = new HttpEntity<>(clienteJson.toString(),headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(urlBase+url, request, String.class);
		
		assertTrue(response.getStatusCode().value() == 422 && response.getBody().contains("Preenchimento obrigatório"));
		
	}
	@Test
	@Order(4)
	public void createClienteCidadeNull() {
		String url = "/clientes";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject clienteJson = new JSONObject();
		
		clienteJson.putIfAbsent("nome", "mohamed");
		clienteJson.put("email", "mohamed@gmail.com");
		clienteJson.put("senha", "123456");
		clienteJson.put("cidadeId",null);
		clienteJson.put("areaCode", "55");
		clienteJson.put("phone", "999765189");
		clienteJson.put("cpf", "57284401001");
		
		HttpEntity<String> request = new HttpEntity<>(clienteJson.toString(),headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(urlBase+url, request, String.class);
		
		assertTrue(response.getStatusCode().value() == 422);
		
	}
	@Test
	@Order(5)
	public void createClienteAreaCodeEmpty() {
		String url = "/clientes";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject clienteJson = new JSONObject();
		
		clienteJson.putIfAbsent("nome", "mohamed");
		clienteJson.put("email", "mohamed@gmail.com");
		clienteJson.put("senha", "123456");
		clienteJson.put("cidadeId",1);
		clienteJson.put("areaCode", "");
		clienteJson.put("phone", "999765189");
		clienteJson.put("cpf", "57284401001");
		
		HttpEntity<String> request = new HttpEntity<>(clienteJson.toString(),headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(urlBase+url, request, String.class);
		
		assertTrue(response.getStatusCode().value() == 422 && response.getBody().contains("Preenchimento obrigatório"));
		
	}
	@Test
	@Order(6)
	public void createClienteAreaPhoneEmpty() {
		String url = "/clientes";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject clienteJson = new JSONObject();
		
		clienteJson.putIfAbsent("nome", "mohamed");
		clienteJson.put("email", "mohamed@gmail.com");
		clienteJson.put("senha", "123456");
		clienteJson.put("cidadeId",1);
		clienteJson.put("areaCode", "55");
		clienteJson.put("phone", "");
		clienteJson.put("cpf", "57284401001");
		
		HttpEntity<String> request = new HttpEntity<>(clienteJson.toString(),headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(urlBase+url, request, String.class);
		
		assertTrue(response.getStatusCode().value() == 422 && response.getBody().contains("Preenchimento obrigatório"));
		
	}
	
	
	@Test
	@Order(7)
	public void createClienteCidadeNotExists() {
		String url = "/clientes";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject clienteJson = new JSONObject();
		
		clienteJson.putIfAbsent("nome", "mohamed");
		clienteJson.put("email", "mohamed@gmail.com");
		clienteJson.put("senha", "123456");
		clienteJson.put("cidadeId",41);
		clienteJson.put("areaCode", "55");
		clienteJson.put("phone", "996861486");
		clienteJson.put("cpf", "57284401001");
		
		HttpEntity<String> request = new HttpEntity<>(clienteJson.toString(),headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(urlBase+url, request, String.class);
		
		assertTrue(response.getStatusCode().value() == 404 && response.getBody().contains("Objeto não encontrado"));
		
	}
	@Test
	@Order(8)
	public void createClientePhoneInvalid() {
		String url = "/clientes";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject clienteJson = new JSONObject();
		
		clienteJson.putIfAbsent("nome", "mohamed");
		clienteJson.put("email", "mohamed@gmail.com");
		clienteJson.put("senha", "123456");
		clienteJson.put("cidadeId",41);
		clienteJson.put("areaCode", "55");
		clienteJson.put("phone", "112");
		clienteJson.put("cpf", "57284401001");
		
		HttpEntity<String> request = new HttpEntity<>(clienteJson.toString(),headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(urlBase+url, request, String.class);
		
		assertTrue(response.getStatusCode().value() == 422 && response.getBody().contains("Telefone inválido"));
		
	}
	@Test
	@Order(9)
	public void createClienteAreaCodeInvalid() {
		String url = "/clientes";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject clienteJson = new JSONObject();
		
		clienteJson.putIfAbsent("nome", "mohamed");
		clienteJson.put("email", "mohamed@gmail.com");
		clienteJson.put("senha", "123456");
		clienteJson.put("cidadeId",41);
		clienteJson.put("areaCode", "5555");
		clienteJson.put("phone", "996861486");
		clienteJson.put("cpf", "57284401001");
		
		HttpEntity<String> request = new HttpEntity<>(clienteJson.toString(),headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(urlBase+url, request, String.class);
		
		assertTrue(response.getStatusCode().value() == 422 && response.getBody().contains("Código de area inválido (DDD)"));
		
	}
	@Test
	@Order(10)
	public void createClientValid() {
		String url = "/clientes";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject clienteJson = new JSONObject();
		
		clienteJson.putIfAbsent("nome", "Mohamed Salah");
		clienteJson.put("email", "mohamed@gmail.com");
		clienteJson.put("senha", "123456");
		clienteJson.put("cidadeId",1);
		clienteJson.put("areaCode", "55");
		clienteJson.put("phone", "999765189");
		clienteJson.put("cpf", "57284401001");
		
		HttpEntity<String> request = new HttpEntity<>(clienteJson.toString(),headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(urlBase+url, request, String.class);
		assertTrue(response.getStatusCode().value() == 201);
		
		
	}
	
	@Test
	@Order(11)
	public void createClientEmailExists() {
		String url = "/clientes";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject clienteJson = new JSONObject();
		
		clienteJson.putIfAbsent("nome", "Mohamed Salah");
		clienteJson.put("email", "mohamed@gmail.com");
		clienteJson.put("senha", "123456");
		clienteJson.put("cidadeId",1);
		clienteJson.put("areaCode", "55");
		clienteJson.put("phone", "999765189");
		clienteJson.put("cpf", "57284401001");
		
		HttpEntity<String> request = new HttpEntity<>(clienteJson.toString(),headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(urlBase+url, request, String.class);
		System.out.println("AAAAAAAAAAAAAA"+response.getBody());
		assertTrue(response.getStatusCode().value() == 422 && response.getBody().contains("Email já existente"));
		
		
	}
	
	@Test
	@Order(12)
	public void createClienteCpfExists() {
		String url = "/clientes";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject clienteJson = new JSONObject();
		
		clienteJson.putIfAbsent("nome", "mohamed");
		clienteJson.put("email", "mohamed@gmail.com");
		clienteJson.put("senha", "123456");
		clienteJson.put("cidadeId",1);
		clienteJson.put("areaCode", "55");
		clienteJson.put("phone", "996861486");
		clienteJson.put("cpf", "57284401001");
		
		HttpEntity<String> request = new HttpEntity<>(clienteJson.toString(),headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(urlBase+url, request, String.class);
		
		assertTrue(response.getStatusCode().value() == 422 && response.getBody().contains("Cpf já existente"));
		
	}
	
}
