package com.findpersonal.findpersonalws.rest;

import java.util.ArrayList;
import java.util.List;

import vo.Erro;

/**
 * Retorno Cadastro
 * 
 * @author Ricardo
 * @since 23 de ago de 2015
 */
public class RetornoCadastroRest {

	public RetornoCadastroRest(boolean cadastrou) {
		super();
		this.cadastrou = cadastrou;
	}

	public RetornoCadastroRest(boolean cadastrou, List<Erro> listaErros) {
		super();
		this.cadastrou = cadastrou;
		this.listaErros = listaErros;
	}

	private boolean cadastrou;
	private List<Erro> listaErros;

	/**
	 * @return the cadastrou
	 */
	public boolean isCadastrou() {
		return cadastrou;
	}

	/**
	 * @return the listaErros
	 */
	public List<Erro> getListaErros() {
		if (listaErros == null) {
			listaErros = new ArrayList<Erro>();
		}
		return listaErros;
	}

}
