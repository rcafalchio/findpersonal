package com.findpersonal.findpersonalws.rest.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.findpersonal.findpersonalws.business.GerenciadorAtendimentoBusiness;
import com.findpersonal.findpersonalws.rest.dto.CadastroLocalAtendimentoJSON;
import com.findpersonal.findpersonalws.rest.dto.RetornoCadastroJSON;
import com.findpersonal.findpersonalws.rest.dto.RetornoJSON;
import com.findpersonal.findpersonalws.rest.dto.RetornoJSON.RetornoRestEnum;

@RestController
@RequestMapping(value = "/Atendimento")
public class AtendimentoRestService {

	private static final Logger LOGGER = Logger.getLogger(AtendimentoRestService.class);
	
	@Autowired
	private GerenciadorAtendimentoBusiness gerenciadorAtendimentoBusiness;

//	@RequestMapping(value = "/Cadastro", method = RequestMethod.POST)
//	public RetornoJSON cadastrar(@Validated @RequestBody CadastroLocalAtendimentoJSON cadastroLocalAtendimentoRest) {
//		LOGGER.info("INICIO DO SERVICO CADASTRO DE ATENDIMENTO");
//		RetornoCadastroJSON retornoCadastroRest;
//		try {
//			Integer codigoAluno = gerenciadorAlunoBusiness.cadastrarAtendi(cadastroAlunoRest);
//			retornoCadastroRest = new RetornoCadastroJSON(RetornoRestEnum.SUCESSO);
////			retornoCadastroRest.setCodigoCadastro(codigoAluno);
////		} catch (BusinessException e) {
////			LOGGER.warn("Cadastro não concluído", e);
////			retornoCadastroRest = new RetornoCadastroRest(RetornoRestEnum.ERRO_NEGOCIO,
////					MessageUtils.getErros(e.getListaValidacoes()));
//		} catch (Exception e) {
//			LOGGER.error("Houve um erro no servico CADASTRO DE ATENDIMENTO", e);
//			retornoCadastroRest = new RetornoCadastroJSON(RetornoRestEnum.SISTEMA_INDISPONIVEL);
//		} finally {
//			LOGGER.info("FIM DO SERVICO CADASTRO DE ATENDIMENTO");
//		}
//		return retornoCadastroRest;
//	}

}
