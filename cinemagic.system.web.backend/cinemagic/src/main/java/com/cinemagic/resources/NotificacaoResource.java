package com.cinemagic.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cinemagic.services.PagSeguroService;

@RestController
@RequestMapping(value = "/notificacao")
public class NotificacaoResource {
	@Autowired
	private PagSeguroService service;
	
	@RequestMapping(method = RequestMethod.POST,consumes = {"application/x-www-form-urlencoded"})
	public ResponseEntity<Void> receberNotificacao(@RequestBody MultiValueMap paramMap,
			@RequestParam(value = "notificationCode") String code,
			@RequestParam(value = "notificationType") String type){
		
		
		
		URI url = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
		return ResponseEntity.created(url).build();
	}
	
	
}
