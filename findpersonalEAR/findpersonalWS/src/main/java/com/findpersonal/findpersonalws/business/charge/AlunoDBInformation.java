package com.findpersonal.findpersonalws.business.charge;

import com.findpersonal.findpersonaljpa.entity.Usuario;

/**
 * Dados do aluno retornados da base
 * 
 * @author Ricardo
 *
 */
public class AlunoDBInformation implements DatabaseInformation {

	private Usuario usuarioEmail;
	private Boolean alunoExistente;

	public AlunoDBInformation(AlunoDBBuilder alunoDBBuilder) {
		this.usuarioEmail = alunoDBBuilder.usuarioEmail;
		this.alunoExistente = alunoDBBuilder.alunoExistente;
	}

	public Usuario getUsuarioEmail() {
		return usuarioEmail;
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
		private Usuario usuarioEmail;
		private Boolean alunoExistente;

		public AlunoDBBuilder() {
		}

		public AlunoDBBuilder usuarioEmail(Usuario usuarioEmail) {
			this.usuarioEmail = usuarioEmail;
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
