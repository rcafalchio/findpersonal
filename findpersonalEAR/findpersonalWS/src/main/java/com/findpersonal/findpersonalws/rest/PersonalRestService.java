package com.findpersonal.findpersonalws.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonalutil.util.MessageUtils;
import com.findpersonal.findpersonalws.business.GerenciadorPersonalBusiness;
import com.findpersonal.findpersonalws.exception.BusinessException;
import com.findpersonal.findpersonalws.rest.RetornoRest.RetornoRestEnum;

@RestController
@RequestMapping(value = "/Personal")
@Transactional
public class PersonalRestService {

	private static final Logger LOGGER = Logger.getLogger(PersonalRestService.class);

	@Autowired
	private GerenciadorPersonalBusiness gerenciadorPersonalBusiness;

	@RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
	Personal buscarAlunoPorCodigo(@PathVariable Integer codigo) {
		LOGGER.info("INICIO DO SERVICO BUSCAR PERSONAL POR CODIGO");
		Personal personal = null;
		try {
			personal = gerenciadorPersonalBusiness.buscarPersonalPorCodigo(codigo);
		} catch (Exception e) {
			LOGGER.error("Houve um erro no servico BUSCAR PERSONAL POR CODIGO", e);
		} finally {
			LOGGER.info("FIM DO SERVICO BUSCAR PERSONAL POR CODIGO");
		}
		return personal;
	}

	@RequestMapping(value = "/Cadastro", method = RequestMethod.POST)
	ResponseEntity<RetornoRest> cadastrar(@Validated @RequestBody CadastroPersonalRest cadastroPersonalRest) {
		LOGGER.info("INICIO DO SERVICO CADASTRO DE ALUNO");
		ResponseEntity<RetornoRest> retorno = null;
		try {
			Integer codigoPersonal = gerenciadorPersonalBusiness.cadastrarPersonal(cadastroPersonalRest);
			RetornoCadastroRest retornoCadastroRest = new RetornoCadastroRest(RetornoRestEnum.SUCESSO);
			retornoCadastroRest.setCodigoCadastro(codigoPersonal);
			retorno = new ResponseEntity<RetornoRest>(retornoCadastroRest, HttpStatus.OK);
		} catch (BusinessException e) {
			LOGGER.warn("Cadastro não concluído", e);
			retorno = new ResponseEntity<RetornoRest>(new RetornoCadastroRest(RetornoRestEnum.ERRO_NEGOCIO,
					MessageUtils.getErros(e.getListaValidacoes())), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Houve um erro no servico CADASTRO DE ALUNO", e);
			retorno = new ResponseEntity<RetornoRest>(new RetornoCadastroRest(RetornoRestEnum.SISTEMA_INDISPONIVEL),
					HttpStatus.OK);
		} finally {
			LOGGER.info("FIM DO SERVICO CADASTRO DE ALUNO");
		}
		return retorno;
	}

	@RequestMapping(value = "/Cadastro/Atualizar", method = RequestMethod.POST)
	ResponseEntity<RetornoRest> cadastrar(@Validated @RequestBody EnvioAtualizacaoPersonalRest atualizacaoPersonalRest) {
		LOGGER.info("INICIO DO SERVICO ATUALIZAR CADASTRO DE PERSONAL");
		ResponseEntity<RetornoRest> retorno = null;
		try {
			Integer codigoAluno = gerenciadorPersonalBusiness.atualizarPersonal(atualizacaoPersonalRest);
			RetornoCadastroRest retornoCadastroRest = new RetornoCadastroRest(RetornoRestEnum.SUCESSO);
			retornoCadastroRest.setCodigoCadastro(codigoAluno);
			retorno = new ResponseEntity<RetornoRest>(retornoCadastroRest, HttpStatus.OK);
		} catch (BusinessException e) {
			LOGGER.warn("Cadastro não concluído", e);
			retorno = new ResponseEntity<RetornoRest>(new RetornoCadastroRest(RetornoRestEnum.ERRO_NEGOCIO,
					MessageUtils.getErros(e.getListaValidacoes())), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Houve um erro no servico ATUALIZAR CADASTRO DE PERSONAL", e);
			retorno = new ResponseEntity<RetornoRest>(new RetornoCadastroRest(RetornoRestEnum.SISTEMA_INDISPONIVEL),
					HttpStatus.OK);
		} finally {
			LOGGER.info("FIM DO SERVICO ATUALIZAR CADASTRO DE PERSONAL");
		}
		return retorno;
	}

//	@RequestMapping(value = "/Cadastro/Atendimento", method = RequestMethod.POST)
//	ResponseEntity<RetornoRest> cadastrarAtendimento(@RequestBody Personal personal,
//			@RequestBody List<LocalAtendimento> locaisAtendimento) {
//		LOGGER.info("INICIO DO SERVICO CADASTRO DE ATENDIMENTO");
//		RetornoCadastroRest retorno = null;
//		try {
//			gerenciadorPersonalBusiness.cadastrarAtendimento(personal, locaisAtendimento);
//			retorno = new RetornoCadastroRest(RetornoRestEnum.SUCESSO);
//		} catch (BusinessException e) {
//			LOGGER.warn("Cadastro não concluído", e);
//			retorno = new RetornoCadastroRest(RetornoRestEnum.ERRO_NEGOCIO,
//					MessageUtils.getErros(e.getListaValidacoes()));
//		} catch (Exception e) {
//			LOGGER.error("Houve um erro no servico CADASTRO DE ATENDIMENTO", e);
//		} finally {
//			LOGGER.info("FIM DO SERVICO CADASTRO DE PERSONAL");
//		}
//		return retorno;
//	}

}
