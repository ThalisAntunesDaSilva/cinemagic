package com.cinemagic.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.cinemagic.domain.Cliente;
import com.cinemagic.dto.ClienteNewDTO;
import com.cinemagic.repositories.ClienteRepository;
import com.cinemagic.resources.exceptions.FieldMessage;
import com.cinemagic.services.validation.util.BR;

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
		if(!BR.isValidCPF(objDTO.getCpf())) {
			list.add(new FieldMessage("cpf","Cpf inválido"));
		}
		if(objDTO.getAreaCode().length() != 2) {
			list.add(new FieldMessage("areaCode","Código de area inválido (DDD)"));
		}
		if(objDTO.getPhone().length() < 8 || objDTO.getPhone().length() >9) {
			list.add(new FieldMessage("phone","Telefone inválido"));
		}
		aux = null;
		aux = repo.findByCpf(objDTO.getCpf());
		if(aux != null) {
			list.add(new FieldMessage("cpf","Cpf já existente"));
		}
		
		
		for(FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
										.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
