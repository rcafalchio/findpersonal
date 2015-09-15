package com.findpersonal.findpersonaljpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrimaryKeyJoinColumn;

@Embeddable
public class LocalAtendimentoPK implements Serializable {

	public LocalAtendimentoPK() {
	}
	
	public LocalAtendimentoPK(Integer codigoPersonal, Integer codigoEstado, Integer codigoZona, Integer codigoPais,
			Integer codigoCidade) {
		super();
		this.codigoPersonal = codigoPersonal;
		this.codigoEstado = codigoEstado;
		this.codigoZona = codigoZona;
		this.codigoPais = codigoPais;
		this.codigoCidade = codigoCidade;
	}

	private static final long serialVersionUID = 1L;

	@PrimaryKeyJoinColumn
	@Column(name = "TB_PERSONAL_CD_PERSONAL")
	private Integer codigoPersonal;

	@PrimaryKeyJoinColumn
	@Column(name = "TB_ESTADO_CD_ESTADO")
	private Integer codigoEstado;

	@PrimaryKeyJoinColumn
	@Column(name = "TB_ZONA_CD_ZONA")
	private Integer codigoZona;

	@PrimaryKeyJoinColumn
	@Column(name = "TB_PAIS_CD_PAIS")
	private Integer codigoPais;

	@PrimaryKeyJoinColumn
	@Column(name = "TB_CIDADE_CD_CIDADE")
	private Integer codigoCidade;

	public Integer getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(Integer codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public Integer getCodigoZona() {
		return codigoZona;
	}

	public void setCodigoZona(Integer codigoZona) {
		this.codigoZona = codigoZona;
	}

	public Integer getCodigoCidade() {
		return codigoCidade;
	}

	public void setCodigoCidade(Integer codigoCidade) {
		this.codigoCidade = codigoCidade;
	}

	public Integer getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(Integer codigoPais) {
		this.codigoPais = codigoPais;
	}

	public Integer getCodigoPersonal() {
		return codigoPersonal;
	}

	public void setCodigoPersonal(Integer codigoPersonal) {
		this.codigoPersonal = codigoPersonal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoCidade == null) ? 0 : codigoCidade.hashCode());
		result = prime * result + ((codigoEstado == null) ? 0 : codigoEstado.hashCode());
		result = prime * result + ((codigoPais == null) ? 0 : codigoPais.hashCode());
		result = prime * result + ((codigoZona == null) ? 0 : codigoZona.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocalAtendimentoPK other = (LocalAtendimentoPK) obj;
		if (codigoCidade == null) {
			if (other.codigoCidade != null)
				return false;
		} else if (!codigoCidade.equals(other.codigoCidade))
			return false;
		if (codigoEstado == null) {
			if (other.codigoEstado != null)
				return false;
		} else if (!codigoEstado.equals(other.codigoEstado))
			return false;
		if (codigoPais == null) {
			if (other.codigoPais != null)
				return false;
		} else if (!codigoPais.equals(other.codigoPais))
			return false;
		if (codigoZona == null) {
			if (other.codigoZona != null)
				return false;
		} else if (!codigoZona.equals(other.codigoZona))
			return false;
		return true;
	}

}
