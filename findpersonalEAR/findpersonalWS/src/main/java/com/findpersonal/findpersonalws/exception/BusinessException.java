package com.findpersonal.findpersonalws.exception;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings(value = {"all"})
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
		if (this.listaValidacoes == null) {
			listaValidacoes = new ArrayList();
		}
		return listaValidacoes;
	}

	public BusinessException(Object object) {
		getListaValidacoes().add(object);
	}

	public String getStringErrors() {
		StringBuffer buffer = new StringBuffer();
		listaValidacoes.forEach((a)-> buffer.append(a).append("\n"));
		return buffer.toString();
	}
	
}
