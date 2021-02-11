package com.cinemagic.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cinemagic.domain.Compra;

@RestController(value = "/compras")
public class CompraResource {

	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Compra> findById(@PathVariable Integer id,
			@RequestParam(value = "sessao",defaultValue = "0") Integer idSessao,
			@RequestParam(value = "tipoIngresso",defaultValue = "0") Integer tipoIngresso){
		return null;
	}
}
