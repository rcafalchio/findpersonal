package com.findpersonal.findpersonalws.business.charge;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.findpersonal.findpersonaljpa.repository.AlunoRepository;
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

	public ChargeManager createAlunoChargeManager(ApplicationVersionEnum applicationVersionEnum)
			throws ExpectedApplicationException {
		final List<ApplicationVersionEnum> listEnum = applicationVersionEnum.recuperarOldVersions();
		return instanciarChargeManager(new AlunoCharger(alunoRepository, usuarioRepository), listEnum, "AlunoCharger");
	}

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
					listEnum.remove(0).getVersionName();
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

}
