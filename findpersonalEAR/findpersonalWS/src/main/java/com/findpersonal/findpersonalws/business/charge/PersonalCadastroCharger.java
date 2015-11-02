package com.findpersonal.findpersonalws.business.charge;

import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;
import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonaljpa.entity.Usuario;
import com.findpersonal.findpersonaljpa.repository.PersonalRepository;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;

public class PersonalCadastroCharger extends ChargeManager {

	public PersonalCadastroCharger(PersonalRepository personalRepository, UsuarioRepository usuarioRepository) {
		super(personalRepository, usuarioRepository);
	}

	@Override
	public DatabaseInformation obterCarga(DatabaseEntity entity, DatabaseInformation databaseInformation) {
		Usuario usuarioEmail = null;
		final Personal personal = (Personal) entity;

		if (personal.getUsuario().getEmail() != null && !personal.getUsuario().getEmail().isEmpty()) {
			usuarioEmail = usuarioRepository.findByEmail(personal.getUsuario().getEmail()).get();
		}
		return new PersonalDBInformation.PersonalDBBuilder().usuarioEmail(usuarioEmail).build();
	}

}
