package com.findpersonal.findpersonalws.rest;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CadastroAlunoRest extends EnvioRest {

	@JsonProperty("PW")
	@NotNull(message = "O parametro não pode ser nulo")
	private String senha;
	
	@JsonProperty("MAIL")
	@NotNull(message = "O parametro não pode ser nulo")
	private String email;
	
	@JsonProperty("NM")
	@NotNull(message = "O parametro não pode ser nulo")
	private String nome;
	
	@JsonProperty("CFB")
	private Integer codigoFacebook;

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCodigoFacebook() {
		return codigoFacebook;
	}
	public void setCodigoFacebook(Integer codigoFacebook) {
		this.codigoFacebook = codigoFacebook;
	}

}
