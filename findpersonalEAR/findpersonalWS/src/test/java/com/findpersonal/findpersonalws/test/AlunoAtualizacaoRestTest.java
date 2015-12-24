package com.findpersonal.findpersonalws.test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.After;
import org.junit.Test;

import com.findpersonal.findpersonalws.rest.dto.EnvioAtualizacaoAlunoJSON;
import com.findpersonal.findpersonalws.rest.dto.RetornoCadastroJSON;

/**
 * @author Ricardo Cafalchio
 */
public class AlunoAtualizacaoRestTest extends RestTest {

	private static final String NOVO_NOME = "NEW";
	private static final String NOVO_EMAIL = "new@gmail.com";
	private static final Long NOVO_CPF = 99999999999L;
	private static final String NOVO_SEXO = "M";
	private static final Date NOVO_DATA_NASCIMENTO = new Date();

	@After
	public void deleteOutputFile() {
		System.out.println("DELETANDO...");
		repository.deleteAll();
	}

	@Test
	public void atualizarAluno() throws Exception {
		// REALIZA A ATUALIZACAO
		final EnvioAtualizacaoAlunoJSON atualizacaoAlunoRest = new EnvioAtualizacaoAlunoJSON();
		atualizacaoAlunoRest.setApplicationVersion(1.00);
		atualizacaoAlunoRest.setCodigo(1);
		atualizacaoAlunoRest.setNome(NOVO_NOME);
		atualizacaoAlunoRest.setEmail(NOVO_EMAIL);
		atualizacaoAlunoRest.setSiglaSexo(NOVO_SEXO);
		atualizacaoAlunoRest.setCpf(NOVO_CPF);
		atualizacaoAlunoRest.setDataNascimento(NOVO_DATA_NASCIMENTO);
		byte[] retorno = mvc
				.perform(post("/aluno/cadastro/atualizar").header("Authorization", "Bearer " + accessToken)
						.contentType(TestUtil.APPLICATION_JSON_UTF8)
						.content(TestUtil.convertObjectToJsonBytes(atualizacaoAlunoRest)))
				.andExpect(status().isOk()).andExpect(jsonPath("$.CR", is(equalTo(0)))).andReturn().getResponse()
				.getContentAsByteArray();
		RetornoCadastroJSON retornoCadastroRest = (RetornoCadastroJSON) TestUtil.convertJsonBytesToObject(retorno,
				RetornoCadastroJSON.class);
		// REALIZA A BUSCA PARA VERIFICAR A ATUALIZACAO
		mvc.perform(post("/aluno/" + retornoCadastroRest.getCodigoCadastro().toString()).header("Authorization",
				"Bearer " + accessToken)).andExpect(jsonPath("$.lista[0].NM", is(equalTo(NOVO_NOME))))
				.andExpect(jsonPath("$.lista[0].MAIL", is(equalTo(NOVO_EMAIL))))
				.andExpect(jsonPath("$.lista[0].SX", is(equalTo(NOVO_SEXO))))
				.andExpect(jsonPath("$.lista[0].CPF", is(equalTo(NOVO_CPF))))
				.andExpect(jsonPath("$.lista[0].DTN", is(equalTo(NOVO_DATA_NASCIMENTO.getTime()))));
	}

}
