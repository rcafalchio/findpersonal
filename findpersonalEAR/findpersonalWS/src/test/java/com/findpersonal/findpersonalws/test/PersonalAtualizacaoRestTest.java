package com.findpersonal.findpersonalws.test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.After;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.findpersonal.findpersonalws.rest.dto.CadastroPersonalJSON;
import com.findpersonal.findpersonalws.rest.dto.EnvioAtualizacaoPersonalJSON;
import com.findpersonal.findpersonalws.rest.dto.RetornoCadastroJSON;

/**
 * @author Ricardo Cafalchio
 */
public class PersonalAtualizacaoRestTest extends RestTest {

	private static final String ANTIGO_NOME = "OLD";
	private static final String ANTIGO_EMAIL = "old@gmail.com";
	private static final String ANTIGO_SENHA = "pass";
	private static final Long ANTIGO_CPF = 99999999999L;
	private static final String ANTIGO_CREF = "CREF_ID";
	
	private static final String NOVO_NOME = "NEW";
	private static final String NOVO_CREF = "NEW_CREF_ID";
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
	public void atualizarPersonal() throws Exception {
		
		//REALIZA O CADASTRO
		final CadastroPersonalJSON cadastroPersonalRest = new CadastroPersonalJSON();
		cadastroPersonalRest.setApplicationVersion(1.00);
		cadastroPersonalRest.setNome(ANTIGO_NOME);
		cadastroPersonalRest.setEmail(ANTIGO_EMAIL);
		cadastroPersonalRest.setSenha(ANTIGO_SENHA);
		cadastroPersonalRest.setCpf(ANTIGO_CPF);
		cadastroPersonalRest.setCref(ANTIGO_CREF);
		MockHttpServletRequestBuilder builder = post("/personal/cadastro").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(cadastroPersonalRest));
		byte[] retorno = mvc.perform(builder).andExpect(status().isOk()).andExpect(jsonPath("$.CR", is(equalTo(0))))
				.andReturn().getResponse().getContentAsByteArray();
		RetornoCadastroJSON retornoCadastroRest = (RetornoCadastroJSON) TestUtil
				.convertJsonBytesToObject(retorno, RetornoCadastroJSON.class);
		
		// REALIZA A ATUALIZACAO
		final EnvioAtualizacaoPersonalJSON atualizacaoPersonalRest = new EnvioAtualizacaoPersonalJSON();
		atualizacaoPersonalRest.setApplicationVersion(1.00);
		atualizacaoPersonalRest.setCodigo(retornoCadastroRest.getCodigoCadastro());
		atualizacaoPersonalRest.setNome(NOVO_NOME);
		atualizacaoPersonalRest.setEmail(NOVO_EMAIL);
		atualizacaoPersonalRest.setSiglaSexo(NOVO_SEXO);
		atualizacaoPersonalRest.setCpf(NOVO_CPF);
		atualizacaoPersonalRest.setCref(NOVO_CREF);
		atualizacaoPersonalRest.setDataNascimento(NOVO_DATA_NASCIMENTO);
		retorno = mvc
				.perform(post("/personal/cadastro/atualizar").header("Authorization", "Bearer " + accessToken)
						.contentType(TestUtil.APPLICATION_JSON_UTF8)
						.content(TestUtil.convertObjectToJsonBytes(atualizacaoPersonalRest)))
				.andExpect(status().isOk()).andExpect(jsonPath("$.CR", is(equalTo(0)))).andReturn().getResponse()
				.getContentAsByteArray();
		RetornoCadastroJSON retornoAtualizacaoRest = (RetornoCadastroJSON) TestUtil.convertJsonBytesToObject(retorno,
				RetornoCadastroJSON.class);
		// REALIZA A BUSCA PARA VERIFICAR A ATUALIZACAO
		mvc.perform(post("/personal/" + retornoAtualizacaoRest.getCodigoCadastro().toString()).header("Authorization",
				"Bearer " + accessToken)).andExpect(jsonPath("$.lista[0].NM", is(equalTo(NOVO_NOME))))
				.andExpect(jsonPath("$.lista[0].MAIL", is(equalTo(NOVO_EMAIL))))
				.andExpect(jsonPath("$.lista[0].SX", is(equalTo(NOVO_SEXO))))
				.andExpect(jsonPath("$.lista[0].CPF", is(equalTo(NOVO_CPF))))
				.andExpect(jsonPath("$.lista[0].CREF", is(equalTo(NOVO_CREF))))
				.andExpect(jsonPath("$.lista[0].DTN", is(equalTo(NOVO_DATA_NASCIMENTO.getTime()))));
	}

}
