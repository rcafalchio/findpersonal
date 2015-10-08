package com.findpersonal.findpersonalws.rest;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
	@JsonProperty("DTN")
	@NotNull(message = "O parametro não pode ser nulo")
	private Date dataNascimento;
	@JsonProperty("SX")
	@NotNull
	@Pattern(regexp = "[MmFf]")
	private String siglaSexo;
	@JsonProperty("CFB")
	private Integer cdFacebook;
	@JsonProperty("LFB")
	private String linkPageFacebook;

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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSiglaSexo() {
		return siglaSexo;
	}

	public void setSiglaSexo(String siglaSexo) {
		this.siglaSexo = siglaSexo;
	}

	public Integer getCdFacebook() {
		return cdFacebook;
	}

	public void setCdFacebook(Integer cdFacebook) {
		this.cdFacebook = cdFacebook;
	}

	public String getLinkPageFacebook() {
		return linkPageFacebook;
	}

	public void setLinkPageFacebook(String linkPageFacebook) {
		this.linkPageFacebook = linkPageFacebook;
	}
}
