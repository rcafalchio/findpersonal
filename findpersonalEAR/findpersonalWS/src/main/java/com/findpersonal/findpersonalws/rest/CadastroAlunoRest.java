package com.findpersonal.findpersonalws.rest;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class CadastroAlunoRest extends EnvioRest {

	@NotNull(message="O parametro não pode ser nulo")
	private String login;
	@NotNull(message="O parametro não pode ser nulo")
	private String senha;
	@NotNull(message="O parametro não pode ser nulo")
	private String email;
	@NotNull(message="O parametro não pode ser nulo")
	private String nome;
	@NotNull(message="O parametro não pode ser nulo")
	private Date dataNascimento;
	@NotNull
	@Pattern(regexp="[MmFf]")
	private String siglaSexo;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

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

}
