package com.findpersonal.findpersonalutil.constant;

/**
 * Enum que contem os códigos e properties das mensagens de validação
 * 
 * @author Ricardo
 * @since 9 de ago de 2015
 */
public enum CommonValidationEnum {

	VERSAO_APLICATIVO_NAO_RECONHECIDA(500, "versao.aplicativo.nao.conhecida"), SERVICO_NAO_RECONHECIDO(501,
			"servico.nao.conhecido"), ERRO_NOS_PARAMETROS_ENVIO(501, "erro.parametros.envio");

	private CommonValidationEnum(Integer codigo, String propertiesMensage) {
		this.codigo = codigo;
		this.propertiesMensage = propertiesMensage;
	}

	private String propertiesMensage;
	private Integer codigo;

	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * @return the propertiesMensage
	 */
	public String getPropertiesMensage() {
		return propertiesMensage;
	}
}
