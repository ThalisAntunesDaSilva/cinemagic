package com.centertransmition.cinemagic.services.interfaces;

import java.util.List;

import com.centertransmition.cinemagic.entity.Atua;

public interface AtuaInterface {
	
	public Atua findById(Integer id);
	
	public List<Atua> findAll();
	
}
