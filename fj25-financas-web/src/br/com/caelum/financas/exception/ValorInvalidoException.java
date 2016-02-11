package br.com.caelum.financas.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class ValorInvalidoException extends RuntimeException {
	public ValorInvalidoException(String message) {
		super(message);
	}
}
