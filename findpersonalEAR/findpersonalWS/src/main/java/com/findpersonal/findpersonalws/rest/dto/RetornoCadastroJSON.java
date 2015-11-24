package com.findpersonal.findpersonalws.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.findpersonal.findpersonalutil.vo.ErroNegocio;

/**
 * Retorno Cadastro
 * 
 * @author Ricardo
 * @since 23 de ago de 2015
 */
public class RetornoCadastroJSON extends RetornoJSON {

	public RetornoCadastroJSON() {
		super(RetornoRestEnum.SUCESSO);
	}
	
	@JsonProperty("CC")
	private Integer codigoCadastro;

	public RetornoCadastroJSON(RetornoRestEnum retornoRestEnum, List<ErroNegocio> listaErrosNegocio) {
		super(retornoRestEnum, listaErrosNegocio);
	}

	public RetornoCadastroJSON(RetornoRestEnum retornoRestEnum) {
		super(retornoRestEnum);
	}

	public Integer getCodigoCadastro() {
		return codigoCadastro;
	}

	public void setCodigoCadastro(Integer codigoCadastro) {
		this.codigoCadastro = codigoCadastro;
	}

}
