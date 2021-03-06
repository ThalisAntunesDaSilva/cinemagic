package com.cinemagic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cinemagic.domain.Cliente;
import com.cinemagic.repositories.ClienteRepository;
import com.cinemagic.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private ClienteRepository repo;

	// Procura por id
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id " + id + " Tipo " + Cliente.class.getName()));
	}

	// Procura todos
	public List<Cliente> findAll() {
		return repo.findAll();
	}

	// Salva
	public Cliente save(Cliente cliente) {
		return repo.save(cliente);
	}
	
	//Exclui
	public void delete(Cliente cliente){
	    repo.delete(cliente);
	}
	// Atualiza
	public Cliente update(Cliente cliente) {
		Cliente newObj = findById(cliente.getId());
		updateData(newObj, cliente);
		return repo.save(newObj);
	}
	//Edita
	public Cliente edit(Cliente cliente) {
		return repo.save(cliente);
	}
	 
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setCompras(obj.getCompras());
	}
}
