package com.findpersonal.findpersonalws.business.rules;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.findpersonal.findpersonaljpa.entity.Aluno;
import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;
import com.findpersonal.findpersonalutil.constant.ValidationEnum;
import com.findpersonal.findpersonalws.business.charge.AlunoDBInformation;
import com.findpersonal.findpersonalws.business.charge.DatabaseInformation;
import com.findpersonal.findpersonalws.exception.AlunoException;

/**
 * Realiza as validações referente as operações com o Aluno
 * 
 * @author Ricardo
 * @since 9 de ago de 2015
 */
public class AlunoAtualizacaoRulesManager extends RulesManager {

	private static final Logger LOGGER = LogManager.getLogger(AlunoCadastroRulesManager.class);

	private List<ValidationEnum> listaValidacoes;
	private AlunoDBInformation alunoDBInformation;

	/**
	 * Constructor
	 * 
	 * @param aluno
	 * @param usuarioRepository
	 */
	public AlunoAtualizacaoRulesManager() {
		listaValidacoes = new ArrayList<ValidationEnum>();
	}

	@Override
	public void executarRegras(DatabaseInformation databaseInformation, DatabaseEntity entity) throws AlunoException {
		this.alunoDBInformation = (AlunoDBInformation) databaseInformation;
		// VALIDA SE O USUARIO EXISTE
		this.validarExistenciaUsuario((Aluno) entity);
		// VALIDA SE O EMAIL JA EXISTE
		this.validarExistenciaEmail((Aluno) entity);
		// VERIFICA SE DEVE VOLTAR ALGUMA VALIDACAO
		if (!listaValidacoes.isEmpty()) {
			throw new AlunoException(listaValidacoes);
		}

	}

	/**
	 * Verifica se o usuário existe para poder atualizar
	 * 
	 * @param entity
	 */
	private void validarExistenciaUsuario(Aluno entity) {
		if (!this.alunoDBInformation.isAlunoExistente()) {
			LOGGER.warn("Codigo do aluno não existe para atualização " + entity.getCodigo());
			listaValidacoes.add(ValidationEnum.ALUNO_NAO_EXISTE);
		}
	}

	/**
	 * Valida se o usuário já existe o e-mail na base de dados
	 * 
	 * @param aluno
	 * 
	 * @param aluno
	 * @param listaValidacoes
	 */
	private void validarExistenciaEmail(Aluno aluno) {
		if (aluno.getUsuario().getEmail() != null && !aluno.getUsuario().getEmail().isEmpty()) {
			if (alunoDBInformation.getUsuarioEmail() != null && alunoDBInformation.getUsuarioEmail().getAluno() != null
					&& !aluno.getCodigo().equals(alunoDBInformation.getUsuarioEmail().getAluno().getCodigo())) {
				LOGGER.warn("email JÁ EXISTENTE " + aluno.getUsuario().getEmail());
				listaValidacoes.add(ValidationEnum.EMAIL_JA_EXISTE);
			}
		}
	}

}
