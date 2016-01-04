package com.findpersonal.findpersonalws.business.charge;

import java.util.List;

import com.findpersonal.findpersonaljpa.entity.FaixaAulaPersonal;
import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonalws.rest.dto.FiltroPersonalJSON;

public class PersonalConsultaCharger extends ChargeManager {
	
	@Override
	public DatabaseInformation obterCarga(final ChargeInputData chargeInputData) {
		final InputDataPersonal inputDataPersonal = (InputDataPersonal) chargeInputData;
		final FiltroPersonalJSON filtroPersonalJSON = inputDataPersonal.getFiltroPersonalJSON();
		
		final List<Personal> personaisPorFaixa = buscarPersonalPorValor(filtroPersonalJSON.getCodigoValor());
		
		
//		super.chargeService.usuarioRepository.findByEmail(email);
//		
//		if(filtroPersonalJSON.gert)
//
//		if (personal.getUsuario().getEmail() != null && !personal.getUsuario().getEmail().isEmpty()) {
//			usuarioEmail = super.chargeService.usuarioRepository.findByEmail(personal.getUsuario().getEmail());
//		}
		return new PersonalDBInformation.PersonalDBBuilder().personaisPorFaixa(personaisPorFaixa).build();
	}

	/**
	 * Busca os personais pela faixa informada.
	 * 
	 * @param codigoValor
	 * @return List<Personal>
	 */
	private List<Personal> buscarPersonalPorValor(Integer codigoValor) {
		final FaixaAulaPersonal faixaAulaPersonal = super.chargeService.faixaAulaPersonalRepository.findOne(codigoValor);
		return faixaAulaPersonal.getPersonais();
	}

}
