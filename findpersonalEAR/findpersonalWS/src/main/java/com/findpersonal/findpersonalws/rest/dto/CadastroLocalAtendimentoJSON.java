package com.findpersonal.findpersonalws.rest.dto;

public class CadastroLocalAtendimentoJSON extends EnvioJSON {

	private Integer codigoCidade;
	private Integer codigoEstado;
	private Integer codigoPais;
	private Integer codigoZona;

	public Integer getCodigoCidade() {
		return codigoCidade;
	}
	public void setCodigoCidade(Integer codigoCidade) {
		this.codigoCidade = codigoCidade;
	}
	public Integer getCodigoEstado() {
		return codigoEstado;
	}
	public void setCodigoEstado(Integer codigoEstado) {
		this.codigoEstado = codigoEstado;
	}
	public Integer getCodigoPais() {
		return codigoPais;
	}
	public void setCodigoPais(Integer codigoPais) {
		this.codigoPais = codigoPais;
	}
	public Integer getCodigoZona() {
		return codigoZona;
	}
	public void setCodigoZona(Integer codigoZona) {
		this.codigoZona = codigoZona;
	}

}
