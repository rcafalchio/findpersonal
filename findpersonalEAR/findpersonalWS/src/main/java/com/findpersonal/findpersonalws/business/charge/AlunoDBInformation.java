package com.findpersonal.findpersonalws.business.charge;

/**
 * Dados do aluno retornados da base
 * 
 * @author Ricardo
 *
 */
public class AlunoDBInformation implements DatabaseInformation {

	private Boolean emailExistente;
	private Boolean alunoExistente;

	public AlunoDBInformation(AlunoDBBuilder alunoDBBuilder) {
		this.emailExistente = alunoDBBuilder.emailExistente;
		this.alunoExistente = alunoDBBuilder.alunoExistente;
	}

	public Boolean isEmailExistente() {
		return emailExistente;
	}

	/**
	 * @return the alunoExistente
	 */
	public Boolean isAlunoExistente() {
		return alunoExistente;
	}

	/**
	 * Builder dos dados do Aluno
	 * 
	 * @author Ricardo
	 *
	 */
	public static class AlunoDBBuilder {
		private Boolean emailExistente;
		private Boolean alunoExistente;

		public AlunoDBBuilder() {
		}

		public AlunoDBBuilder emailExistente(Boolean emailExistente) {
			this.emailExistente = emailExistente;
			return this;
		}

		public AlunoDBBuilder alunoExistente(Boolean alunoExistente) {
			this.alunoExistente = alunoExistente;
			return this;
		}

		public AlunoDBInformation build() {
			return new AlunoDBInformation(this);
		}
	}

}
