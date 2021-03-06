package com.findpersonal.findpersonaljpa.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb_mensalidade_academia database table.
 * 
 */
@Embeddable
public class MensalidadeAcademiaPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "DT_MES")
	private int mes;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + mes;
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
		MensalidadeAcademiaPK other = (MensalidadeAcademiaPK) obj;
		if (ano != other.ano)
			return false;
		if (mes != other.mes)
			return false;
		return true;
	}

	@Column(name = "DT_ANO")
	private int ano;

	public MensalidadeAcademiaPK() {
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

}