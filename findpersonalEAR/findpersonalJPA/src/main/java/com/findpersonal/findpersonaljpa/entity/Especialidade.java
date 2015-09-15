package com.findpersonal.findpersonaljpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the tb_especialidade database table.
 * 
 */
@Entity
@Table(name = "tb_especialidade")
@NamedQuery(name = "Especialidade.findAll", query = "SELECT t FROM Especialidade t")
public class Especialidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_ESPECIALIDADE")
	private int codigo;

	@Column(name = "TX_DESCRICAO")
	private String descricao;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "TB_PERSONAL_has_TB_ESPECIALIDADE", joinColumns = {
			@JoinColumn(name = "TB_ESPECIALIDADE_CD_ESPECIALIDADE") }, inverseJoinColumns = {
					@JoinColumn(name = "TB_PERSONAL_CD_PERSONAL") })
	private List<Personal> personais;

	public Especialidade() {
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Personal> getPersonais() {
		return personais;
	}

	public void setPersonais(List<Personal> personais) {
		this.personais = personais;
	}

}