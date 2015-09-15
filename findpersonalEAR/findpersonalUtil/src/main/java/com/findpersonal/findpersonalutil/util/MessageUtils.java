package com.findpersonal.findpersonalutil.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.findpersonal.findpersonalutil.constant.CadastroValidationEnum;
import com.findpersonal.findpersonalutil.vo.ErroNegocio;

@SuppressWarnings(value = "all")
public class MessageUtils {

	private static Locale ptBR = new Locale("pt", "BR");

	/**
	 * Get Bundle
	 * 
	 * @return ResourceBundle
	 */
	private static ResourceBundle getBundle() {
		return ResourceBundle.getBundle("messages", ptBR);
	}

	/**
	 * Recupera mensagem do properties
	 * 
	 * @param cadastroValidationEnum
	 *            Enum validações
	 * @return String
	 */
	public static String getMensagemCadastro(CadastroValidationEnum cadastroValidationEnum) {
		return getBundle().getString(cadastroValidationEnum.getPropertiesMensage());
	}

	/**
	 * Recupera Erros do cadastro
	 * 
	 * @param listaValidacoes
	 * @return List<Erro>
	 */
	public static List<ErroNegocio> getErros(List listaValidacoes) {
		final List<ErroNegocio> erros = new ArrayList<ErroNegocio>();
		ErroNegocio erro = null;
		for (Object object : listaValidacoes) {
			final CadastroValidationEnum validationEnum = (CadastroValidationEnum) object;
			erro = new ErroNegocio(validationEnum.getCodigo(), getMensagemCadastro(validationEnum));
			erros.add(erro);
		}
		return erros;
	}

}
