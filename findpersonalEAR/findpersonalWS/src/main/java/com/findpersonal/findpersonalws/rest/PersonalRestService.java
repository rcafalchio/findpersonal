package com.findpersonal.findpersonalws.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.findpersonal.findpersonaljpa.entity.LocalAtendimento;
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
	RetornoCadastroRest cadastrar(@RequestBody Personal personal) {
		LOGGER.info("INICIO DO SERVICO CADASTRO DE PERSONAL");
		RetornoCadastroRest retorno = null;
		try {
			gerenciadorPersonalBusiness.cadastrarPersonal(personal);
			retorno = new RetornoCadastroRest(RetornoRestEnum.SUCESSO);
		} catch (BusinessException e) {
			LOGGER.warn("Cadastro não concluído", e);
			retorno = new RetornoCadastroRest(RetornoRestEnum.ERRO_NEGOCIO, MessageUtils.getErros(e.getListaValidacoes()));
		} catch (Exception e) {
			LOGGER.error("Houve um erro no servico CADASTRO DE PERSONAL", e);
		} finally {
			LOGGER.info("FIM DO SERVICO CADASTRO DE PERSONAL");
		}
		return retorno;
	}

	@RequestMapping(value = "/Cadastro/Atendimento", method = RequestMethod.POST)
	RetornoCadastroRest cadastrarAtendimento(@RequestBody Personal personal,
			@RequestBody List<LocalAtendimento> locaisAtendimento) {
		LOGGER.info("INICIO DO SERVICO CADASTRO DE ATENDIMENTO");
		RetornoCadastroRest retorno = null;
		try {
			gerenciadorPersonalBusiness.cadastrarAtendimento(personal, locaisAtendimento);
			retorno = new RetornoCadastroRest(RetornoRestEnum.SUCESSO);
		} catch (BusinessException e) {
			LOGGER.warn("Cadastro não concluído", e);
			retorno = new RetornoCadastroRest(RetornoRestEnum.ERRO_NEGOCIO, MessageUtils.getErros(e.getListaValidacoes()));
		} catch (Exception e) {
			LOGGER.error("Houve um erro no servico CADASTRO DE ATENDIMENTO", e);
		} finally {
			LOGGER.info("FIM DO SERVICO CADASTRO DE PERSONAL");
		}
		return retorno;
	}

}
