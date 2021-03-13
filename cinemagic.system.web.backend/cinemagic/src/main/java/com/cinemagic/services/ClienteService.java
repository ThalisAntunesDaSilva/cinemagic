package com.cinemagic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cinemagic.domain.Cidade;
import com.cinemagic.domain.Cliente;
import com.cinemagic.domain.Enums.Perfil;
import com.cinemagic.dto.ClienteNewDTO;
import com.cinemagic.repositories.ClienteRepository;
import com.cinemagic.security.UserSS;
import com.cinemagic.services.exceptions.AuthorizationException;
import com.cinemagic.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	
	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private ClienteRepository repo;
	@Autowired
	private CidadeService cidadeService;

	// Procura por id
	public Cliente findById(Integer id) {
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id " + id + " Tipo " + Cliente.class.getName()));

	}
	public Cliente findByEmail(String email) {
//		UserSS user = UserService.authenticated();
//		if(user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
//			throw new AuthorizationException("Acesso negado");
//		}
		Cliente obj = repo.findByEmail(email);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado email "+ email +" Tipo "+ Cliente.class.getName());
		}
		return obj;
	}

	// Procura todos
	public List<Cliente> findAll() {
		return repo.findAll();
	}

	// Salva
	public Cliente insert(Cliente cliente) {
		return repo.save(cliente);
	}

	public Cliente fromDTO(ClienteNewDTO objDTO) {
		Cidade cidade = cidadeService.findById(objDTO.getCidadeId());
		Cliente cliente = new Cliente(null, objDTO.getNome(), objDTO.getEmail(), cidade, pe.encode(objDTO.getSenha()));
		return cliente;
	}
	
	// Exclui
	public void delete(Cliente cliente) {
		repo.delete(cliente);
	}

	// Atualiza
	public Cliente update(Cliente cliente) {
		Cliente newObj = findById(cliente.getId());
		updateData(newObj, cliente);
		return repo.save(newObj);
	}

	// Edita
	public Cliente edit(Cliente cliente) {
		return repo.save(cliente);
	}

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setCompras(obj.getCompras());
	}
}
