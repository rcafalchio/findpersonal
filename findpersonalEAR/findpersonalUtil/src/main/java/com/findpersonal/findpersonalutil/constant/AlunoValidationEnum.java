package com.findpersonal.findpersonalutil.constant;

/**
 * Enum que contem os códigos e properties das mensagens de validação de
 * cadastro
 * 
 * @author Ricardo
 * @since 9 de ago de 2015
 */
public enum AlunoValidationEnum {

	CAMPOS_NAO_PREENCHIDOS(1, "cadastro.campos.nao.preenchidos"), CODIGO_INFORMADO_INCORRETAMENTE(2,
			"codigo.informado.incorretamente"), LOGIN_JA_EXISTE(3, "cadastro.login.ja.existe");

	private AlunoValidationEnum(Integer codigo, String propertiesMensage) {
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
