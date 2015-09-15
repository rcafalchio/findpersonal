package com.findpersonal.findpersonaljpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tb_endereco database table.
 * 
 */
@Entity
@Table(name = "tb_endereco")
@NamedQuery(name = "Endereco.findAll", query = "SELECT t FROM Endereco t")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_ENDERECO")
	private int codigo;

	@Lob
	@Column(name = "NU_CEP")
	private String cep;

	@Column(name = "TX_CIDADE")
	private String cidade;

	@Column(name = "TX_ESTADO")
	private String estado;

	@Column(name = "TX_NUMERO")
	private String numerp;

	@Column(name = "TX_PAIS")
	private String pais;

	@Column(name = "TX_RUA")
	private String rua;

	// bi-directional many-to-many association to TbAcademia
	@ManyToMany
	@JoinTable(name = "tb_academia_has_tb_endereco", joinColumns = {
			@JoinColumn(name = "TB_ENDERECO_CD_ENDERECO") }, inverseJoinColumns = {
					@JoinColumn(name = "TB_ACADEMIA_CD_ACADEMIA") })
	private List<Academia> tbAcademias;

	public Endereco() {
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumerp() {
		return numerp;
	}

	public void setNumerp(String numerp) {
		this.numerp = numerp;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public List<Academia> getTbAcademias() {
		return tbAcademias;
	}

	public void setTbAcademias(List<Academia> tbAcademias) {
		this.tbAcademias = tbAcademias;
	}

}