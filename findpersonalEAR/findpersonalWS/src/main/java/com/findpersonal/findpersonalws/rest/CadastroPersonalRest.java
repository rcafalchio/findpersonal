package com.findpersonal.findpersonalws.rest;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CadastroPersonalRest extends EnvioRest {

	@JsonProperty("PW")
	@NotNull
	private String senha;

	@JsonProperty("MAIL")
	@NotNull
	private String email;

	@JsonProperty("NM")
	@NotNull
	private String nome;

	@JsonProperty("CFB")
	private Integer codigoFacebook;

	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * @param senha
	 *            the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the codigoFacebook
	 */
	public Integer getCodigoFacebook() {
		return codigoFacebook;
	}

	/**
	 * @param codigoFacebook
	 *            the codigoFacebook to set
	 */
	public void setCodigoFacebook(Integer codigoFacebook) {
		this.codigoFacebook = codigoFacebook;
	}

}
