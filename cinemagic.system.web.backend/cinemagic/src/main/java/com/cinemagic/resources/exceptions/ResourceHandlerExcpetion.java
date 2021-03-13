package com.cinemagic.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cinemagic.services.exceptions.AuthorizationException;
import com.cinemagic.services.exceptions.InsufficientCouponException;
import com.cinemagic.services.exceptions.ObjectNotFoundException;
import com.cinemagic.services.exceptions.PromotionClosedException;
import com.cinemagic.services.exceptions.SessaoClosedExcpetion;
import com.cinemagic.services.exceptions.SessaoFullCapacityException;

@ControllerAdvice
public class ResourceHandlerExcpetion {

	@ExceptionHandler(value = ObjectNotFoundException.class)
	public ResponseEntity<StandardErr> ObjectNotFound(ObjectNotFoundException ex,HttpServletRequest request) {
		StandardErr err = new StandardErr(HttpStatus.NOT_FOUND.value(), ex.getMessage(),System.currentTimeMillis(),1,"Não encontrado",request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	
	@ExceptionHandler(value = SessaoClosedExcpetion.class)
	public ResponseEntity<StandardErr> sessaoClosed(SessaoClosedExcpetion ex,HttpServletRequest request){
		StandardErr err = new StandardErr(HttpStatus.BAD_REQUEST.value(),ex.getMessage(),System.currentTimeMillis(),2,"Sessão encerrada",request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	@ExceptionHandler(value = SessaoFullCapacityException.class)
	public ResponseEntity<StandardErr> sessaoFullCapacity(SessaoFullCapacityException ex,HttpServletRequest request){
		StandardErr err = new StandardErr(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis(),3,"Capacidade máxima alcançada",request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	@ExceptionHandler(value = PromotionClosedException.class)
	public ResponseEntity<StandardErr> promotionClosed(PromotionClosedException ex,HttpServletRequest request){
		StandardErr err = new StandardErr(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis(),4,"Promoção não encontrada",request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(err);
	}
	
	@ExceptionHandler(value = InsufficientCouponException.class)
	public ResponseEntity<StandardErr> insufficientCoupon(InsufficientCouponException ex,HttpServletRequest request){
		StandardErr err = new StandardErr(HttpStatus.BAD_REQUEST.value(),ex.getMessage(), System.currentTimeMillis(),5,"Pontos insuficientes",request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	@ExceptionHandler(value = DataIntegrityViolationException.class)
	public ResponseEntity<StandardErr> dataIntegrityViolation(DataIntegrityViolationException ex,HttpServletRequest request){
		StandardErr err = new StandardErr(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis(),6,"Integridade de dados",request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	@ExceptionHandler(value = AuthorizationException.class)
	public ResponseEntity<StandardErr> authorization(AuthorizationException ex,HttpServletRequest request){
		StandardErr err = new StandardErr(HttpStatus.FORBIDDEN.value(), ex.getMessage(), System.currentTimeMillis(),7,"Sem autotização",request.getRequestURI());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<StandardErr> validation(MethodArgumentNotValidException ex, HttpServletRequest request){
		ValidationError err = new ValidationError(HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage(), System.currentTimeMillis(),8, "Erro de validação", request.getRequestURI());
		for(FieldError x : ex.getBindingResult().getFieldErrors()) {
			err.addErros(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}
	
	

}
