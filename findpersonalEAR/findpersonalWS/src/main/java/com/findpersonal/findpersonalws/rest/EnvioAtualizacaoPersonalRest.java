package com.findpersonal.findpersonalws.rest;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnvioAtualizacaoPersonalRest extends EnvioRest {

	@JsonProperty("CD")
	@NotNull
	private Integer codigo;

	@JsonProperty("DTN")
	private Date dataNascimento;

	@JsonProperty("SX")
	@Pattern(regexp = "[MmFf]")
	private String siglaSexo;

	@JsonProperty("AT")
	private Boolean ativo;
	
	@JsonProperty("PW")
	private String senha;

	@JsonProperty("MAIL")
	private String email;

	@JsonProperty("NM")
	private String nome;

	@JsonProperty("CFB")
	private Integer codigoFacebook;

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}
	/**
	 * @param dataNascimento
	 *            the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	/**
	 * @return the siglaSexo
	 */
	public String getSiglaSexo() {
		return siglaSexo;
	}
	/**
	 * @param siglaSexo
	 *            the siglaSexo to set
	 */
	public void setSiglaSexo(String siglaSexo) {
		this.siglaSexo = siglaSexo;
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
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	/**
	 * @param senha the senha to set
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
	 * @param email the email to set
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
	 * @param nome the nome to set
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
	 * @param codigoFacebook the codigoFacebook to set
	 */
	public void setCodigoFacebook(Integer codigoFacebook) {
		this.codigoFacebook = codigoFacebook;
	}

}
