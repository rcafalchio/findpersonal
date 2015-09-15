package com.findpersonal.findpersonaljpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the tb_cidade database table.
 * 
 */
@Entity
@Table(name = "tb_cidade")
@NamedQuery(name = "Cidade.findAll", query = "SELECT t FROM Cidade t")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_CIDADE")
	private int codigo;

	@Column(name = "TX_NOME")
	private String nome;

	@OneToMany
	@JoinColumn(name = "TB_CIDADE_CD_CIDADE")
	private List<LocalAtendimento> locaisAtendimento;

	public Cidade() {
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<LocalAtendimento> getLocaisAtendimento() {
		return locaisAtendimento;
	}

	public void setLocaisAtendimento(List<LocalAtendimento> locaisAtendimento) {
		this.locaisAtendimento = locaisAtendimento;
	}

}