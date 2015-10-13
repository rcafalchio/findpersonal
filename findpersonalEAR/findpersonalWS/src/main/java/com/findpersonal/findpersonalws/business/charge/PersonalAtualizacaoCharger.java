package com.findpersonal.findpersonalws.business.charge;

import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonaljpa.entity.Usuario;
import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;
import com.findpersonal.findpersonaljpa.repository.PersonalRepository;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;

public class PersonalAtualizacaoCharger extends ChargeManager {

	public PersonalAtualizacaoCharger(PersonalRepository personalRepository, UsuarioRepository usuarioRepository) {
		super(personalRepository, usuarioRepository);
	}

	@Override
	public DatabaseInformation obterCarga(DatabaseEntity entity, DatabaseInformation databaseInformation) {
		Usuario usuarioEmail = null;
		boolean personalExistente = false;
		
		final Personal personal = (Personal) entity;

		if (personal.getUsuario().getEmail() != null && !personal.getUsuario().getEmail().isEmpty()) {
			usuarioEmail = usuarioRepository.findByEmail(personal.getUsuario().getEmail());
		}

		if (personal.getCodigo() != null) {
			personalExistente = personalRepository.exists(personal.getCodigo());
		}
		return new PersonalDBInformation.PersonalDBBuilder().usuarioEmail(usuarioEmail).personalExistente(personalExistente)
				.build();
	}

}
