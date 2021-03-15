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
		
		String xml = "<checkout>\r\n"
				+ "  <sender>\r\n"
				+ "    <name>Jose Comprador</name>\r\n"
				+ "    <email>comprador@uol.com.br</email>\r\n"
				+ "    <phone>\r\n"
				+ "      <areaCode>99</areaCode>\r\n"
				+ "      <number>999999999</number>\r\n"
				+ "    </phone>\r\n"
				+ "    <documents>\r\n"
				+ "      <document>\r\n"
				+ "        <type>CPF</type>\r\n"
				+ "        <value>11475714734</value>\r\n"
				+ "      </document>\r\n"
				+ "    </documents>\r\n"
				+ "  </sender>\r\n"
				+ "  <currency>BRL</currency>\r\n"
				+ "  <items>\r\n"
				+ "    <item>\r\n"
				+ "      <id>0001</id>\r\n"
				+ "      <description>Produto PagSeguroI</description>\r\n"
				+ "      <amount>99999.99</amount>\r\n"
				+ "      <quantity>1</quantity>\r\n"
				+ "      <weight>10</weight>\r\n"
				+ "      <shippingCost>1.00</shippingCost>\r\n"
				+ "    </item>\r\n"
				+ "  </items>\r\n"
				+ "  <redirectURL>http://lojamodelo.com.br/return.html</redirectURL>\r\n"
				+ "  <extraAmount>10.00</extraAmount>\r\n"
				+ "  <reference>REF1234</reference>\r\n"
				+ "  <shipping>\r\n"
				+ "    <addressRequired>false</addressRequired>\r\n"
				+ "  </shipping>\r\n"
				+ "  <timeout>25</timeout>\r\n"
				+ "  <maxAge>999999999</maxAge>\r\n"
				+ "  <maxUses>999</maxUses>\r\n"
				+ "  <receiver>\r\n"
				+ "    <email>gabrielcamposfreitas12@gmail.com</email>\r\n"
				+ "  </receiver>\r\n"
				+ "</checkout>";
			
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,headers);

		
		
		ResponseEntity<CheckoutDTO> response = rest.postForEntity(builder.toUriString(), request,CheckoutDTO.class);
		return response.getBody();
		
		
		
	}
	
}
