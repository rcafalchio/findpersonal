package com.findpersonal.findpersonalws.business.charge;

/**
 * Dados do aluno retornados da base
 * 
 * @author Ricardo
 *
 */
public class AlunoDBInformation implements DatabaseInformation {

	private Boolean loginExistente;

	public AlunoDBInformation(AlunoDBBuilder alunoDBBuilder) {
		this.loginExistente = alunoDBBuilder.loginExistente;
	}

	public Boolean isLoginExistente() {
		return loginExistente;
	}

	/**
	 * Builder dos dados do Aluno
	 * 
	 * @author Ricardo
	 *
	 */
	public static class AlunoDBBuilder {
		private Boolean loginExistente;

		public AlunoDBBuilder() {
		}

		public AlunoDBBuilder loginExistente(Boolean loginExistente) {
			this.loginExistente = loginExistente;
			return this;
		}

		public AlunoDBInformation build() {
			return new AlunoDBInformation(this);
		}
	}

}
