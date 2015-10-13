package com.findpersonal.findpersonalws.business.charge;

import com.findpersonal.findpersonaljpa.entity.Aluno;
import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;
import com.findpersonal.findpersonaljpa.repository.AlunoRepository;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;

public class AlunoAtualizacaoCharger extends ChargeManager {

	public AlunoAtualizacaoCharger(AlunoRepository alunoRepository, UsuarioRepository usuarioRepository) {
		super(alunoRepository, usuarioRepository);
	}

	@Override
	public DatabaseInformation obterCarga(DatabaseEntity entity, DatabaseInformation databaseInformation) {
		boolean emailExistente = false;
		boolean alunoExistente = false;
		final Aluno aluno = (Aluno) entity;

		if (aluno.getUsuario().getEmail() != null && !aluno.getUsuario().getEmail().isEmpty()) {
			if (usuarioRepository.findByEmail(aluno.getUsuario().getEmail()) != null) {
				emailExistente = true;
			}
		}

		if (aluno.getCodigo() != null) {
			alunoExistente = alunoRepository.exists(aluno.getCodigo());
		}
		return new AlunoDBInformation.AlunoDBBuilder().emailExistente(emailExistente).alunoExistente(alunoExistente)
				.build();
	}

}
