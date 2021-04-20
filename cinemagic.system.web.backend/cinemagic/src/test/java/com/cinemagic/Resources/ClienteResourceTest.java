package com.cinemagic.Resources;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import net.minidev.json.JSONObject;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ClienteResourceTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	private String urlBase = "http://localhost:8080";
	
	@Test
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
		
		assertThat(response.getStatusCode().value() == 201);
		
		
	}
}
