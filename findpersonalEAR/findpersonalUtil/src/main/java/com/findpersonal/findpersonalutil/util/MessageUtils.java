package com.findpersonal.findpersonalutil.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.findpersonal.findpersonalutil.constant.ValidationEnum;
import com.findpersonal.findpersonalutil.vo.ErroNegocio;

@SuppressWarnings(value = "all")
public class MessageUtils {

	private static Locale ptBR = new Locale("pt", "BR");

	/**
	 * Get Bundle
	 * 
	 * @return ResourceBundle
	 */
	public static ResourceBundle getBundle() {
		return ResourceBundle.getBundle("messages", ptBR);
	}

	/**
	 * Recupera Erros
	 * 
	 * @param listaValidacoes
	 * @return List<Erro>
	 */
	public static List<ErroNegocio> getErros(List listaValidacoes) {
		final List<ErroNegocio> erros = new ArrayList<ErroNegocio>();
		ErroNegocio erro = null;
		for (Object object : listaValidacoes) {
			if(object instanceof ValidationEnum){
				final ValidationEnum validationEnum = (ValidationEnum) object;
				erro = new ErroNegocio(validationEnum.getCodigo(), getBundle().getString(validationEnum.getPropertiesMensage()));
				erros.add(erro);
			}else if (object instanceof ValidationEnum){
				final ValidationEnum validationEnum = (ValidationEnum) object;
				erro = new ErroNegocio(validationEnum.getCodigo(),
						getBundle().getString(validationEnum.getPropertiesMensage()));
				erros.add(erro);
			}
		}
		return erros;
	}

}
