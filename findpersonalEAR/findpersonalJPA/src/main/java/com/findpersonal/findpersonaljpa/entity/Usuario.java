package com.findpersonal.findpersonaljpa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable, DatabaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Usuario() {
	}

	public Usuario(Aluno aluno, String login, String senha, String email, Boolean ativo, Boolean loginFacebook,
			Integer codigoFacebook) {
		super();
		this.aluno = aluno;
		this.senha = senha;
		this.email = email;
		this.ativo = ativo;
		this.loginFacebook = loginFacebook;
		this.codigoFacebook = codigoFacebook;
	}

	public Usuario(Personal personal, String login, String senha, String email, Boolean ativo, Boolean loginFacebook,
			Integer codigoFacebook) {
		super();
		this.personal = personal;
		this.senha = senha;
		this.email = email;
		this.ativo = ativo;
		this.loginFacebook = loginFacebook;
		this.codigoFacebook = codigoFacebook;
	}

	public Usuario(Usuario user) {
		this.aluno = user.aluno;
		this.personal = user.personal;
		this.senha = user.senha;
		this.email = user.email;
		this.ativo = user.ativo;
		this.loginFacebook = user.loginFacebook;
		this.codigoFacebook = user.codigoFacebook;
	}

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TB_USUARIO_HAS_TB_PAPEL_SISTEMA", joinColumns = { @JoinColumn(name = "tb_usuario_CD_USUARIO") }, inverseJoinColumns = { @JoinColumn(name = "tb_papel_sistema_CD_PAPEL_SISTEMA") })
	private Set<PapelSistema> papeis = new HashSet<PapelSistema>();
	
	@JsonIgnore
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Aluno aluno;

	@JsonIgnore
	@OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Personal personal;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_USUARIO")
	private Integer codigo;
	@Column(name = "TX_SENHA")
	public String senha;
	@Column(name = "TX_EMAIL")
	public String email;
	@Column(name = "BO_ATIVO")
	private Boolean ativo;
	@Column(name = "BO_FACEBOOK")
	private Boolean loginFacebook;
	@Column(name = "CD_FACEBOOK")
	private Integer codigoFacebook;

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

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigoFacebook() {
		return codigoFacebook;
	}

	public void setCodigoFacebook(Integer codigoFacebook) {
		this.codigoFacebook = codigoFacebook;
	}

	/**
	 * @return the papeis
	 */
	public Set<PapelSistema> getPapeis() {
		return papeis;
	}

}
