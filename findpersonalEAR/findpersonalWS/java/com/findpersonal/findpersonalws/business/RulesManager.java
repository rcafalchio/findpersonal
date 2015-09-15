package com.findpersonal.findpersonalws.business;

import com.findpersonal.findpersonalws.exception.BusinessException;

/**
 * Validator Interface
 * 
 * @author Ricardo
 * @since 9 de ago de 2015
 */
public interface RulesManager {

	/**
	 * Inicia a execução de regras
	 * 
	 * @throws BusinessException
	 */
	public void executarRegras() throws BusinessException;

}
