package com.findpersonal.findpersonalws.rest;

import java.util.List;

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
import com.findpersonal.findpersonalws.rest.RetornoRest.RetornoRestEnum;

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

	@RequestMapping(value = "/", method = RequestMethod.POST)
	RetornoRest buscarAlunos() {
		RetornoRest retorno = null;
		LOGGER.info("INICIO DO SERVICO BUSCAR TODOS ALUNOS");
		try {
			List<Aluno> lista = gerenciadorAlunoBusiness.buscarAlunos();
			RetornoListaRest<Aluno> retornoLista = new RetornoListaRest<Aluno>(RetornoRestEnum.SUCESSO);
			retornoLista.adicionarNaLista(lista);
			retorno = retornoLista;
		} catch (Exception e) {
			LOGGER.error("Houve um erro no servico BUSCAR ALUNO POR CODIGO", e);
			retorno = new RetornoCadastroRest(RetornoRestEnum.SISTEMA_INDISPONIVEL);
		} finally {
			LOGGER.info("INICIO DO SERVICO BUSCAR TODOS ALUNOS");
		}
		return retorno;
	}

	@RequestMapping(value = "/Cadastro", method = RequestMethod.POST)
	RetornoRest cadastrar(@RequestBody Aluno aluno) {
		LOGGER.info("INICIO DO SERVICO CADASTRO DE ALUNO");
		RetornoRest retorno = null;
		try {
			gerenciadorAlunoBusiness.cadastrarAluno(aluno);
			retorno = new RetornoCadastroRest(RetornoRestEnum.SUCESSO);
		} catch (BusinessException e) {
			LOGGER.warn("Cadastro não concluído", e);
			retorno = new RetornoCadastroRest(RetornoRestEnum.ERRO_NEGOCIO,
					MessageUtils.getErros(e.getListaValidacoes()));
		} catch (Exception e) {
			LOGGER.error("Houve um erro no servico CADASTRO DE ALUNO", e);
			retorno = new RetornoCadastroRest(RetornoRestEnum.SISTEMA_INDISPONIVEL);
		} finally {
			LOGGER.info("FIM DO SERVICO CADASTRO DE ALUNO");
		}
		return retorno;
	}

}
