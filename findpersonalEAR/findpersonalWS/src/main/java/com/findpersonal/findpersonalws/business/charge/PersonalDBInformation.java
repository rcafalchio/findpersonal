package com.findpersonal.findpersonalws.business.charge;

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

	public PersonalDBInformation(PersonalDBBuilder personalDBBuilder) {
		this.usuarioEmail = personalDBBuilder.usuarioEmail;
		this.personalExistente = personalDBBuilder.personalExistente;
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

}
