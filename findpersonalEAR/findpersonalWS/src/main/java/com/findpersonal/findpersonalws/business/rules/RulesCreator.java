package com.findpersonal.findpersonalws.business.rules;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.findpersonal.findpersonalutil.constant.ApplicationVersionEnum;
import com.findpersonal.findpersonalutil.constant.Constants;
import com.findpersonal.findpersonalws.exception.ExpectedApplicationException;

public class RulesCreator {

	/**
	 * Método responsável por retornar os RulesMAnagers
	 * 
	 * @param newInstance
	 * @param listEnum
	 * @param rulesName
	 * @return
	 * @throws ExpectedApplicationException
	 */
	private RulesManager instanciarRulesManager(RulesManager newInstance, List<ApplicationVersionEnum> listEnum,
			String rulesName) throws ExpectedApplicationException {
		try {
			if (!listEnum.isEmpty()) {
				try {
					Class<?> clazz = Class.forName(
							Constants.RULES_PACKAGE.concat(rulesName.concat(listEnum.remove(0).getVersionName())));
					Constructor<?> constructor = clazz.getConstructor(RulesManager.class);
					this.instanciarRulesManager((RulesManager) constructor.newInstance(newInstance), listEnum,
							rulesName);
				} catch (ClassNotFoundException e) {
					// Se não encontrar o carregador daquela versão pula para a próxima
					this.instanciarRulesManager(newInstance, listEnum, rulesName);
				}
			}
		} catch (NoSuchMethodException e) {
			throw new ExpectedApplicationException(e);
		} catch (SecurityException e) {
			throw new ExpectedApplicationException(e);
		} catch (InstantiationException e) {
			throw new ExpectedApplicationException(e);
		} catch (IllegalAccessException e) {
			throw new ExpectedApplicationException(e);
		} catch (IllegalArgumentException e) {
			throw new ExpectedApplicationException(e);
		} catch (InvocationTargetException e) {
			throw new ExpectedApplicationException(e);
		}
		return newInstance;
	}

	/**
	 * Cria o Rules Manager da atualização do cadastro do Aluno
	 * 
	 * @param applicationVersionEnum
	 * @return RulesManager
	 * @throws ExpectedApplicationException
	 */
	public RulesManager createAlunoAtualizacaoManager(ApplicationVersionEnum applicationVersionEnum)
			throws ExpectedApplicationException {
		final List<ApplicationVersionEnum> listEnum = applicationVersionEnum.recuperarOldVersions();
		return instanciarRulesManager(new AlunoAtualizacaoRulesManager(), listEnum, "AlunoAtualizacaoRules");
	}

	/**
	 * Cria o Rules Manager do cadastro do Personal
	 * 
	 * @param applicationVersionEnum
	 * @return RulesManager
	 * @throws ExpectedApplicationException
	 */
	public RulesManager createPersonalCadastroManager(ApplicationVersionEnum applicationVersionEnum)
			throws ExpectedApplicationException {
		final List<ApplicationVersionEnum> listEnum = applicationVersionEnum.recuperarOldVersions();
		return instanciarRulesManager(new PersonalCadastroRulesManager(), listEnum, "PersonalCadastroRules");
	}

	/**
	 * Cria o Rules Manager do cadastro do Personal
	 * 
	 * @param applicationVersionEnum
	 * @return RulesManager
	 * @throws ExpectedApplicationException
	 */
	public RulesManager createAlunoCadastroManager(ApplicationVersionEnum applicationVersionEnum)
			throws ExpectedApplicationException {
		final List<ApplicationVersionEnum> listEnum = applicationVersionEnum.recuperarOldVersions();
		return instanciarRulesManager(new AlunoCadastroRulesManager(), listEnum, "AlunoCadastroRules");
	}

	/**
	 * Cria o Rules Manager da atualização do cadastro do Personal
	 * 
	 * @param applicationVersionEnum
	 * @return RulesManager
	 * @throws ExpectedApplicationException
	 */
	public RulesManager createPersonalAtualizacaoManager(ApplicationVersionEnum applicationVersionEnum)
			throws ExpectedApplicationException {
		final List<ApplicationVersionEnum> listEnum = applicationVersionEnum.recuperarOldVersions();
		return instanciarRulesManager(new PersonalAtualizacaoRulesManager(), listEnum, "PersonalAtualizacaoRules");
	}

}
