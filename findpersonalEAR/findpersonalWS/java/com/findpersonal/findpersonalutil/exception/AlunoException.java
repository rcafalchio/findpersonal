package com.findpersonal.findpersonalutil.exception;

import java.util.List;

/**
 * Exception do aluno
 * 
 * @author Ricardo
 * @since 9 de ago de 2015
 */
@SuppressWarnings(value = { "all" })
public class AlunoException extends BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Envia a lista de validações aplicadas
	 * 
	 * @param listaValidacoes
	 */
	public AlunoException(List listaValidacoes) {
		super(listaValidacoes);
	}

}
