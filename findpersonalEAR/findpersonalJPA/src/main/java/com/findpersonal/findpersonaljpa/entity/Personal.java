package com.findpersonal.findpersonaljpa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the tb_personal database table.
 * 
 */
@Entity
@Table(name = "TB_PERSONAL")
@NamedQuery(name = "Personal.findAll", query = "SELECT t FROM Personal t")
public class Personal implements Serializable, DatabaseEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_PERSONAL")
	private Integer codigo;

	@Column(name = "TX_NOME")
	private String nome;

	@Column(name = "DT_NASCIMENTO")
	private Date dataNascimento;

	@OneToMany(mappedBy = "personal", fetch = FetchType.LAZY)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<MensalidadePersonal> mensalidades;

	@OneToMany(mappedBy = "personal", fetch = FetchType.LAZY)
	private List<LocalAtendimento> locaisAtendimento;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "tb_personal_CD_PERSONAL", insertable = false, updatable = false)
	private FaixaAulaPersonal faixaAulaPersonal;
	
	@Column(name = "SG_SEXO")
	private String siglaSexo;

	@Column(name = "NU_CPF")
	private Long cpf;

	@Column(name = "CREF")
	private String cref;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name = "TB_PERSONAL_has_TB_ESPECIALIDADE", joinColumns = {
			@JoinColumn(name = "TB_PERSONAL_CD_PERSONAL")}, inverseJoinColumns = {
					@JoinColumn(name = "TB_ESPECIALIDADE_CD_ESPECIALIDADE")})
	private List<Especialidade> especialidades;

	@OneToOne
	@JoinColumn(name = "TB_USUARIO_CD_USUARIO")
	private Usuario usuario;

	public Personal(String nome, List<MensalidadePersonal> mensalidades, List<LocalAtendimento> locaisAtendimento,
			List<Especialidade> especialidades, Usuario usuario) {
		super();
		this.nome = nome;
		// this.mensalidades = mensalidades;
		// this.locaisAtendimento = locaisAtendimento;
		// this.especialidades = especialidades;
		this.usuario = usuario;
	}

	public Personal(String nome, Date dataNascimento) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}

	public Personal() {
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
	 * @return the mensalidades
	 */
	public List<MensalidadePersonal> getMensalidades() {
		return mensalidades;
	}

	/**
	 * @param mensalidades
	 *            the mensalidades to set
	 */
	public void setMensalidades(List<MensalidadePersonal> mensalidades) {
		this.mensalidades = mensalidades;
	}

	/**
	 * @return the locaisAtendimento
	 */
	public List<LocalAtendimento> getLocaisAtendimento() {
		return locaisAtendimento;
	}

	/**
	 * @param locaisAtendimento
	 *            the locaisAtendimento to set
	 */
	public void setLocaisAtendimento(List<LocalAtendimento> locaisAtendimento) {
		this.locaisAtendimento = locaisAtendimento;
	}

	/**
	 * @return the especialidades
	 */
	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	/**
	 * @param especialidades
	 *            the especialidades to set
	 */
	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
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
	 * @param cpf
	 *            the cpf to set
	 */
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the cref
	 */
	public String getCref() {
		return cref;
	}

	public FaixaAulaPersonal getFaixaAulaPersonal() {
		return faixaAulaPersonal;
	}

	public void setFaixaAulaPersonal(FaixaAulaPersonal faixaAulaPersonal) {
		this.faixaAulaPersonal = faixaAulaPersonal;
	}

	/**
	 * @param cref the cref to set
	 */
	public void setCref(String cref) {
		this.cref = cref;
	}
}