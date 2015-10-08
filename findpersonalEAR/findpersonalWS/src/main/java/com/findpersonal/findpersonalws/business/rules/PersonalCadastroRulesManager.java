package com.findpersonal.findpersonalws.business.rules;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;
import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;
import com.findpersonal.findpersonalutil.constant.CadastroValidationEnum;
import com.findpersonal.findpersonalws.business.charge.DatabaseInformation;
import com.findpersonal.findpersonalws.exception.AlunoException;
import com.findpersonal.findpersonalws.exception.BusinessException;

/**
 * Realiza as validações referente as operações com o Aluno
 * 
 * @author Ricardo
 * @since 9 de ago de 2015
 */
@Component
public class PersonalCadastroRulesManager extends RulesManager {

	private static final Logger LOGGER = LogManager.getLogger(PersonalCadastroRulesManager.class);

	private Personal personal;
	private UsuarioRepository usuarioRepository;

	public PersonalCadastroRulesManager(Personal personal, UsuarioRepository usuarioRepository) {
		super();
		this.personal = personal;
		this.usuarioRepository = usuarioRepository;
	}

	/**
	 * Default constructor
	 */
	public PersonalCadastroRulesManager() {
	}

	/**
	 * Valida os dados do aluno
	 * 
	 * @param personal
	 * @param listaValidacoes
	 */
	private void validarCadastro(final Personal personal, List<CadastroValidationEnum> listaValidacoes) {

		if (personal.getCodigo() != null) {
			LOGGER.warn("O CODIGO DO PERSONAL NAO DEVE SER INFORMADO NO CADASTRO");
			listaValidacoes.add(CadastroValidationEnum.CODIGO_INFORMADO_INCORRETAMENTE);
		}

		if (personal == null || personal.getDataNascimento() == null
				|| personal.getNome() == null && personal.getUsuario() == null
				|| personal.getUsuario().getEmail() == null) {
			LOGGER.warn("CAMPOS PRINCIPAIS DO CADASTRO DO PERSONAL NAO PREENCHIDOS");
			listaValidacoes.add(CadastroValidationEnum.CAMPOS_NAO_PREENCHIDOS);
		}
	}

	/**
	 * Valida se o usuário já existe na base de dados
	 * 
	 * @param personal
	 * @param listaValidacoes
	 */
	private void validarExistenciaUsuario(Personal personal, List<CadastroValidationEnum> listaValidacoes) {
		if (personal.getUsuario().getEmail() != null && !personal.getUsuario().getEmail().isEmpty()) {
			if (usuarioRepository.findOne(personal.getUsuario().getEmail()) != null) {
				LOGGER.warn("LOGIN JÁ EXISTENTE " + personal.getUsuario().getEmail());
				listaValidacoes.add(CadastroValidationEnum.LOGIN_JA_EXISTE);
			}
		}
	}

	@Override
	public void executarRegras(DatabaseInformation databaseInformation, DatabaseEntity databaseEntity)
			throws BusinessException {
		List<CadastroValidationEnum> listaValidacoes = new ArrayList<CadastroValidationEnum>();
		// VALIDA O PREENCHIMENTO DOS CAMPOS PRINCIPAIS
		this.validarCadastro(personal, listaValidacoes);
		// VALIDA SE O USUARIO JA EXISTE
		this.validarExistenciaUsuario(personal, listaValidacoes);
		// VERIFICA SE DEVE VOLTAR ALGUMA VALIDACAO
		if (!listaValidacoes.isEmpty()) {
			throw new AlunoException(listaValidacoes);
		}
	}

}
