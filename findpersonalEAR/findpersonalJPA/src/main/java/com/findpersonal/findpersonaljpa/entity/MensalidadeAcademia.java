package com.findpersonal.findpersonaljpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * The persistent class for the tb_mensalidade_academia database table.
 * 
 */
@Entity
@Table(name = "tb_mensalidade_academia")
@NamedQuery(name = "MensalidadeAcademia.findAll", query = "SELECT t FROM MensalidadeAcademia t")
public class MensalidadeAcademia implements Serializable, DatabaseEntity{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MensalidadeAcademiaPK id;

	@Column(name = "BO_ISENTO")
	private byte isento;

	@Column(name = "BO_QUITADO")
	private byte quitado;

	@Column(name = "DIN_VALOR")
	private BigDecimal valor;

	// bi-directional many-to-many association to TbAcademia
	@ManyToMany
	@JoinTable(name = "tb_mensalidade_academia_has_tb_academia", joinColumns = {
			@JoinColumn(name = "TB_MENSALIDADE_ACADEMIA_DT_ANO", referencedColumnName = "DT_ANO"),
			@JoinColumn(name = "TB_MENSALIDADE_ACADEMIA_DT_MES", referencedColumnName = "DT_MES") }, inverseJoinColumns = {
					@JoinColumn(name = "TB_ACADEMIA_CD_ACADEMIA") })
	private List<Academia> tbAcademias;

	public MensalidadeAcademia() {
	}

	public MensalidadeAcademiaPK getId() {
		return this.id;
	}

	public void setId(MensalidadeAcademiaPK id) {
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

	public List<Academia> getTbAcademias() {
		return tbAcademias;
	}

	public void setTbAcademias(List<Academia> tbAcademias) {
		this.tbAcademias = tbAcademias;
	}

}