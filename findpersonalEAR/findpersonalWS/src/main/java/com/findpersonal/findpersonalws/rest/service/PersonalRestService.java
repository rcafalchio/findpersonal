package com.findpersonal.findpersonalws.rest.service;

import java.util.List;

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
import com.findpersonal.findpersonalws.rest.dto.CadastroPersonalJSON;
import com.findpersonal.findpersonalws.rest.dto.EnvioAtualizacaoPersonalJSON;
import com.findpersonal.findpersonalws.rest.dto.FiltroPersonalJSON;
import com.findpersonal.findpersonalws.rest.dto.PersonalJSON;
import com.findpersonal.findpersonalws.rest.dto.RetornoCadastroJSON;
import com.findpersonal.findpersonalws.rest.dto.RetornoJSON;
import com.findpersonal.findpersonalws.rest.dto.RetornoJSON.RetornoRestEnum;
import com.findpersonal.findpersonalws.rest.dto.RetornoListaJSON;
import com.findpersonal.findpersonalws.util.ConverterUtils;

@RestController
@RequestMapping(value = "/personal")
@Transactional
public class PersonalRestService {

	private static final Logger LOGGER = Logger.getLogger(PersonalRestService.class);

	@Autowired
	private GerenciadorPersonalBusiness gerenciadorPersonalBusiness;

	@RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
	RetornoJSON buscarPersonalPorCodigo(@PathVariable Integer codigo) {
		LOGGER.info("INICIO DO SERVICO BUSCAR PERSONAL POR CODIGO");
		RetornoListaJSON<PersonalJSON> retornoLista = null;
		Personal personal = null;
		try {
			personal = gerenciadorPersonalBusiness.buscarPersonalPorCodigo(codigo);
			retornoLista = new RetornoListaJSON<PersonalJSON>(RetornoRestEnum.SUCESSO);
			retornoLista.adicionarNaLista(ConverterUtils.convertToPersonalRest(personal));
		} catch (Exception e) {
			LOGGER.error("Houve um erro no servico BUSCAR PERSONAL POR CODIGO", e);
		} finally {
			LOGGER.info("FIM DO SERVICO BUSCAR PERSONAL POR CODIGO");
		}
		return retornoLista;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	RetornoJSON buscarPersonal(@Validated @RequestBody FiltroPersonalJSON filtroPersonalJSON) {
		LOGGER.info("INICIO DO SERVICO BUSCAR PERSONAL");
		RetornoListaJSON<PersonalJSON> retornoLista = null;
		List<Personal> listaPersonal = null;
		try {
			listaPersonal = gerenciadorPersonalBusiness.buscarPersonal(filtroPersonalJSON);
			final RetornoListaJSON<PersonalJSON> auxList = new RetornoListaJSON<PersonalJSON>(RetornoRestEnum.SUCESSO);
			listaPersonal.forEach(a -> auxList.getLista().add(ConverterUtils.convertToPersonalRest(a)));
			retornoLista = auxList;
		} catch (Exception e) {
			LOGGER.error("Houve um erro no servico BUSCAR PERSONAL", e);
		} finally {
			LOGGER.info("FIM DO SERVICO BUSCAR PERSONAL");
		}
		return retornoLista;
	}
	
	@RequestMapping(value = "/todos", method = RequestMethod.POST)
	RetornoJSON buscarPersonaisCodigo() {
		RetornoListaJSON<Personal> retornoLista = null;
		LOGGER.info("INICIO DO SERVICO BUSCAR TODOS PERSONAIS");
		try {
			List<Personal> lista = gerenciadorPersonalBusiness.buscarPersonais();
			retornoLista = new RetornoListaJSON<Personal>(RetornoRestEnum.SUCESSO);
			retornoLista.adicionarNaLista(lista);
		} catch (Exception e) {
			LOGGER.error("Houve um erro no servico BUSCAR ALUNO POR CODIGO", e);
			retornoLista = new RetornoListaJSON<Personal>(RetornoRestEnum.SISTEMA_INDISPONIVEL);
		} finally {
			LOGGER.info("FIM DO SERVICO BUSCAR TODOS PERSONAIS");
		}
		return retornoLista;
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	ResponseEntity<RetornoJSON> cadastrar(@Validated @RequestBody CadastroPersonalJSON cadastroPersonalRest) {
		LOGGER.info("INICIO DO SERVICO CADASTRO DE ALUNO");
		ResponseEntity<RetornoJSON> retorno = null;
		try {
			Integer codigoPersonal = gerenciadorPersonalBusiness.cadastrarPersonal(cadastroPersonalRest);
			RetornoCadastroJSON retornoCadastroRest = new RetornoCadastroJSON(RetornoRestEnum.SUCESSO);
			retornoCadastroRest.setCodigoCadastro(codigoPersonal);
			retorno = new ResponseEntity<RetornoJSON>(retornoCadastroRest, HttpStatus.OK);
		} catch (BusinessException e) {
			LOGGER.warn("Cadastro não concluído", e);
			retorno = new ResponseEntity<RetornoJSON>(new RetornoCadastroJSON(RetornoRestEnum.ERRO_NEGOCIO,
					MessageUtils.getErros(e.getListaValidacoes())), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Houve um erro no servico CADASTRO DE ALUNO", e);
			retorno = new ResponseEntity<RetornoJSON>(new RetornoCadastroJSON(RetornoRestEnum.SISTEMA_INDISPONIVEL),
					HttpStatus.OK);
		} finally {
			LOGGER.info("FIM DO SERVICO CADASTRO DE ALUNO");
		}
		return retorno;
	}

	@RequestMapping(value = "/cadastro/atualizar", method = RequestMethod.POST)
	ResponseEntity<RetornoJSON> atualizar(@Validated @RequestBody EnvioAtualizacaoPersonalJSON atualizacaoPersonalRest) {
		LOGGER.info("INICIO DO SERVICO ATUALIZAR CADASTRO DE PERSONAL");
		ResponseEntity<RetornoJSON> retorno = null;
		try {
			Integer codigoAluno = gerenciadorPersonalBusiness.atualizarPersonal(atualizacaoPersonalRest);
			RetornoCadastroJSON retornoCadastroRest = new RetornoCadastroJSON(RetornoRestEnum.SUCESSO);
			retornoCadastroRest.setCodigoCadastro(codigoAluno);
			retorno = new ResponseEntity<RetornoJSON>(retornoCadastroRest, HttpStatus.OK);
		} catch (BusinessException e) {
			LOGGER.warn("Cadastro não concluído", e);
			retorno = new ResponseEntity<RetornoJSON>(new RetornoCadastroJSON(RetornoRestEnum.ERRO_NEGOCIO,
					MessageUtils.getErros(e.getListaValidacoes())), HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Houve um erro no servico ATUALIZAR CADASTRO DE PERSONAL", e);
			retorno = new ResponseEntity<RetornoJSON>(new RetornoCadastroJSON(RetornoRestEnum.SISTEMA_INDISPONIVEL),
					HttpStatus.OK);
		} finally {
			LOGGER.info("FIM DO SERVICO ATUALIZAR CADASTRO DE PERSONAL");
		}
		return retorno;
	}
	
}
