package com.cinemagic.services;





import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.cinemagic.dto.CheckoutDTO;

@Service
public class PagSeguroService {
	private final String EMAIL = "gabrielcamposfreitas12@gmail.com";
	private final String TOKEN = "5A093C030AEB451F9FBA2502ED04BBE1";
	private final String URL = "https://ws.sandbox.pagseguro.uol.com.br/v2/checkout?";
	
	public CheckoutDTO criarPagamento() {
		RestTemplate rest = new RestTemplate();
		
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("currency", "BRL");
		map.add("itemId1","001");
		map.add("itemDescription1", "Ingresso Inteira");
		map.add("itemAmount1", "20.00");
		map.add("itemQuantity1", "2");
		map.add("itemWeight1", "1");
		map.add("shippingAddressRequired", "false");
		map.add("senderName", "Ana bea");
		map.add("senderEmail", "gabrielcamposfreitas12@hotmail.com");
		map.add("senderAreaCode", "55");
		map.add("senderPhone","999765189");
		map.add("senderCPF","04111073050");
		map.add("reference","VD001");
		map.add("redirectURL","https://moodle.unipampa.edu.br/moodle/");
		map.add("receiverEmail","gabrielcamposfreitas12@gmail.com");
		map.add("maxUses","10");
		map.add("maxAge","10000");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		List<MediaType> l = new ArrayList<>();
		l.add(MediaType.APPLICATION_XML);
		l.add(MediaType.ALL);
		headers.setAccept(l);
		
		
		
	
		
		
		
		
		
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(URL)
				.queryParam("email", EMAIL)
				.queryParam("token", TOKEN);
		
			
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,headers);
	
		ResponseEntity<CheckoutDTO> response = rest.postForEntity(builder.toUriString(), request,CheckoutDTO.class);
		return response.getBody();
		
		
		
	}
	
}
