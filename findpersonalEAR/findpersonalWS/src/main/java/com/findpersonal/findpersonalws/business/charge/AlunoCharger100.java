package com.findpersonal.findpersonalws.business.charge;

import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;

public class AlunoCharger100 extends ChargeDecorator {

	public AlunoCharger100(ChargeManager chargeManager) {
		super(chargeManager);
	}

	@Override
	public DatabaseInformation obterCarga(DatabaseEntity entity, DatabaseInformation databaseInformation) {
		DatabaseInformation dbInformation = super.chargeManager.obterCarga(entity, databaseInformation);
		// Se necessário adicionar novas consultas aqui
		return dbInformation;
	}

}
