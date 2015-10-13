package com.findpersonal.findpersonalws.exception;

import java.util.List;

/**
 * Exception do personal
 * 
 * @author Ricardo
 * @since 9 de ago de 2015
 */
@SuppressWarnings(value = { "all" })
public class PersonalException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Envia a lista de validações aplicadas
	 * 
	 * @param listaValidacoes
	 */
	public PersonalException(List listaValidacoes) {
		super(listaValidacoes);
	}

}
