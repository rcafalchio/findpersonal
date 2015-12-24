package com.findpersonal.findpersonaljpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_FACEBOOK")
public class Facebook implements Serializable, DatabaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "TB_USUARIO_CD_USUARIO")
	private Usuario usuario;

	@Id
	@Column(name = "TX_ID_FACEBOOK")
	private String codigoFacebook;

	@Column(name = "TX_SENHA_FACEBOOK")
	private String senha;

	@Column(name = "TX_APELIDO")
	private String apelido;

	@Column(name = "TX_PAGINA")
	private String paginaFacebook;

	@Column(name = "TX_LOCALE")
	private String locale;

	@Column(name = "TX_NOME")
	private String nome;

	@Column(name = "TX_SOBRENOME")
	private String sobrenome;

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	 * @return the codigoFacebook
	 */
	public String getCodigoFacebook() {
		return codigoFacebook;
	}

	/**
	 * @param codigoFacebook
	 *            the codigoFacebook to set
	 */
	public void setCodigoFacebook(String codigoFacebook) {
		this.codigoFacebook = codigoFacebook;
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
	 * @return the apelido
	 */
	public String getApelido() {
		return apelido;
	}

	/**
	 * @param apelido
	 *            the apelido to set
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
	 * @param paginaFacebook
	 *            the paginaFacebook to set
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
	 * @param nome
	 *            the nome to set
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
	 * @param sobrenome
	 *            the sobrenome to set
	 */
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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
