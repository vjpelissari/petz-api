package br.com.jantorno.petapi.services.exceptions;

public class ClienteInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1869300553614629710L;

	public ClienteInvalidoException(String mensagem) {
		super(mensagem);
	}
	
	public ClienteInvalidoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}