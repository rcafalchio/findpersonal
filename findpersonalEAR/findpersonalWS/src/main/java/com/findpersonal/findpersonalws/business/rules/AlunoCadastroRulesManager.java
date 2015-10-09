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
		// VALIDA SE O USUARIO JA EXISTE
		this.validarExistenciaUsuario((Aluno) entity);
		// VERIFICA SE DEVE VOLTAR ALGUMA VALIDACAO
		if (!listaValidacoes.isEmpty()) {
			throw new AlunoException(listaValidacoes);
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
