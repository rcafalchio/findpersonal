package com.findpersonal.findpersonalws.business.rules;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;
import com.findpersonal.findpersonalutil.constant.ValidationEnum;
import com.findpersonal.findpersonalws.business.charge.PersonalDBInformation;
import com.findpersonal.findpersonalws.business.charge.DatabaseInformation;
import com.findpersonal.findpersonalws.exception.PersonalException;

/**
 * Realiza as validações referente as operações com o Personal
 * 
 * @author Ricardo
 * @since 9 de ago de 2015
 */
public class PersonalAtualizacaoRulesManager extends RulesManager {

	private static final Logger LOGGER = LogManager.getLogger(PersonalCadastroRulesManager.class);

	private List<ValidationEnum> listaValidacoes;
	private PersonalDBInformation personalDBInformation;

	/**
	 * Constructor
	 * 
	 * @param personal
	 * @param usuarioRepository
	 */
	public PersonalAtualizacaoRulesManager() {
		listaValidacoes = new ArrayList<ValidationEnum>();
	}

	@Override
	public void executarRegras(DatabaseInformation databaseInformation, DatabaseEntity entity)
			throws PersonalException {
		this.personalDBInformation = (PersonalDBInformation) databaseInformation;
		// VALIDA SE O USUARIO EXISTE
		this.validarExistenciaUsuario((Personal) entity);
		// VALIDA SE O EMAIL JA EXISTE
		this.validarExistenciaEmail((Personal) entity);
		// VERIFICA SE DEVE VOLTAR ALGUMA VALIDACAO
		if (!listaValidacoes.isEmpty()) {
			throw new PersonalException(listaValidacoes);
		}

	}

	/**
	 * Verifica se o usuário existe para poder atualizar
	 * 
	 * @param entity
	 */
	private void validarExistenciaUsuario(Personal personal) {
		if (!this.personalDBInformation.isPersonalExistente()) {
			LOGGER.warn("Codigo do personal não existe para atualização " + personal.getCodigo());
			listaValidacoes.add(ValidationEnum.PERSONAL_NAO_EXISTE);
		}
	}

	/**
	 * Valida se o usuário já existe o e-mail na base de dados
	 * 
	 * @param personal
	 * 
	 * @param personal
	 * @param listaValidacoes
	 */
	private void validarExistenciaEmail(Personal personal) {
		if (personal.getUsuario().getEmail() != null && !personal.getUsuario().getEmail().isEmpty()) {
			if (personalDBInformation.getUsuarioEmail() != null
					&& personalDBInformation.getUsuarioEmail().getPersonal() != null && !personal.getCodigo()
							.equals(personalDBInformation.getUsuarioEmail().getPersonal().getCodigo())) {
				LOGGER.warn("email JÁ EXISTENTE " + personal.getUsuario().getEmail());
				listaValidacoes.add(ValidationEnum.EMAIL_JA_EXISTE);
			}
		}
	}

}
