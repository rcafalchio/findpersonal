package com.findpersonal.findpersonaljpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the tb_estado database table.
 * 
 */
@Entity
@Table(name = "tb_estado")
@NamedQuery(name = "Estado.findAll", query = "SELECT t FROM Estado t")
public class Estado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@OneToMany
	@JoinColumn(name = "TB_ESTADO_CD_ESTADO")
	private List<LocalAtendimento> locaisAtendimento;

	@Id
	@Column(name = "CD_ESTADO")
	private int codigo;

	@Column(name = "TX_NOME")
	private String nome;

	public Estado() {
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