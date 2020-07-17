package br.com.jantorno.petapi.services.exceptions;

public class PetNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1869300553614629710L;

	public PetNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public PetNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}