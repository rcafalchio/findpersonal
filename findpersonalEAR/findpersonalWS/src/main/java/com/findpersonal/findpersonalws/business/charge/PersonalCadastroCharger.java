package com.findpersonal.findpersonalws.business.charge;

import java.util.Optional;

import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonaljpa.entity.Usuario;

public class PersonalCadastroCharger extends ChargeManager {
	
	@Override
	public DatabaseInformation obterCarga(final ChargeInputData chargeInputData) {
		Optional<Usuario> usuarioEmail = null;
		final InputDataPersonal inputDataPersonal = (InputDataPersonal) chargeInputData;
		final Personal personal = inputDataPersonal.getPersonal();


		if (personal.getUsuario().getEmail() != null && !personal.getUsuario().getEmail().isEmpty()) {
			usuarioEmail = super.chargeService.usuarioRepository.findByEmail(personal.getUsuario().getEmail());
		}
		return new PersonalDBInformation.PersonalDBBuilder().usuarioEmail(usuarioEmail.orElse(null)).build();
	}

}
