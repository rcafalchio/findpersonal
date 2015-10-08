package com.findpersonal.findpersonalws.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CadastroAtendimenetoRest extends EnvioRest {

	@JsonProperty("FP")
	private Integer faixaPreco;
	@JsonProperty("LTLA")
	private List<Integer> tiposLocalAtendimento;

	private List<CadastroLocalAtendimentoRest> locaisAtendimento;

	public Integer getFaixaPreco() {
		return faixaPreco;
	}

	public void setFaixaPreco(Integer faixaPreco) {
		this.faixaPreco = faixaPreco;
	}

	public List<Integer> getTiposLocalAtendimento() {
		return tiposLocalAtendimento;
	}

	public void setTiposLocalAtendimento(List<Integer> tiposLocalAtendimento) {
		this.tiposLocalAtendimento = tiposLocalAtendimento;
	}

	public List<CadastroLocalAtendimentoRest> getLocaisAtendimento() {
		return locaisAtendimento;
	}

	public void setLocaisAtendimento(List<CadastroLocalAtendimentoRest> locaisAtendimento) {
		this.locaisAtendimento = locaisAtendimento;
	}

}
