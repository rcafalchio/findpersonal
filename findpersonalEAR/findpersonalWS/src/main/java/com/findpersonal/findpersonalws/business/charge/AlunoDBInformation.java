package com.findpersonal.findpersonalws.business.charge;

/**
 * Dados do aluno retornados da base
 * 
 * @author Ricardo
 *
 */
public class AlunoDBInformation implements DatabaseInformation {

	private Boolean emailExistente;

	public AlunoDBInformation(AlunoDBBuilder alunoDBBuilder) {
		this.emailExistente = alunoDBBuilder.emailExistente;
	}

	public Boolean isEmailExistente() {
		return emailExistente;
	}

	/**
	 * Builder dos dados do Aluno
	 * 
	 * @author Ricardo
	 *
	 */
	public static class AlunoDBBuilder {
		private Boolean emailExistente;

		public AlunoDBBuilder() {
		}

		public AlunoDBBuilder emailExistente(Boolean emailExistente) {
			this.emailExistente = emailExistente;
			return this;
		}

		public AlunoDBInformation build() {
			return new AlunoDBInformation(this);
		}
	}

}
