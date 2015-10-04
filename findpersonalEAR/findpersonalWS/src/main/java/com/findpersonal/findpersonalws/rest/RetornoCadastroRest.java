package com.findpersonal.findpersonalws.rest;

import java.util.List;

import com.findpersonal.findpersonalutil.vo.ErroNegocio;

/**
 * Retorno Cadastro
 * 
 * @author Ricardo
 * @since 23 de ago de 2015
 */
public class RetornoCadastroRest extends RetornoRest {

	public RetornoCadastroRest(RetornoRestEnum retornoRestEnum, List<ErroNegocio> listaErrosNegocio) {
		super(retornoRestEnum, listaErrosNegocio);
	}

	public RetornoCadastroRest(RetornoRestEnum retornoRestEnum) {
		super(retornoRestEnum);
	}

}
