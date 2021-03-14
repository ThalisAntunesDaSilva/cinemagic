package com.cinemagic.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.cinemagic.domain.Cliente;
import com.cinemagic.dto.ClienteNewDTO;
import com.cinemagic.repositories.ClienteRepository;
import com.cinemagic.resources.exceptions.FieldMessage;
import com.cinemagic.services.ClienteService;

public class ClienteInsertValidation implements ConstraintValidator<ClienteInsert, ClienteNewDTO>{
	@Autowired
	private ClienteRepository repo;	
	
	@Override
	public void initialize(ClienteInsert obj) {
		
	}
	
	@Override
	public boolean isValid(ClienteNewDTO objDTO, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		Cliente aux = repo.findByEmail(objDTO.getEmail());
		if(aux != null) {
			list.add(new FieldMessage("email","Email já existente"));
		}
		if(objDTO.getSenha().length() < 6) {
			list.add(new FieldMessage("senha","Senha deve ter no mínimo 6 caracteres"));
		}
		for(FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
										.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
