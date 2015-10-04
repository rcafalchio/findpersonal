package com.findpersonal.findpersonalws.rest;

import java.util.ArrayList;
import java.util.List;

import com.findpersonal.findpersonalutil.vo.ErroNegocio;

public class RetornoRest {

	private int codigoRetorno = 0;
	private String descricaoRetorno;
	private List<ErroNegocio> listaErrosNegocio;

	public RetornoRest(RetornoRestEnum retornoRestEnum) {
		this.codigoRetorno = retornoRestEnum.getCodigoRetorno();
		this.descricaoRetorno = retornoRestEnum.name();
	}

	public RetornoRest(RetornoRestEnum retornoRestEnum, List<ErroNegocio> listaErrosNegocio) {
		this.listaErrosNegocio = listaErrosNegocio;
		this.codigoRetorno = retornoRestEnum.getCodigoRetorno();
		this.descricaoRetorno = retornoRestEnum.name();
	}

	public enum RetornoRestEnum {

		SUCESSO(0), SISTEMA_INDISPONIVEL(-1), ERRO_NEGOCIO(-2);

		private int codigoRetorno;

		RetornoRestEnum(int codigoRetorno) {
			this.codigoRetorno = codigoRetorno;
		}

		int getCodigoRetorno() {
			return codigoRetorno;
		}

	}

	public int getCodigoRetorno() {
		return codigoRetorno;
	}

	/**
	 * @return the listaErros
	 */
	public List<ErroNegocio> getListaErrosNegocio() {
		if (listaErrosNegocio == null) {
			listaErrosNegocio = new ArrayList<ErroNegocio>();
		}
		return listaErrosNegocio;
	}

	public String getDescricaoRetorno() {
		return descricaoRetorno;
	}

}
