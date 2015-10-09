package com.findpersonal.findpersonalutil.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErroNegocio {

	public ErroNegocio(Integer codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	@JsonProperty(value="CDE")
	private Integer codigo;
	@JsonProperty(value="DSE")
	private String descricao;

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
}
