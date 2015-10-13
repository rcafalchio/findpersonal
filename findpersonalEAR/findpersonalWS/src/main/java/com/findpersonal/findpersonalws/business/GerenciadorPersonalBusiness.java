package com.findpersonal.findpersonalws.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findpersonal.findpersonaljpa.entity.LocalAtendimento;
import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonaljpa.entity.Usuario;
import com.findpersonal.findpersonaljpa.repository.PersonalRepository;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;
import com.findpersonal.findpersonalutil.constant.RestServicesEnum;
import com.findpersonal.findpersonalws.business.charge.ChargeManager;
import com.findpersonal.findpersonalws.business.charge.ChargeManagerFactory;
import com.findpersonal.findpersonalws.business.charge.DatabaseInformation;
import com.findpersonal.findpersonalws.business.rules.RulesManager;
import com.findpersonal.findpersonalws.business.rules.RulesManagerFactory;
import com.findpersonal.findpersonalws.exception.BusinessException;
import com.findpersonal.findpersonalws.exception.ExpectedApplicationException;
import com.findpersonal.findpersonalws.rest.CadastroPersonalRest;
import com.findpersonal.findpersonalws.rest.EnvioAtualizacaoPersonalRest;
import com.findpersonal.findpersonalws.util.ConverterUtils;

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
	 * @param CadastroPersonalRest
	 *            Dados do personal
	 * @return Integer codigo Personal
	 * @throws BusinessException
	 * @throws ExpectedApplicationException
	 */
	public Integer cadastrarPersonal(final CadastroPersonalRest cadastroPersonalRest)
			throws BusinessException, ExpectedApplicationException {

		// Converte para entity
		final Personal personal = ConverterUtils.convertToPersonal(cadastroPersonalRest);
		personal.getUsuario().setAtivo(Boolean.TRUE);
		// Realiza a carga das informações do serviço de Aluno;
		final ChargeManager chargeManager = ChargeManagerFactory.getInstance()
				.obterChargeManager(cadastroPersonalRest.getApplicationVersion(), RestServicesEnum.CADASTRO_PERSONAL);
		final DatabaseInformation databaseInformation = chargeManager.obterCarga(personal, null);
		// Realiza as validações dos dados
		final RulesManager rulesManager = RulesManagerFactory.getInstance()
				.obterRulesManager(cadastroPersonalRest.getApplicationVersion(), RestServicesEnum.CADASTRO_PERSONAL);
		rulesManager.executarRegras(databaseInformation, personal);
		// AJUSTA O RELACIONAMENTO MANY TO MANY
		personal.getUsuario().setPersonal(personal);
		final Personal personalSaved = usuarioRepository.save(personal.getUsuario()).getPersonal();
		// Persiste o aluno em base
		return personalSaved.getCodigo();
	}

	/**
	 * Cadastrar os locais de atendimento do personal
	 */
	public void cadastrarAtendimento(final Personal personal, final List<LocalAtendimento> locaisAtendimento)
			throws BusinessException {
		// Realiza as validações dos dados
		// final RulesManager rulesManager = new AtendimentoCadastroRulesManager(locaisAtendimento, personal);
		// rulesManager.executarRegras();
		// Persiste o aluno em base
		usuarioRepository.save(personal.getUsuario());
	}

	public Personal buscarPersonalPorCodigo(Integer codigo) {
		return personalRepository.findOne(codigo);
	}

	/**
	 * Atualiza o cadastro do personal
	 * 
	 * @param atulizacaoPersonalRest
	 *            dados do personal
	 * @return Integer
	 * @throws BusinessException
	 *             exception de negocio
	 * @throws ExpectedApplicationException
	 *             exception esperada
	 */
	public Integer atualizarPersonal(EnvioAtualizacaoPersonalRest atulizacaoPersonalRest)
			throws BusinessException, ExpectedApplicationException {
		// Converte para entity
		final Personal personal = ConverterUtils.convertToPersonal(atulizacaoPersonalRest);
		final ChargeManager chargeManager = ChargeManagerFactory.getInstance().obterChargeManager(
				atulizacaoPersonalRest.getApplicationVersion(), RestServicesEnum.ATUALIZAR_CADASTRO_PERSONAL);
		final DatabaseInformation databaseInformation = chargeManager.obterCarga(personal, null);
		// Realiza as validações dos dados
		final RulesManager rulesManager = RulesManagerFactory.getInstance().obterRulesManager(
				atulizacaoPersonalRest.getApplicationVersion(), RestServicesEnum.ATUALIZAR_CADASTRO_PERSONAL);
		rulesManager.executarRegras(databaseInformation, personal);

		final Usuario usuario = personal.getUsuario();
		final Personal personalDatabase = personalRepository.findOne(personal.getCodigo());
		final Usuario usuarioDatabase = personalDatabase.getUsuario();
		ConverterUtils.copyEntity(personal, personalDatabase, "usuario", "codigo");
		ConverterUtils.copyEntity(usuario, usuarioDatabase, "personal", "codigo");
		personalDatabase.setUsuario(usuarioDatabase);
		usuarioDatabase.setPersonal(personalDatabase);
		// Persiste o aluno em base
		return usuarioRepository.save(usuarioDatabase).getPersonal().getCodigo();

	}
}
