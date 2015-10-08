package com.findpersonal.findpersonalws.business.charge;

import com.findpersonal.findpersonaljpa.entity.Aluno;
import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;
import com.findpersonal.findpersonaljpa.repository.AlunoRepository;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;

public class AlunoCharger extends ChargeManager {

	public AlunoCharger(AlunoRepository alunoRepository, UsuarioRepository usuarioRepository) {
		super(alunoRepository, usuarioRepository);
	}

	@Override
	public DatabaseInformation obterCarga(DatabaseEntity entity, DatabaseInformation databaseInformation) {
		boolean emailExistente = false;
		final Aluno aluno = (Aluno) entity;
		
		if (aluno.getUsuario().getEmail() != null && !aluno.getUsuario().getEmail().isEmpty()) {
			if (usuarioRepository.findByEmail(aluno.getUsuario().getEmail()) != null) {
				emailExistente = true;
			}
		}
		return new AlunoDBInformation.AlunoDBBuilder().emailExistente(emailExistente).build();
	}

}
