package com.findpersonal.findpersonalws.business.charge;

/**
 * Dados do aluno retornados da base
 * 
 * @author Ricardo
 *
 */
public class PersonalDBInformation implements DatabaseInformation {

	private Boolean emailExistente;
	private Boolean personalExistente;

	public PersonalDBInformation(PersonalDBBuilder personalDBBuilder) {
		this.emailExistente = personalDBBuilder.emailExistente;
		this.personalExistente = personalDBBuilder.personalExistente;
	}

	/**
	 * Builder dos dados do Aluno
	 * 
	 * @author Ricardo
	 *
	 */
	public static class PersonalDBBuilder {
		private Boolean emailExistente;
		private Boolean personalExistente;

		public PersonalDBBuilder() {
		}

		public PersonalDBBuilder emailExistente(Boolean emailExistente) {
			this.emailExistente = emailExistente;
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
	 * @return the emailExistente
	 */
	public Boolean isEmailExistente() {
		return emailExistente;
	}

	/**
	 * @return the personalExistente
	 */
	public Boolean isPersonalExistente() {
		return personalExistente;
	}

}
