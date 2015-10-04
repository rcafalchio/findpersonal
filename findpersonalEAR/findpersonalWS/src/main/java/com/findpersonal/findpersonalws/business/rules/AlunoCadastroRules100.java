package com.findpersonal.findpersonalws.business.rules;

import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;
import com.findpersonal.findpersonalws.business.charge.DatabaseInformation;
import com.findpersonal.findpersonalws.exception.BusinessException;

public class AlunoCadastroRules100 extends RulesDecorator {

	public AlunoCadastroRules100(RulesManager rulesManager) {
		super(rulesManager);
	}

	@Override
	public void executarRegras(DatabaseInformation databaseInformation, DatabaseEntity databaseEntity)
			throws BusinessException {
		super.rulesManager.executarRegras(databaseInformation, databaseEntity);
		// TESTE
		System.out.println("############################################################");
		System.out.println("Aplicou a regra 1.00");
		System.out.println("############################################################");
	}

}
