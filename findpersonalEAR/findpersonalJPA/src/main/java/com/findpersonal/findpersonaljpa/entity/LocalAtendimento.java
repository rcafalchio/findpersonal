package com.findpersonal.findpersonaljpa.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the tb_personal_atendimento database table.
 * 
 */
@Entity
@Table(name = "TB_PERSONAL_ATENDIMENTO")
@NamedQuery(name = "LocalAtendimento.findAll", query = "SELECT t FROM LocalAtendimento t")
public class LocalAtendimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LocalAtendimentoPK id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "TB_PERSONAL_CD_PERSONAL", insertable = false, updatable = false)
	private Personal personal;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "TB_PAIS_CD_PAIS", insertable = false, updatable = false)
	private Pais pais;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "TB_CIDADE_CD_CIDADE", insertable = false, updatable = false)
	private Cidade cidade;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "TB_ESTADO_CD_ESTADO", insertable = false, updatable = false)
	private Estado estado;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "TB_ZONA_CD_ZONA", insertable = false, updatable = false)
	private Zona zona;

	public LocalAtendimento() {
	}

	public LocalAtendimentoPK getId() {
		return id;
	}

	public void setId(LocalAtendimentoPK id) {
		this.id = id;
	}

	public Personal getPersonal() {
		return personal;
	}

	public Pais getPais() {
		return pais;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public Zona getZona() {
		return zona;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

}