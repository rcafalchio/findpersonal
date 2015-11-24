package com.findpersonal.findpersonalws.business.charge;

import java.util.Optional;

import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonaljpa.entity.Usuario;

public class PersonalAtualizacaoCharger extends ChargeManager {

	@Override
	public DatabaseInformation obterCarga(ChargeInputData chargeInputData) {
		Optional<Usuario> usuarioEmail = null;
		boolean personalExistente = false;
		
		final InputDataPersonal inputDataPersonal = (InputDataPersonal) chargeInputData;
		final Personal personal = inputDataPersonal.getPersonal();

		if (personal.getUsuario().getEmail() != null && !personal.getUsuario().getEmail().isEmpty()) {
			usuarioEmail = super.chargeService.usuarioRepository.findByEmail(personal.getUsuario().getEmail());
		}

		if (personal.getCodigo() != null) {
			personalExistente = super.chargeService.personalRepository.exists(personal.getCodigo());
		}
		return new PersonalDBInformation.PersonalDBBuilder().usuarioEmail(usuarioEmail.orElse(null)).personalExistente(personalExistente)
				.build();
	}

}
