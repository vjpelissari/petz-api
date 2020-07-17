package br.com.jantorno.petapi.services.exceptions;

public class CpfClienteExistenteException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CpfClienteExistenteException(String mensagem) {
		super(mensagem);
	}
	
	public CpfClienteExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}