package com.findpersonal.findpersonalws.business.rules;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.findpersonal.findpersonaljpa.entity.Aluno;
import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;
import com.findpersonal.findpersonalutil.constant.CadastroValidationEnum;
import com.findpersonal.findpersonalws.business.charge.AlunoDBInformation;
import com.findpersonal.findpersonalws.business.charge.DatabaseInformation;
import com.findpersonal.findpersonalws.exception.AlunoException;

/**
 * Realiza as validações referente as operações com o Aluno
 * 
 * @author Ricardo
 * @since 9 de ago de 2015
 */
public class AlunoCadastroRulesManager extends RulesManager {

	private static final Logger LOGGER = LogManager.getLogger(AlunoCadastroRulesManager.class);

	private List<CadastroValidationEnum> listaValidacoes;
	private AlunoDBInformation alunoDBInformation;

	/**
	 * Constructor
	 * 
	 * @param aluno
	 * @param usuarioRepository
	 */
	public AlunoCadastroRulesManager() {
		listaValidacoes = new ArrayList<CadastroValidationEnum>();
	}

	@Override
	public void executarRegras(DatabaseInformation databaseInformation, DatabaseEntity entity) throws AlunoException {
		this.alunoDBInformation = (AlunoDBInformation) databaseInformation;
		// VALIDA O PREENCHIMENTO DOS CAMPOS PRINCIPAIS
		this.validarCadastro((Aluno) entity);
		// VALIDA SE O USUARIO JA EXISTE
		this.validarExistenciaUsuario((Aluno) entity);
		// VERIFICA SE DEVE VOLTAR ALGUMA VALIDACAO
		if (!listaValidacoes.isEmpty()) {
			throw new AlunoException(listaValidacoes);
		}

	}

	/**
	 * Valida os dados do aluno
	 * 
	 * @param entity
	 * 
	 * @param aluno
	 * @param listaValidacoes
	 */
	private void validarCadastro(Aluno aluno) {

		if (aluno.getCodigo() != null) {
			LOGGER.warn("O CODIGO DO USUARIO NAO DEVE SER INFORMADO NO CADASTRO");
			listaValidacoes.add(CadastroValidationEnum.CODIGO_INFORMADO_INCORRETAMENTE);
		}

		if (aluno == null || aluno.getDataNascimento() == null || aluno.getNome() == null
				|| aluno.getSiglaSexo() == null || aluno.getUsuario() == null || aluno.getUsuario().getEmail() == null
				|| aluno.getUsuario().getSenha() == null || aluno.getUsuario().getEmail() == null) {
			LOGGER.warn("CAMPOS PRINCIPAIS DO CADASTRO DO ALUNO NAO PREENCHIDOS");
			listaValidacoes.add(CadastroValidationEnum.CAMPOS_NAO_PREENCHIDOS);
		}
	}

	/**
	 * Valida se o usuário já existe na base de dados
	 * 
	 * @param aluno
	 * 
	 * @param aluno
	 * @param listaValidacoes
	 */
	private void validarExistenciaUsuario(Aluno aluno) {
		if (aluno.getUsuario().getEmail() != null && !aluno.getUsuario().getEmail().isEmpty()) {
			if (alunoDBInformation.isEmailExistente()) {
				LOGGER.warn("email JÁ EXISTENTE " + aluno.getUsuario().getEmail());
				listaValidacoes.add(CadastroValidationEnum.LOGIN_JA_EXISTE);
			}
		}
	}

}
