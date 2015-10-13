package com.findpersonal.findpersonalws.business.charge;

import com.findpersonal.findpersonaljpa.entity.Aluno;
import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;
import com.findpersonal.findpersonaljpa.entity.Usuario;
import com.findpersonal.findpersonaljpa.repository.AlunoRepository;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;

public class AlunoCadastroCharger extends ChargeManager {

	public AlunoCadastroCharger(AlunoRepository alunoRepository, UsuarioRepository usuarioRepository) {
		super(alunoRepository, usuarioRepository);
	}

	@Override
	public DatabaseInformation obterCarga(DatabaseEntity entity, DatabaseInformation databaseInformation) {
		Usuario usuarioEmail = null;
		final Aluno aluno = (Aluno) entity;

		if (aluno.getUsuario().getEmail() != null && !aluno.getUsuario().getEmail().isEmpty()) {
			usuarioEmail = usuarioRepository.findByEmail(aluno.getUsuario().getEmail());

		}
		return new AlunoDBInformation.AlunoDBBuilder().usuarioEmail(usuarioEmail).build();
	}

}
