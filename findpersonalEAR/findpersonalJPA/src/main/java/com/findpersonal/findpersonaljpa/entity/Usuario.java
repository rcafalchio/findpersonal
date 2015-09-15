package com.findpersonal.findpersonaljpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

	public Usuario() {
	}

	public Usuario(Aluno aluno, String login, String senha, String email, Boolean ativo, Boolean loginFacebook) {
		super();
		this.aluno = aluno;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.ativo = ativo;
		this.loginFacebook = loginFacebook;
	}
	
	public Usuario(Personal personal, String login, String senha, String email, Boolean ativo, Boolean loginFacebook) {
		super();
		this.personal = personal;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.ativo = ativo;
		this.loginFacebook = loginFacebook;
	}

	@JsonIgnore
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Aluno aluno;

	@JsonIgnore
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Personal personal;

	@Id
	@Column(name = "TX_LOGIN")
	private String login;
	@Column(name = "TX_SENHA")
	private String senha;
	@Column(name = "TX_EMAIL")
	private String email;
	@Column(name = "BO_ATIVO")
	private Boolean ativo;
	@Column(name = "BO_FACEBOOK")
	private Boolean loginFacebook;

	/**
	 * @return the aluno
	 */
	public Aluno getAluno() {
		return aluno;
	}

	/**
	 * @param aluno
	 *            the aluno to set
	 */
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

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
	 * @return the ativo
	 */
	public Boolean getAtivo() {
		return ativo;
	}

	/**
	 * @param ativo
	 *            the ativo to set
	 */
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	/**
	 * @return the loginFacebook
	 */
	public Boolean getLoginFacebook() {
		return loginFacebook;
	}

	/**
	 * @param loginFacebook
	 *            the loginFacebook to set
	 */
	public void setLoginFacebook(Boolean loginFacebook) {
		this.loginFacebook = loginFacebook;
	}

}
