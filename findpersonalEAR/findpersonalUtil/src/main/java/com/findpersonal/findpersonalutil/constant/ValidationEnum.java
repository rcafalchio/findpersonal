package com.findpersonal.findpersonalutil.constant;

/**
 * Enum que contem os códigos e properties das mensagens de validação de cadastro
 * 
 * @author Ricardo
 * @since 9 de ago de 2015
 */
public enum ValidationEnum {

	CAMPOS_NAO_PREENCHIDOS(1, "cadastro.campos.nao.preenchidos"),
	EMAIL_JA_EXISTE(3, "cadastro.email.ja.existe"), 
	ALUNO_NAO_EXISTE(20, "cadastro.atualizacao.aluno.nao.exite"), 
	PERSONAL_NAO_EXISTE(30, "cadastro.atualizacao.personal.nao.exite"),
	VERSAO_APLICATIVO_NAO_RECONHECIDA(500, "versao.aplicativo.nao.conhecida"), 
	SERVICO_NAO_RECONHECIDO(501, "servico.nao.conhecido"), 
	ERRO_NOS_PARAMETROS_ENVIO(501, "erro.parametros.envio") ;

	private ValidationEnum(Integer codigo, String propertiesMensage) {
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
