package com.findpersonal.findpersonalws.rest;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

	@RequestMapping(value = "/Cadastro/Atualizar", method = RequestMethod.POST)
	ResponseEntity<RetornoRest> atualizar(@Validated @RequestBody EnvioAtulizacaoAlunoRest atulizacaoAlunoRest) {
		LOGGER.info("INICIO DO SERVICO CADASTRO DE ALUNO");
		ResponseEntity<RetornoRest> retorno = null;
		try {
			Integer codigoAluno = gerenciadorAlunoBusiness.atualizarAluno(atulizacaoAlunoRest);
			RetornoCadastroRest retornoCadastroRest = new RetornoCadastroRest(RetornoRestEnum.SUCESSO);
			retornoCadastroRest.setCodigoCadastro(codigoAluno);
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
	
	@RequestMapping(value = "/Cadastro", method = RequestMethod.POST)
	ResponseEntity<RetornoRest> cadastrar(@Validated @RequestBody CadastroAlunoRest cadastroAlunoRest) {
		LOGGER.info("INICIO DO SERVICO CADASTRO DE ALUNO");
		ResponseEntity<RetornoRest> retorno = null;
		try {
			Integer codigoAluno = gerenciadorAlunoBusiness.cadastrarAluno(cadastroAlunoRest);
			RetornoCadastroRest retornoCadastroRest = new RetornoCadastroRest(RetornoRestEnum.SUCESSO);
			retornoCadastroRest.setCodigoCadastro(codigoAluno);
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
	
	@RequestMapping(value = "/Cadastro/Atendimento", method = RequestMethod.POST)
	ResponseEntity<RetornoRest> cadastrarAtendimento(@Validated @RequestBody CadastroAtendimenetoRest cadastroAtendimenetoRest) {
		LOGGER.info("INICIO DO SERVICO CADASTRO DE ATENDIMENTO DO ALUNO");
		ResponseEntity<RetornoRest> retorno = null;
		return retorno;
	}


}
