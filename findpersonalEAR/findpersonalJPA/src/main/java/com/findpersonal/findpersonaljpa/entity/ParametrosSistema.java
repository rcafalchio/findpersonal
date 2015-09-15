package com.findpersonal.findpersonaljpa.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tb_parametros_sistema database table.
 * 
 */
@Entity
@Table(name = "tb_parametros_sistema")
@NamedQuery(name = "ParametrosSistema.findAll", query = "SELECT t FROM ParametrosSistema t")
public class ParametrosSistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_PARAMETRO")
	private int codigoParametro;

	@Column(name = "TX_OBSERVACAO")
	private String observacao;

	@Column(name = "TX_PARAMETRO")
	private String parametro;

	@Column(name = "TX_VALOR")
	private String valor;

	public ParametrosSistema() {
	}

	public int getCodigoParametro() {
		return codigoParametro;
	}

	public void setCodigoParametro(int codigoParametro) {
		this.codigoParametro = codigoParametro;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}