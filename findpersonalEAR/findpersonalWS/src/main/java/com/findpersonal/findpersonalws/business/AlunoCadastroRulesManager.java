package com.findpersonal.findpersonalws.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.findpersonal.findpersonaljpa.entity.Aluno;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;
import com.findpersonal.findpersonalutil.constant.CadastroValidationEnum;
import com.findpersonal.findpersonalws.exception.AlunoException;

/**
 * Realiza as validações referente as operações com o Aluno
 * 
 * @author Ricardo
 * @since 9 de ago de 2015
 */
@Component
public class AlunoCadastroRulesManager implements RulesManager {

	private static final Logger LOGGER = LogManager.getLogger(AlunoCadastroRulesManager.class);

	private Aluno aluno;
	private UsuarioRepository usuarioRepository;

	/**
	 * Default constructor
	 */
	public AlunoCadastroRulesManager() {
	}

	/**
	 * Constructor
	 * 
	 * @param aluno
	 * @param usuarioRepository
	 */
	public AlunoCadastroRulesManager(Aluno aluno, UsuarioRepository usuarioRepository) {
		this.aluno = aluno;
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public void executarRegras() throws AlunoException {
		List<CadastroValidationEnum> listaValidacoes = new ArrayList<CadastroValidationEnum>();
		// VALIDA O PREENCHIMENTO DOS CAMPOS PRINCIPAIS
		this.validarCadastro(aluno, listaValidacoes);
		// VALIDA SE O USUARIO JA EXISTE
		this.validarExistenciaUsuario(aluno, listaValidacoes);
		// VERIFICA SE DEVE VOLTAR ALGUMA VALIDACAO
		if (!listaValidacoes.isEmpty()) {
			throw new AlunoException(listaValidacoes);
		}

	}

	/**
	 * Valida os dados do aluno
	 * 
	 * @param aluno
	 * @param listaValidacoes
	 */
	private void validarCadastro(final Aluno aluno, List<CadastroValidationEnum> listaValidacoes) {

		if (aluno.getCodigo() != null) {
			LOGGER.warn("O CODIGO DO USUARIO NAO DEVE SER INFORMADO NO CADASTRO");
			listaValidacoes.add(CadastroValidationEnum.CODIGO_INFORMADO_INCORRETAMENTE);
		}

		if (aluno == null || aluno.getDataNascimento() == null || aluno.getNome() == null
				|| aluno.getSiglaSexo() == null || aluno.getUsuario() == null || aluno.getUsuario().getLogin() == null
				|| aluno.getUsuario().getSenha() == null || aluno.getUsuario().getEmail() == null) {
			LOGGER.warn("CAMPOS PRINCIPAIS DO CADASTRO DO ALUNO NAO PREENCHIDOS");
			listaValidacoes.add(CadastroValidationEnum.CAMPOS_NAO_PREENCHIDOS);
		}
	}

	/**
	 * Valida se o usuário já existe na base de dados
	 * 
	 * @param aluno
	 * @param listaValidacoes
	 */
	private void validarExistenciaUsuario(Aluno aluno, List<CadastroValidationEnum> listaValidacoes) {
		if (aluno.getUsuario().getLogin() != null && !aluno.getUsuario().getLogin().isEmpty()) {
			if (usuarioRepository.findOne(aluno.getUsuario().getLogin()) != null) {
				LOGGER.warn("LOGIN JÁ EXISTENTE " + aluno.getUsuario().getLogin());
				listaValidacoes.add(CadastroValidationEnum.LOGIN_JA_EXISTE);
			}
		}
	}

}
