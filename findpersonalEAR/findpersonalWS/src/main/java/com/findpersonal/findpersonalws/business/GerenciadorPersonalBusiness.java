package com.findpersonal.findpersonalws.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findpersonal.findpersonaljpa.entity.LocalAtendimento;
import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonaljpa.repository.PersonalRepository;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;
import com.findpersonal.findpersonalws.exception.BusinessException;

/**
 * Classe responsável por controlar o cadastro do aluno
 * 
 * @author Ricardo
 *
 */
@Service
public class GerenciadorPersonalBusiness {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	PersonalRepository personalRepository;

	/**
	 * Cadastrar um novo personal
	 * 
	 * @param Personal
	 *            Dados do personal
	 * @return boolean
	 * @throws BusinessException
	 */
	public void cadastrarPersonal(final Personal personal) throws BusinessException {
		// Realiza as validações dos dados
		final RulesManager rulesManager = new PersonalCadastroRulesManager(personal, usuarioRepository);
		rulesManager.executarRegras();
		// AJUSTA O RELACIONAMENTO MANY TO MANY
		personal.getUsuario().setPersonal(personal);
		// Persiste o aluno em base
		usuarioRepository.save(personal.getUsuario());
	}

	/**
	 * Cadastrar os locais de atendimento do personal
	 */
	public void cadastrarAtendimento(final Personal personal, final List<LocalAtendimento> locaisAtendimento)
			throws BusinessException {
		// Realiza as validações dos dados
		final RulesManager rulesManager = new AtendimentoCadastroRulesManager(locaisAtendimento, personal);
		rulesManager.executarRegras();
		// Persiste o aluno em base
		usuarioRepository.save(personal.getUsuario());
	}

	public Personal buscarPersonalPorCodigo(Integer codigo) {
		return personalRepository.findOne(codigo);
	}
}
