package com.findpersonal.findpersonalws.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.findpersonal.findpersonalutil.vo.ErroNegocio;

/**
 * Retorno Cadastro
 * 
 * @author Ricardo
 * @since 23 de ago de 2015
 */
public class RetornoListaJSON<T> extends RetornoJSON {

	private List<T> lista = new ArrayList<T>();

	public RetornoListaJSON(RetornoRestEnum retornoRestEnum, List<ErroNegocio> listaErros) {
		super(retornoRestEnum, listaErros);
	}

	public RetornoListaJSON(RetornoRestEnum retornoRestEnum) {
		super(retornoRestEnum);
	}

	public void adicionarNaLista(T t) {
		lista.add(t);
	}

	public void adicionarNaLista(List<T> listaT) {
		lista.addAll(listaT);
	}

	public List<T> getLista() {
		return lista;
	}

}
