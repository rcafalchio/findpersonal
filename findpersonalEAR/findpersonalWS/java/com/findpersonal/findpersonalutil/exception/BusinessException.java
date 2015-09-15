package com.findpersonal.findpersonalutil.exception;

import java.util.List;

@SuppressWarnings(value = { "all" })
public class BusinessException extends FindPernsonalApplicationException {

	private List listaValidacoes;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException(List listaValidacoes) {
		this.listaValidacoes = listaValidacoes;
	}

	/**
	 * 
	 * @return List - Lista de validações
	 */
	public List getListaValidacoes() {
		return listaValidacoes;
	}

}
