package com.findpersonal.findpersonalws.business.charge;

import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;
import com.findpersonal.findpersonaljpa.repository.PersonalRepository;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;

public class PersonalAtualizacaoCharger extends ChargeManager {

	public PersonalAtualizacaoCharger(PersonalRepository personalRepository, UsuarioRepository usuarioRepository) {
		super(personalRepository, usuarioRepository);
	}

	@Override
	public DatabaseInformation obterCarga(DatabaseEntity entity, DatabaseInformation databaseInformation) {
		boolean emailExistente = false;
		boolean personalExistente = false;
		
		final Personal personal = (Personal) entity;

		if (personal.getUsuario().getEmail() != null && !personal.getUsuario().getEmail().isEmpty()) {
			if (usuarioRepository.findByEmail(personal.getUsuario().getEmail()) != null) {
				emailExistente = true;
			}
		}

		if (personal.getCodigo() != null) {
			personalExistente = personalRepository.exists(personal.getCodigo());
		}
		return new PersonalDBInformation.PersonalDBBuilder().emailExistente(emailExistente).personalExistente(personalExistente)
				.build();
	}

}
