package com.findpersonal.findpersonalws.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FiltroPersonalJSON extends EnvioJSON {

	@JsonProperty("CDV")
	private Integer codigoValor;

	@JsonProperty("LE")
	private List<Integer> listaEspecialidades;

	@JsonProperty("LTL")
	private List<Integer> listaTipoLocais;

	@JsonProperty("LPA")
	private List<Integer> listaPais;

	@JsonProperty("LCD")
	private List<Integer> listaCidades;

	@JsonProperty("LBR")
	private List<Integer> listaBairros;

	@JsonProperty("LZN")
	private List<Integer> listaZonas;

	/**
	 * @return the codigoValor
	 */
	public Integer getCodigoValor() {
		return codigoValor;
	}

	/**
	 * @return the listaEspecialidades
	 */
	public List<Integer> getListaEspecialidades() {
		return listaEspecialidades;
	}

	/**
	 * @return the listaTipoLocais
	 */
	public List<Integer> getListaTipoLocais() {
		return listaTipoLocais;
	}

	/**
	 * @return the listaPais
	 */
	public List<Integer> getListaPais() {
		return listaPais;
	}

	/**
	 * @return the listaCidades
	 */
	public List<Integer> getListaCidades() {
		return listaCidades;
	}

	/**
	 * @return the listaBairros
	 */
	public List<Integer> getListaBairros() {
		return listaBairros;
	}

	/**
	 * @return the listaZonas
	 */
	public List<Integer> getListaZonas() {
		return listaZonas;
	}
}
