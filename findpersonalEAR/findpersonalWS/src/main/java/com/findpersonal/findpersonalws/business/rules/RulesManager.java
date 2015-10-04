package com.findpersonal.findpersonalws.business.rules;

import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;
import com.findpersonal.findpersonalws.business.charge.DatabaseInformation;
import com.findpersonal.findpersonalws.exception.BusinessException;

/**
 * Rules Interface
 * 
 * @author Ricardo
 * @since 9 de ago de 2015
 */
public abstract class RulesManager {

	/**
	 * Inicia a execução de regras
	 * 
	 * @param databaseInformation
	 *            Informações necessárias para validação
	 * @throws BusinessException
	 *             Exception de negócio
	 */
	public abstract void executarRegras(DatabaseInformation databaseInformation, DatabaseEntity databaseEntity) throws BusinessException;

}
