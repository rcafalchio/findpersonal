package com.findpersonal.findpersonalws.business.rules;

import com.findpersonal.findpersonalutil.constant.ApplicationVersionEnum;
import com.findpersonal.findpersonalutil.constant.CommonValidationEnum;
import com.findpersonal.findpersonalutil.constant.RestServicesEnum;
import com.findpersonal.findpersonalws.exception.BusinessException;
import com.findpersonal.findpersonalws.exception.ExpectedApplicationException;

public final class RulesManagerFactory {

	private static RulesManagerFactory instance = null;

	public static RulesManagerFactory getInstance() {
		if (instance == null) {
			instance = new RulesManagerFactory();
		}
		return instance;
	}

	public RulesManager obterRulesManager(double applicationVersion, RestServicesEnum restServicesEnum)
			throws BusinessException, ExpectedApplicationException {
		RulesManager rulesManager = null;

		final ApplicationVersionEnum applicationVersionEnum = ApplicationVersionEnum.getEnum(applicationVersion);

		// Verifica se a versão é conhecida
		if (ApplicationVersionEnum.VERSION_NOT_MATCH.equals(applicationVersionEnum)) {
			throw new BusinessException(CommonValidationEnum.VERSAO_APLICATIVO_NAO_RECONHECIDA);
		}

		switch (restServicesEnum) {
			case CADASTRO_ALUNO :
				rulesManager = new RulesCreator().createAlunoCadastroManager(applicationVersionEnum);
				break;
			case CADASTRO_PERSONAL :

				break;
			default :
				throw new BusinessException(CommonValidationEnum.VERSAO_APLICATIVO_NAO_RECONHECIDA);
		}
		return rulesManager;
	}

}
