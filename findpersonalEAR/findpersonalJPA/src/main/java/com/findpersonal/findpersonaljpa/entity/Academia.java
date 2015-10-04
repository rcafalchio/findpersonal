package com.findpersonal.findpersonaljpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tb_academia database table.
 * 
 */
@Entity
@Table(name = "tb_academia")
@NamedQuery(name = "Academia.findAll", query = "SELECT t FROM Academia t")
public class Academia implements Serializable, DatabaseEntity{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CD_ACADEMIA")
	private int codigo;

	@Column(name = "TX_NOME")
	private String nome;

	// bi-directional many-to-many association to TbEndereco
	@ManyToMany(mappedBy = "tbAcademias")
	private List<Endereco> enderecos;

	// bi-directional many-to-many association to TbMensalidadeAcademia
	@ManyToMany(mappedBy = "tbAcademias")
	private List<MensalidadeAcademia> mensalidadeAcademia;

}