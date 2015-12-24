package com.findpersonal.findpersonalws.rest.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CadastroFacebookJSON{

	@JsonProperty("CF")
	@NotNull
	private String codigoFacebook;

	@JsonProperty("NICK")
	@NotNull
	private String apelido;

	@JsonProperty("PGFB")
	@NotNull
	private String paginaFacebook;

	@JsonProperty("LOC")
	private String locale;

	@JsonProperty("FN")
	private String nome;

	@JsonProperty("LN")
	private String sobrenome;

	/**
	 * @return the apelido
	 */
	public String getApelido() {
		return apelido;
	}

	/**
	 * @param apelido the apelido to set
	 */
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	/**
	 * @return the paginaFacebook
	 */
	public String getPaginaFacebook() {
		return paginaFacebook;
	}

	/**
	 * @param paginaFacebook the paginaFacebook to set
	 */
	public void setPaginaFacebook(String paginaFacebook) {
		this.paginaFacebook = paginaFacebook;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the sobrenome
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * @param sobrenome the sobrenome to set
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	/**
	 * @return the codigoFacebook
	 */
	public String getCodigoFacebook() {
		return codigoFacebook;
	}

	/**
	 * @param codigoFacebook the codigoFacebook to set
	 */
	public void setCodigoFacebook(String codigoFacebook) {
		this.codigoFacebook = codigoFacebook;
	}

	/**
	 * @return the locale
	 */
	public String getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	
}
