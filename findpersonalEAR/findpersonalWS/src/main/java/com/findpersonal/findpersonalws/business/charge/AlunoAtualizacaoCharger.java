package com.findpersonal.findpersonalws.business.charge;

import com.findpersonal.findpersonaljpa.entity.Aluno;
import com.findpersonal.findpersonaljpa.entity.Usuario;

public class AlunoAtualizacaoCharger extends ChargeManager {

	@Override
	public DatabaseInformation obterCarga(ChargeInputData chargeInputData) {
		Usuario usuarioEmail = null;
		boolean alunoExistente = false;
		final InputDataAluno inputDataAluno = (InputDataAluno) chargeInputData;
		final Aluno aluno = inputDataAluno.getAluno();

		if (aluno.getUsuario().getEmail() != null && !aluno.getUsuario().getEmail().isEmpty()) {
			usuarioEmail = chargeService.usuarioRepository.findByEmail(aluno.getUsuario().getEmail()).orElse(null);
		}
		if (aluno.getCodigo() != null) {
			alunoExistente = super.chargeService.alunoRepository.exists(aluno.getCodigo());
		}
		return new AlunoDBInformation.AlunoDBBuilder().usuarioEmail(usuarioEmail).alunoExistente(alunoExistente)
				.build();
	}

}
