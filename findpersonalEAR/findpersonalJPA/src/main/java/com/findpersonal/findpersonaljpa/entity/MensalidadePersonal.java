package com.findpersonal.findpersonaljpa.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the tb_mensalidade_personal database table.
 * 
 */
@Entity
@Table(name = "TB_MENSALIDADE_PERSONAL")
@NamedQuery(name = "MensalidadePersonal.findAll", query = "SELECT t FROM MensalidadePersonal t")
public class MensalidadePersonal implements Serializable, DatabaseEntity{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MensalidadePersonalPK id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "TB_PERSONAL_CD_PERSONAL")
	private Personal personal;
	
	@Column(name = "BO_ISENTO")
	private byte isento;

	@Column(name = "BO_QUITADO")
	private byte quitado;

	@Column(name = "DIN_VALOR")
	private BigDecimal valor;

	public MensalidadePersonal() {
	}

	public MensalidadePersonalPK getId() {
		return this.id;
	}

	public void setId(MensalidadePersonalPK id) {
		this.id = id;
	}

	public byte getIsento() {
		return isento;
	}

	public void setIsento(byte isento) {
		this.isento = isento;
	}

	public byte getQuitado() {
		return quitado;
	}

	public void setQuitado(byte quitado) {
		this.quitado = quitado;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}