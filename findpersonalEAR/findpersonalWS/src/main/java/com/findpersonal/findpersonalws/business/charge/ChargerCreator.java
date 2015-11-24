package com.findpersonal.findpersonalws.business.charge;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.findpersonal.findpersonaljpa.repository.AlunoRepository;
import com.findpersonal.findpersonaljpa.repository.PersonalRepository;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;
import com.findpersonal.findpersonalutil.constant.ApplicationVersionEnum;
import com.findpersonal.findpersonalutil.constant.Constants;
import com.findpersonal.findpersonalws.exception.ExpectedApplicationException;

@Component
public class ChargerCreator {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	PersonalRepository personalRepository;

	/**
	 * Método recursivo que retorna os ChargeManagers
	 * 
	 * @param newInstance
	 * @param listEnum
	 * @param chargerName
	 * @return
	 * @throws ExpectedApplicationException
	 */
	private ChargeManager instanciarChargeManager(ChargeManager newInstance, List<ApplicationVersionEnum> listEnum,
			String chargerName) throws ExpectedApplicationException {
		try {
			if (!listEnum.isEmpty()) {
				try {
					Class<?> clazz = Class.forName(
							Constants.CHARGER_PACKAGE.concat(chargerName.concat(listEnum.remove(0).getVersionName())));
					Constructor<?> constructor = clazz.getConstructor(ChargeManager.class);
					this.instanciarChargeManager((ChargeManager) constructor.newInstance(newInstance), listEnum,
							chargerName);
				} catch (ClassNotFoundException e) {
					// Se não encontrar o carregador daquela versão pula para a próxima
					this.instanciarChargeManager(newInstance, listEnum, chargerName);
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
	 * Cria o Chager do Cadastro do Aluno
	 * 
	 * @param applicationVersionEnum
	 * @return ChargeManager
	 * @throws ExpectedApplicationException
	 */
	public ChargeManager createAlunoChargeManager(ApplicationVersionEnum applicationVersionEnum)
			throws ExpectedApplicationException {
		final List<ApplicationVersionEnum> listEnum = applicationVersionEnum.recuperarOldVersions();
		return instanciarChargeManager(new AlunoCadastroCharger(), listEnum,
				"AlunoCharger");
	}

	/**
	 * Cria o Chager da atualização do Cadastro do Aluno
	 * 
	 * @param applicationVersionEnum
	 * @return ChargeManager
	 * @throws ExpectedApplicationException
	 */
	public ChargeManager createAlunoAtualizacaoChargeManager(ApplicationVersionEnum applicationVersionEnum)
			throws ExpectedApplicationException {
		final List<ApplicationVersionEnum> listEnum = applicationVersionEnum.recuperarOldVersions();
		return instanciarChargeManager(new AlunoAtualizacaoCharger(), listEnum,
				"AlunoAtualizacaoCharger");
	}

	/**
	 * Cria o Chager da atualização do Cadastro do Personal
	 * 
	 * @param applicationVersionEnum
	 * @return ChargeManager
	 * @throws ExpectedApplicationException
	 */
	public ChargeManager createPersonalAtualizacaoChargeManager(ApplicationVersionEnum applicationVersionEnum)
			throws ExpectedApplicationException {
		final List<ApplicationVersionEnum> listEnum = applicationVersionEnum.recuperarOldVersions();
		return instanciarChargeManager(new PersonalAtualizacaoCharger(), listEnum,
				"PersonalAtualizacaoCharger");
	}

	/**
	 * Cria o Chager do Cadastro do Personal
	 * 
	 * @param applicationVersionEnum
	 * @return ChargeManager
	 * @throws ExpectedApplicationException
	 */
	public ChargeManager createPersonalChargeManager(ApplicationVersionEnum applicationVersionEnum)
			throws ExpectedApplicationException {
		final List<ApplicationVersionEnum> listEnum = applicationVersionEnum.recuperarOldVersions();
		return instanciarChargeManager(new PersonalCadastroCharger(), listEnum,
				"PersonalCharger");
	}

}
