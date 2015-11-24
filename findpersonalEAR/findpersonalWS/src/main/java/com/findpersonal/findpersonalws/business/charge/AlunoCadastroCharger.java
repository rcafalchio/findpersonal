package com.findpersonal.findpersonalws.business.charge;

import java.util.Optional;

import com.findpersonal.findpersonaljpa.entity.Aluno;
import com.findpersonal.findpersonaljpa.entity.Usuario;

public class AlunoCadastroCharger extends ChargeManager {

	@Override
	public DatabaseInformation obterCarga(ChargeInputData chargeInputData) {
		Optional<Usuario> usuarioEmail = null;
		final InputDataAluno inputDataAluno = (InputDataAluno) chargeInputData;
		final Aluno aluno = inputDataAluno.getAluno();
		if (aluno.getUsuario().getEmail() != null && !aluno.getUsuario().getEmail().isEmpty()) {
			usuarioEmail = super.chargeService.usuarioRepository.findByEmail(aluno.getUsuario().getEmail());
		}
		return new AlunoDBInformation.AlunoDBBuilder().usuarioEmail(usuarioEmail.orElse(null)).build();
	}

}
