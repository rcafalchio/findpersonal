package com.findpersonal.findpersonalws.rest;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnvioAtulizacaoAlunoRest extends CadastroAlunoRest {

	@JsonProperty("CD")
	@NotNull(message = "O parametro não pode ser nulo")
	private Integer codigo;

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

}
