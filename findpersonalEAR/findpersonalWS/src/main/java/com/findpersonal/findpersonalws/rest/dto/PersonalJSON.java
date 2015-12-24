package com.findpersonal.findpersonalws.rest.dto;

import java.util.Date;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objeto que representa o JSON Aluno
 * 
 * @author Ricardo
 *
 */
public class PersonalJSON {

	@JsonProperty("CD")
	private Integer codigo;

	@JsonProperty("CREF")
	private String cref;

	@JsonProperty("MAIL")
	private String email;

	@JsonProperty("NM")
	private String nome;

	@JsonProperty("CPF")
	private Long cpf;

	@JsonProperty("CFB")
	private CadastroFacebookJSON cadastroFacebookRest;

	@JsonProperty("AT")
	private Boolean ativo;

	@JsonProperty("DTN")
	private Date dataNascimento;
	
	@JsonProperty("SX")
	@Pattern(regexp = "[MmFf]")
	private String siglaSexo;

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
	 * @return the cref
	 */
	public String getCref() {
		return cref;
	}

	/**
	 * @param cref
	 *            the cref to set
	 */
	public void setCref(String cref) {
		this.cref = cref;
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

	/**
	 * @return the cadastroFacebookRest
	 */
	public CadastroFacebookJSON getCadastroFacebookRest() {
		return cadastroFacebookRest;
	}

	/**
	 * @param cadastroFacebookRest
	 *            the cadastroFacebookRest to set
	 */
	public void setCadastroFacebookRest(CadastroFacebookJSON cadastroFacebookRest) {
		this.cadastroFacebookRest = cadastroFacebookRest;
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
	 * @param siglaSexo the siglaSexo to set
	 */
	public void setSiglaSexo(String siglaSexo) {
		this.siglaSexo = siglaSexo;
	}

}
