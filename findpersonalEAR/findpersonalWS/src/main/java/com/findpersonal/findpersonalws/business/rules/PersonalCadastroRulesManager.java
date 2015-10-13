package com.findpersonal.findpersonalws.business.rules;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;
import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonalutil.constant.ValidationEnum;
import com.findpersonal.findpersonalws.business.charge.DatabaseInformation;
import com.findpersonal.findpersonalws.business.charge.PersonalDBInformation;
import com.findpersonal.findpersonalws.exception.BusinessException;
import com.findpersonal.findpersonalws.exception.PersonalException;

/**
 * Realiza as validações referente as operações com o Aluno
 * 
 * @author Ricardo
 * @since 9 de ago de 2015
 */
@Component
public class PersonalCadastroRulesManager extends RulesManager {

	private static final Logger LOGGER = LogManager.getLogger(PersonalCadastroRulesManager.class);

	private List<ValidationEnum> listaValidacoes;
	private PersonalDBInformation personalDBInformation;

	/**
	 * Default constructor
	 */
	public PersonalCadastroRulesManager() {
		listaValidacoes = new ArrayList<ValidationEnum>();
	}

	@Override
	public void executarRegras(DatabaseInformation databaseInformation, DatabaseEntity databaseEntity)
			throws BusinessException {
		final Personal personal = (Personal) databaseEntity;
		this.personalDBInformation = (PersonalDBInformation) databaseInformation;
		// VALIDA SE O USUARIO JA EXISTE
		this.validarEmailUsuario(personal);
		// VERIFICA SE DEVE VOLTAR ALGUMA VALIDACAO
		if (!listaValidacoes.isEmpty()) {
			throw new PersonalException(listaValidacoes);
		}
	}

	/**
	 * Valida se o usuário já existe na base de dados
	 * 
	 * @param personal
	 * @param listaValidacoes
	 */
	private void validarEmailUsuario(Personal personal) {
		if (personal.getUsuario().getEmail() != null && !personal.getUsuario().getEmail().isEmpty()) {
			if (personalDBInformation.getUsuarioEmail() != null) {
				LOGGER.warn("EMAIL JÁ EXISTENTE " + personal.getUsuario().getEmail());
				listaValidacoes.add(ValidationEnum.EMAIL_JA_EXISTE);
			}
		}
	}

}
