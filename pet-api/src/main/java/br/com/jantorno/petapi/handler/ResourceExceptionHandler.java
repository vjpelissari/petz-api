package br.com.jantorno.petapi.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.jantorno.petapi.services.exceptions.*;
import br.com.jantorno.petapi.domain.DetalhesErro;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ClienteNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleClienteNaoEncontradoException
							(ClienteNaoEncontradoException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O cliente não foi encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.petapi.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(CpfClienteExistenteException.class)
	public ResponseEntity<DetalhesErro> handleNomeClienteExistenteException
							(CpfClienteExistenteException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Cpf do cliente existente.");
		erro.setMensagemDesenvolvedor("http://erros.petapi.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(ClienteInvalidoException.class)
	public ResponseEntity<DetalhesErro> handleNomeClienteInvalidoException
							(ClienteInvalidoException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(409l);
		erro.setTitulo("Cliente Inválido.");
		erro.setMensagemDesenvolvedor("http://erros.petapi.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(PetNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handlePetNaoEncontradoException
							(PetNaoEncontradoException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("O pet não foi encontrado.");
		erro.setMensagemDesenvolvedor("http://erros.petapi.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
}