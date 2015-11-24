package com.findpersonal.findpersonalws.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.findpersonal.findpersonalws.rest.dto.AlunoJSON;
import com.findpersonal.findpersonalws.rest.dto.CadastroAlunoJSON;
import com.findpersonal.findpersonalws.rest.dto.EnvioAtualizacaoAlunoJSON;
import com.findpersonal.findpersonalws.rest.dto.RetornoCadastroJSON;
import com.findpersonal.findpersonalws.rest.dto.RetornoListaJSON;
import com.findpersonal.findpersonalws.rest.dto.RetornoJSON;
import com.findpersonal.findpersonalws.rest.dto.RetornoJSON.RetornoRestEnum;
import com.findpersonal.findpersonalws.util.ConverterUtils;

@RestController
@RequestMapping(value = "/aluno")
public class AlunoRestService {

	private static final Logger LOGGER = Logger.getLogger(AlunoRestService.class);

	@Autowired
	private GerenciadorAlunoBusiness gerenciadorAlunoBusiness;

	//TESTE COMMIT
	
	@RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
	public RetornoJSON buscarAlunoPorCodigo(@PathVariable Integer codigo) {
		LOGGER.info("INICIO DO SERVICO BUSCAR ALUNO POR CODIGO");
		RetornoListaJSON<AlunoJSON> retornoLista = null;
		Aluno aluno = null;
		try {
			aluno = gerenciadorAlunoBusiness.buscarAlunoPorCodigo(codigo);
			retornoLista = new RetornoListaJSON<AlunoJSON>(RetornoRestEnum.SUCESSO);
			retornoLista.adicionarNaLista(ConverterUtils.convertToAlunoRest(aluno));
		} catch (Exception e) {
			LOGGER.error("Houve um erro no servico BUSCAR ALUNO POR CODIGO", e);
		} finally {
			LOGGER.info("FIM DO SERVICO BUSCAR ALUNO POR CODIGO");
		}
		return retornoLista;
	}

	@RequestMapping(value = "/todos", method = RequestMethod.POST)
	public RetornoJSON buscarAlunos() {
		RetornoListaJSON<AlunoJSON> retornoLista = null;
		LOGGER.info("INICIO DO SERVICO BUSCAR TODOS ALUNOS");
		try {
			List<Aluno> lista = gerenciadorAlunoBusiness.buscarAlunos();
			retornoLista = new RetornoListaJSON<AlunoJSON>(RetornoRestEnum.SUCESSO);
			List<AlunoJSON> alunosRest = new ArrayList<AlunoJSON>();
			lista.forEach(a -> alunosRest.add(ConverterUtils.convertToAlunoRest(a)));
			retornoLista.adicionarNaLista(alunosRest);
		} catch (Exception e) {
			LOGGER.error("Houve um erro no servico BUSCAR ALUNO POR CODIGO", e);
			retornoLista = new RetornoListaJSON<AlunoJSON>(RetornoRestEnum.SISTEMA_INDISPONIVEL);
		} finally {
			LOGGER.info("INICIO DO SERVICO BUSCAR TODOS ALUNOS");
		}
		return retornoLista;
	}

	@RequestMapping(value = "/cadastro/atualizar", method = RequestMethod.POST)
	public RetornoJSON atualizar(@Validated @RequestBody EnvioAtualizacaoAlunoJSON atulizacaoAlunoRest) {
		LOGGER.info("INICIO DO SERVICO ATUALIZAR ALUNO");
		RetornoCadastroJSON retornoCadastroRest = null;
		try {
			Integer codigoAluno = gerenciadorAlunoBusiness.atualizarAluno(atulizacaoAlunoRest);
			retornoCadastroRest = new RetornoCadastroJSON(RetornoRestEnum.SUCESSO);
			retornoCadastroRest.setCodigoCadastro(codigoAluno);
		} catch (BusinessException e) {
			LOGGER.warn("ATUALIZAR não concluído: \n" + e.getStringErrors(), e);
			retornoCadastroRest = new RetornoCadastroJSON(RetornoRestEnum.ERRO_NEGOCIO,
					MessageUtils.getErros(e.getListaValidacoes()));
		} catch (Exception e) {
			LOGGER.error("Houve um erro no servico ATUALIZAR ALUNO", e);
			new RetornoCadastroJSON(RetornoRestEnum.SISTEMA_INDISPONIVEL);
		} finally {
			LOGGER.info("FIM DO SERVICO ATUALIZAR ALUNO");
		}
		return retornoCadastroRest;
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public RetornoJSON cadastrar(@Validated @RequestBody CadastroAlunoJSON cadastroAlunoRest) {
		LOGGER.info("INICIO DO SERVICO CADASTRO DE ALUNO");
		RetornoCadastroJSON retornoCadastroRest;
		try {
			Integer codigoAluno = gerenciadorAlunoBusiness.cadastrarAluno(cadastroAlunoRest);
			retornoCadastroRest = new RetornoCadastroJSON(RetornoRestEnum.SUCESSO);
			retornoCadastroRest.setCodigoCadastro(codigoAluno);
		} catch (BusinessException e) {
			LOGGER.warn("Cadastro não concluído", e);
			retornoCadastroRest = new RetornoCadastroJSON(RetornoRestEnum.ERRO_NEGOCIO,
					MessageUtils.getErros(e.getListaValidacoes()));
		} catch (Exception e) {
			LOGGER.error("Houve um erro no servico CADASTRO DE ALUNO", e);
			retornoCadastroRest = new RetornoCadastroJSON(RetornoRestEnum.SISTEMA_INDISPONIVEL);
		} finally {
			LOGGER.info("FIM DO SERVICO CADASTRO DE ALUNO");
		}
		return retornoCadastroRest;
	}

}
