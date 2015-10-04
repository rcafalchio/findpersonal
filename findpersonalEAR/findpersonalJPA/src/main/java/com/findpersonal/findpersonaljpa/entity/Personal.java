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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * The persistent class for the tb_personal database table.
 * 
 */
@Entity
@Table(name = "TB_PERSONAL")
@NamedQuery(name = "Personal.findAll", query = "SELECT t FROM Personal t")
public class Personal implements Serializable, DatabaseEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_PERSONAL")
	private Integer codigo;

	@Column(name = "TX_NOME")
	private String nome;

	@Column(name = "DT_NASCIMENTO")
	private Date dataNascimento;

	@OneToMany(mappedBy = "personal", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<MensalidadePersonal> mensalidades;

	@OneToMany(mappedBy = "personal", fetch = FetchType.EAGER)
	private List<LocalAtendimento> locaisAtendimento;

	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name = "TB_PERSONAL_has_TB_ESPECIALIDADE", joinColumns = {
			@JoinColumn(name = "TB_PERSONAL_CD_PERSONAL") }, inverseJoinColumns = {
					@JoinColumn(name = "TB_ESPECIALIDADE_CD_ESPECIALIDADE") })
	private List<Especialidade> especialidades;

	@OneToOne
	@JoinColumn(name = "TB_USUARIO_TX_LOGIN")
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<LocalAtendimento> getLocaisAtendimento() {
		return locaisAtendimento;
	}

	public void setLocaisAtendimento(List<LocalAtendimento> locaisAtendimento) {
		this.locaisAtendimento = locaisAtendimento;
	}

	public List<MensalidadePersonal> getMensalidades() {
		return mensalidades;
	}

	public void setMensalidades(List<MensalidadePersonal> mensalidades) {
		this.mensalidades = mensalidades;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

}