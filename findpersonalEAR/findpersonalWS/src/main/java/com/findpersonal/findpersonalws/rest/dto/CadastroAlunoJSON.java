package com.findpersonal.findpersonalws.rest.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CadastroAlunoJSON extends EnvioJSON {

	@JsonProperty("PW")
	@NotNull
	private String senha;

	@JsonProperty("MAIL")
	@NotNull
	private String email;

	@JsonProperty("NM")
	@NotNull
	private String nome;

	@JsonProperty("CPF")
	private Long cpf;

	@JsonProperty("CFB")
	private CadastroFacebookJSON cadastroFacebookJson;

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
	 * @return the cpf
	 */
	public Long getCpf() {
		return cpf;
	}

	/**
	 * @param cpf
	 *            the cpf to set
	 */
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public CadastroFacebookJSON getCadastroFacebookJson() {
		return cadastroFacebookJson;
	}

	public void setCadastroFacebookJson(CadastroFacebookJSON cadastroFacebookJson) {
		this.cadastroFacebookJson = cadastroFacebookJson;
	}
}
