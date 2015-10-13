package com.findpersonal.findpersonalws.business.rules;

import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;
import com.findpersonal.findpersonalws.business.charge.DatabaseInformation;
import com.findpersonal.findpersonalws.exception.BusinessException;

public class AlunoAtualizacaoRules100 extends RulesDecorator {

	public AlunoAtualizacaoRules100(RulesManager rulesManager) {
		super(rulesManager);
	}

	@Override
	public void executarRegras(DatabaseInformation databaseInformation, DatabaseEntity databaseEntity)
			throws BusinessException {
		// TODO Implementar as regras da versão 1.00
		super.rulesManager.executarRegras(databaseInformation, databaseEntity);
	}

}
