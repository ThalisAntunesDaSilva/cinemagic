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
	private BCryptPasswordEncoder password;

	@Autowired
	private ClienteRepository repository;
	@Autowired
	private CidadeService cidadeService;

	public Cliente findById(Integer id) {
		UserSS user = UserService.authenticated();
		if (user.equals(null) || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		Optional<Cliente> clientes = repository.findById(id);
		return clientes.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado Id " + id + " Tipo " + Cliente.class.getName()));

	}
	public Cliente findByEmail(String email) {

		Cliente cliente = repository.findByEmail(email);
		
		if(cliente.equals(null)) {
			throw new ObjectNotFoundException("Objeto não encontrado email "+ email +" Tipo "+ Cliente.class.getName());
		}
		return cliente;
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	
	public Cliente insert(Cliente cliente) {
		return repository.save(cliente);
	}

	public Cliente fromDTO(ClienteNewDTO objDTO) {
		Cidade cidade = cidadeService.findById(objDTO.getCidadeId());
		Cliente cliente = new Cliente(null, objDTO.getNome(), objDTO.getEmail(), cidade, password.encode(objDTO.getSenha()),objDTO.getAreaCode(),objDTO.getPhone(),objDTO.getCpf());
		return cliente;
	}

	public void delete(Cliente cliente) {
		repository.delete(cliente);
	}


	public Cliente update(Cliente clienteBD) {
		Cliente cliente = findById(clienteBD.getId());
		updateData(cliente, clienteBD);
		return repository.save(cliente);
	}

	public Cliente edit(Cliente cliente) {
		return repository.save(cliente);
	}

	private void updateData(Cliente cliente, Cliente clienteBD) {
		cliente.setNome(clienteBD.getNome());
		cliente.setCompras(clienteBD.getCompras());
	}
}
