package com.centertransmition.cinemagic.services.interfaces;

import java.util.List;

import com.centertransmition.cinemagic.entity.Filme;

public interface FilmeInterface {
	
	public Filme findById(Integer id);
	
	public List<Filme> findAll();
	
	
}
