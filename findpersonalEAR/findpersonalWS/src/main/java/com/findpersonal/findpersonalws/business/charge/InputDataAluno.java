package com.findpersonal.findpersonalws.business.charge;

import com.findpersonal.findpersonaljpa.entity.Aluno;

public class InputDataAluno implements ChargeInputData {

	private Aluno aluno;

	public InputDataAluno(Aluno aluno) {
		super();
		this.aluno = aluno;
	}

	/**
	 * @return the aluno
	 */
	public Aluno getAluno() {
		return aluno;
	}

}
