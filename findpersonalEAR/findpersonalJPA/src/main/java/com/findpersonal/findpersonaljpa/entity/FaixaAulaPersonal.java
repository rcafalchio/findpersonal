package com.findpersonal.findpersonaljpa.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cadastro_faixa_aula")
public class FaixaAulaPersonal implements Serializable, DatabaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "CD_VALOR_FAIXA")
	private Integer codigo;
	
	@OneToOne
	@JoinColumn(name = "tb_personal_CD_PERSONAL")
	private Usuario usuario;
	
	@Column(name = "DS_FAIXA")
	private String senha;
	
	@OneToMany(mappedBy = "faixaAulaPersonal", fetch = FetchType.LAZY)
	private List<Personal> personais;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Personal> getPersonais() {
		return personais;
	}

	public void setPersonais(List<Personal> personais) {
		this.personais = personais;
	}
}
