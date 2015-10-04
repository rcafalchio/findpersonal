package com.findpersonal.findpersonalws.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findpersonal.findpersonaljpa.entity.Aluno;
import com.findpersonal.findpersonaljpa.repository.AlunoRepository;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;
import com.findpersonal.findpersonalutil.constant.RestServicesEnum;
import com.findpersonal.findpersonalws.business.charge.ChargeManager;
import com.findpersonal.findpersonalws.business.charge.ChargeManagerFactory;
import com.findpersonal.findpersonalws.business.charge.DatabaseInformation;
import com.findpersonal.findpersonalws.business.rules.RulesManager;
import com.findpersonal.findpersonalws.business.rules.RulesManagerFactory;
import com.findpersonal.findpersonalws.exception.BusinessException;
import com.findpersonal.findpersonalws.exception.ExpectedApplicationException;
import com.findpersonal.findpersonalws.rest.CadastroAlunoRest;
import com.findpersonal.findpersonalws.util.ConverterUtils;

/**
 * Classe responsável por controlar o cadastro do aluno
 * 
 * @author Ricardo
 *
 */
@Service
public class GerenciadorAlunoBusiness {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	AlunoRepository alunoRepository;

	/**
	 * Cadastrar um novo aluno
	 * 
	 * @param CadastroAlunoRest
	 *            Dados do aluno
	 * @return boolean
	 * @throws BusinessException
	 * @throws ExpectedApplicationException
	 */
	public Integer cadastrarAluno(final CadastroAlunoRest cadastroAlunoRest)
			throws BusinessException, ExpectedApplicationException {
		// Converte para entity
		final Aluno aluno = ConverterUtils.convertToAluno(cadastroAlunoRest);
		// Realiza a carga das informações do serviço de Aluno;
		final ChargeManager chargeManager = ChargeManagerFactory.getInstance()
				.obterChargeManager(cadastroAlunoRest.getApplicationVersion(), RestServicesEnum.CADASTRO_ALUNO);
		final DatabaseInformation databaseInformation = chargeManager.obterCarga(aluno, null);
		// Realiza as validações dos dados
		final RulesManager rulesManager = RulesManagerFactory.getInstance()
				.obterRulesManager(cadastroAlunoRest.getApplicationVersion(), RestServicesEnum.CADASTRO_ALUNO);
		rulesManager.executarRegras(databaseInformation, aluno);
		// AJUSTA O RELACIONAMENTO MANY TO MANY
		aluno.getUsuario().setAluno(aluno);
		// Persiste o aluno em base
		return usuarioRepository.save(aluno.getUsuario()).getAluno().getCodigo();
	}

	/**
	 * Recupera o aluno por seu código
	 * 
	 * @param codigo
	 *            Codigo do aluno
	 * @return Aluno
	 */
	public Aluno buscarAlunoPorCodigo(Integer codigo) {
		return alunoRepository.findOne(codigo);
	}

	/**
	 * Lista todos os alunos da base
	 * 
	 * @return List<Aluno>
	 */
	public List<Aluno> buscarAlunos() {
		return alunoRepository.findAll();
	}

}
