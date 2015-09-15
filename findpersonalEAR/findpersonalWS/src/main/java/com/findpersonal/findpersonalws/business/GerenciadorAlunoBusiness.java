package com.findpersonal.findpersonalws.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findpersonal.findpersonaljpa.entity.Aluno;
import com.findpersonal.findpersonaljpa.repository.AlunoRepository;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;
import com.findpersonal.findpersonalws.exception.BusinessException;

/**
 * Classe responsável por controlar o cadastro do aluno
 * 
 * @author Ricardo
 *
 */
@Service
public class GerenciadorAlunoBusiness {

	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	AlunoCadastroRulesManager rulesManager;

	/**
	 * Cadastrar um novo aluno
	 * 
	 * @param Aluno
	 *            Dados do aluno
	 * @return boolean
	 * @throws BusinessException
	 */
	public void cadastrarAluno(final Aluno aluno) throws BusinessException {
		// Realiza as validações dos dados
		final RulesManager rulesManager = new AlunoCadastroRulesManager(aluno, usuarioRepository);
		rulesManager.executarRegras();
		// AJUSTA O RELACIONAMENTO MANY TO MANY
		aluno.getUsuario().setAluno(aluno);
		// Persiste o aluno em base
		usuarioRepository.save(aluno.getUsuario());
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
