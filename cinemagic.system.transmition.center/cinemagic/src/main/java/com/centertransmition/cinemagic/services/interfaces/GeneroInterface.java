package com.centertransmition.cinemagic.services.interfaces;

import java.util.List;

import com.centertransmition.cinemagic.entity.Genero;

public interface GeneroInterface {
	
	
	public Genero findById(Integer id);
	
	public List<Genero> findAll();
	
	
	
	
}
