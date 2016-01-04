package com.findpersonal.findpersonalws.business.charge;

import java.util.List;

import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonaljpa.entity.Usuario;

/**
 * Dados do aluno retornados da base
 * 
 * @author Ricardo
 *
 */
public class PersonalDBInformation implements DatabaseInformation {

	private Usuario usuarioEmail = null;
	private Boolean personalExistente;
	private List<Personal> personaisPorFaixa;

	public PersonalDBInformation(PersonalDBBuilder personalDBBuilder) {
		this.usuarioEmail = personalDBBuilder.usuarioEmail;
		this.personalExistente = personalDBBuilder.personalExistente;
		this.personaisPorFaixa = personalDBBuilder.personaisPorFaixa;
	}

	/**
	 * Builder dos dados do Aluno
	 * 
	 * @author Ricardo
	 *
	 */
	public static class PersonalDBBuilder {
		private Usuario usuarioEmail;
		private Boolean personalExistente;
		private List<Personal> personaisPorFaixa;

		public PersonalDBBuilder() {
		}

		public PersonalDBBuilder usuarioEmail(Usuario usuarioEmail) {
			this.usuarioEmail = usuarioEmail;
			return this;
		}

		public PersonalDBBuilder personalExistente(Boolean personalExistente) {
			this.personalExistente = personalExistente;
			return this;
		}
		
		public PersonalDBBuilder personaisPorFaixa(List<Personal> personaisPorFaixa) {
			this.personaisPorFaixa = personaisPorFaixa;
			return this;
		}

		public PersonalDBInformation build() {
			return new PersonalDBInformation(this);
		}

	}

	/**
	 * @return the personalExistente
	 */
	public Boolean isPersonalExistente() {
		return personalExistente;
	}

	/**
	 * @return the usuarioEmail
	 */
	public Usuario getUsuarioEmail() {
		return usuarioEmail;
	}

	public List<Personal> getPersonaisPorFaixa() {
		return personaisPorFaixa;
	}

}
