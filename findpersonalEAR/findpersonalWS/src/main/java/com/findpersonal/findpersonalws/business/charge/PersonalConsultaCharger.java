package com.findpersonal.findpersonalws.business.charge;

import java.util.Optional;

import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonaljpa.entity.Usuario;
import com.findpersonal.findpersonaljpa.repository.PersonalRepository;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;
import com.findpersonal.findpersonalws.rest.dto.FiltroPersonalJSON;

public class PersonalConsultaCharger extends ChargeManager {
	
	@Override
	public DatabaseInformation obterCarga(final ChargeInputData chargeInputData) {
		Optional<Usuario> usuarioEmail = null;
		final InputDataPersonal inputDataPersonal = (InputDataPersonal) chargeInputData;
		final FiltroPersonalJSON filtroPersonalJSON = inputDataPersonal.getFiltroPersonalJSON();
//		super.chargeService.usuarioRepository.findByEmail(email);
//		
//		if(filtroPersonalJSON.gert)
//
//		if (personal.getUsuario().getEmail() != null && !personal.getUsuario().getEmail().isEmpty()) {
//			usuarioEmail = super.chargeService.usuarioRepository.findByEmail(personal.getUsuario().getEmail());
//		}
		return new PersonalDBInformation.PersonalDBBuilder().usuarioEmail(usuarioEmail.orElse(null)).build();
	}

}
