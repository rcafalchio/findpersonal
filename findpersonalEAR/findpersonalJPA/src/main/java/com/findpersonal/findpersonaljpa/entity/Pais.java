package com.findpersonal.findpersonaljpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the tb_pais database table.
 * 
 */
@Entity
@Table(name = "tb_pais")
@NamedQuery(name = "Pais.findAll", query = "SELECT t FROM Pais t")
public class Pais implements Serializable, DatabaseEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_PAIS")
	private int codigo;

	public List<LocalAtendimento> getLocaisAtendimento() {
		return locaisAtendimento;
	}

	public void setLocaisAtendimento(List<LocalAtendimento> locaisAtendimento) {
		this.locaisAtendimento = locaisAtendimento;
	}

	@Column(name = "TX_NOME")
	private String nome;

	@OneToMany
	@JoinColumn(name = "TB_PAIS_CD_PAIS")
	private List<LocalAtendimento> locaisAtendimento;

	public Pais() {
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

}