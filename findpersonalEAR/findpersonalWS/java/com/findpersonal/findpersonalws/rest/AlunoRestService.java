package com.findpersonal.findpersonalws.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.findpersonal.findpersonaljpa.entity.Aluno;
import com.findpersonal.findpersonalutil.util.MessageUtils;
import com.findpersonal.findpersonalws.business.GerenciadorAlunoBusiness;
import com.findpersonal.findpersonalws.exception.BusinessException;

@RestController
@RequestMapping(value = "/Aluno")
public class AlunoRestService {

	private static final Logger LOGGER = Logger.getLogger(AlunoRestService.class);

	@Autowired
	private GerenciadorAlunoBusiness gerenciadorAlunoBusiness;

	@RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
	Aluno buscarAlunoPorCodigo(@PathVariable Integer codigo) {
		LOGGER.info("INICIO DO SERVICO BUSCAR ALUNO POR CODIGO");
		Aluno aluno = null;
		try {
			aluno = gerenciadorAlunoBusiness.buscarAlunoPorCodigo(codigo);
		} catch (Exception e) {
			LOGGER.error("Houve um erro no servico BUSCAR ALUNO POR CODIGO", e);
		} finally {
			LOGGER.info("FIM DO SERVICO BUSCAR ALUNO POR CODIGO");
		}
		return aluno;
	}

	@RequestMapping(value = "/Cadastro", method = RequestMethod.POST)
	RetornoCadastroRest cadastrar(@RequestBody Aluno aluno) {
		LOGGER.info("INICIO DO SERVICO CADASTRO DE ALUNO");
		RetornoCadastroRest retorno = null;
		try {
			gerenciadorAlunoBusiness.cadastrarAluno(aluno);
			retorno = new RetornoCadastroRest(Boolean.TRUE);
		} catch (BusinessException e) {
			LOGGER.warn("Cadastro não concluído", e);
			retorno = new RetornoCadastroRest(Boolean.FALSE, MessageUtils.getErros(e.getListaValidacoes()));
		} catch (Exception e) {
			LOGGER.error("Houve um erro no servico CADASTRO DE ALUNO", e);
		} finally {
			LOGGER.info("FIM DO SERVICO CADASTRO DE ALUNO");
		}
		return retorno;
	}

}
