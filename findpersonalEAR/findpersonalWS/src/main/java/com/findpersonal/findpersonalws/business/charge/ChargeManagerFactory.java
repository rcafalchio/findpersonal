package com.findpersonal.findpersonalws.business.charge;

import org.apache.log4j.Logger;

import com.findpersonal.findpersonalutil.constant.ApplicationVersionEnum;
import com.findpersonal.findpersonalutil.constant.CommonValidationEnum;
import com.findpersonal.findpersonalutil.constant.RestServicesEnum;
import com.findpersonal.findpersonalws.exception.BusinessException;
import com.findpersonal.findpersonalws.exception.ExpectedApplicationException;
import com.findpersonal.findpersonalws.util.SpringContext;

/**
 * Factory que recupera o ChargeManager responsável por carregar os dados do serviço
 * 
 * @author Ricardo
 *
 */
public final class ChargeManagerFactory {

	private static final Logger LOGGER = Logger.getLogger(ChargeManagerFactory.class);

	private static ChargeManagerFactory instance = null;

	public static ChargeManagerFactory getInstance() {
		if (instance == null) {
			instance = new ChargeManagerFactory();
		}
		return instance;
	}

	public ChargeManager obterChargeManager(double applicationVersion, RestServicesEnum restServicesEnum)
			throws BusinessException, ExpectedApplicationException {
		ChargeManager chargeManager;
		chargeManager = null;
		final ApplicationVersionEnum applicationVersionEnum = ApplicationVersionEnum.getEnum(applicationVersion);

		// Verifica se a versão é conhecida
		if (ApplicationVersionEnum.VERSION_NOT_MATCH.equals(applicationVersionEnum)) {
			LOGGER.warn("A versão do aplicativo não é conhecida = Versao " + applicationVersion);
			throw new BusinessException(CommonValidationEnum.VERSAO_APLICATIVO_NAO_RECONHECIDA);
		}

		final ChargerCreator chargerCreator = (ChargerCreator) SpringContext.getApplicationContext()
				.getBean("chargerCreator");

		switch (restServicesEnum) {

			case CADASTRO_ALUNO :
				chargeManager = chargerCreator.createAlunoChargeManager(applicationVersionEnum);
				break;
			case CADASTRO_PERSONAL :
				// chargeManager = chargerCreator.createAlunoChargeManager(applicationVersionEnum);
				break;
			case ATUALIZAR_CADASTRO_ALUNO :
				chargeManager = chargerCreator.createAlunoChargeManager(applicationVersionEnum);
				break;
			default :
				throw new BusinessException(CommonValidationEnum.SERVICO_NAO_RECONHECIDO);
		}
		return chargeManager;
	}

}
