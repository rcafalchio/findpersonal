package com.findpersonal.findpersonalws.business.charge;

public class AlunoCharger100 extends ChargeDecorator {

	public AlunoCharger100(ChargeManager chargeManager) {
		super(chargeManager);
	}

	@Override
	public DatabaseInformation obterCarga(ChargeInputData chargeInputData) {
		DatabaseInformation dbInformation = super.chargeManager.obterCarga(chargeInputData);
		// Se necessário adicionar novas consultas aqui
		return dbInformation;
	}

}
