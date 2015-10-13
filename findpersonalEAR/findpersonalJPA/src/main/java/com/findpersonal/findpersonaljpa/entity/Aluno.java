package com.findpersonal.findpersonaljpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ALUNO")
public class Aluno implements Serializable, DatabaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne
	@JoinColumn(name = "TB_USUARIO_CD_USUARIO")
	private Usuario usuario;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_ALUNO")
	private Integer codigo;
	
	@Column(name = "TX_NOME")
	private String nome;
	
	@Column(name = "DT_NASCIMENTO")
	private Date dataNascimento;
	
	@Column(name = "SG_SEXO")
	private String siglaSexo;

	@Column(name = "NU_CPF")
	private Long cpf;
	
	public Aluno() {
	}

	/**
	 * 
	 * @param usuario
	 * @param codigo
	 * @param nome
	 * @param dataNascimento
	 * @param siglaSexo
	 */
	public Aluno(Usuario usuario, String nome, Date dataNascimento, String siglaSexo) {
		super();
		this.usuario = usuario;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.siglaSexo = siglaSexo;
	}

	
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento
	 *            the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * @return the siglaSexo
	 */
	public String getSiglaSexo() {
		return siglaSexo;
	}

	/**
	 * @param siglaSexo
	 *            the siglaSexo to set
	 */
	public void setSiglaSexo(String siglaSexo) {
		this.siglaSexo = siglaSexo;
	}

	/**
	 * @return the cpf
	 */
	public Long getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

}
