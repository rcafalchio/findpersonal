package com.findpersonal.findpersonalws.business.charge;

import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;
import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonaljpa.repository.PersonalRepository;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;

public class PersonalCadastroCharger extends ChargeManager {

	public PersonalCadastroCharger(PersonalRepository personalRepository, UsuarioRepository usuarioRepository) {
		super(personalRepository, usuarioRepository);
	}

	@Override
	public DatabaseInformation obterCarga(DatabaseEntity entity, DatabaseInformation databaseInformation) {
		boolean emailExistente = false;
		final Personal personal = (Personal) entity;

		if (personal.getUsuario().getEmail() != null && !personal.getUsuario().getEmail().isEmpty()) {
			if (usuarioRepository.findByEmail(personal.getUsuario().getEmail()) != null) {
				emailExistente = true;
			}
		}
		return new PersonalDBInformation.PersonalDBBuilder().emailExistente(emailExistente).build();
	}

}
