package com.findpersonal.findpersonalws.test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.findpersonal.findpersonalws.rest.dto.CadastroFacebookJSON;
import com.findpersonal.findpersonalws.rest.dto.CadastroPersonalJSON;
import com.findpersonal.findpersonalws.rest.dto.RetornoCadastroJSON;

/**
 * @author Ricardo Cafalchio
 */
public class PersonalCadastroRestTest extends RestTest {

	private static final String NOVO_NOME = "NEW";
	private static final String NOVO_EMAIL = "new@gmail.com";
	private static final String NOVO_SENHA = "pass";
	private static final Long NOVO_CPF = 99999999999L;
	private static final String NOVO_CREF = "CREF_ID";
	private static final String NOVO_CODIGO_FACEBOOK = "F2125F";
	private static final String NOVO_NICK_FACEBOOK = "nick";
	private static final String NOVO_NOME_FACEBOOK = "NEW_FB";
	private static final String NOVO_LOCALE_FACEBOOK = "pt_Br";
	private static final String NOVO_PAGINA_FACEBOOK = "paginafacebook.com.br";
	private static final String NOVO_SOBRENOME_FACEBOOK = "NEW_FB_L";

	@After
	public void deleteOutputFile() {
		System.out.println("DELETANDO...");
		repository.deleteAll();
	}

	@Test
	public void cadastroPersonal() throws Exception {
		// Efetua o cadastro
		final CadastroPersonalJSON cadastroPersonalRest = new CadastroPersonalJSON();
		cadastroPersonalRest.setApplicationVersion(1.00);
		cadastroPersonalRest.setNome(NOVO_NOME);
		cadastroPersonalRest.setEmail(NOVO_EMAIL);
		cadastroPersonalRest.setSenha(NOVO_SENHA);
		cadastroPersonalRest.setCpf(NOVO_CPF);
		cadastroPersonalRest.setCref(NOVO_CREF);
		final CadastroFacebookJSON cadastroFacebookRest = new CadastroFacebookJSON();
		cadastroFacebookRest.setCodigoFacebook(NOVO_CODIGO_FACEBOOK);
		cadastroFacebookRest.setApelido(NOVO_NICK_FACEBOOK);
		cadastroFacebookRest.setNome(NOVO_NOME_FACEBOOK);
		cadastroFacebookRest.setLocale(NOVO_LOCALE_FACEBOOK);
		cadastroFacebookRest.setPaginaFacebook(NOVO_PAGINA_FACEBOOK);
		cadastroFacebookRest.setSobrenome(NOVO_SOBRENOME_FACEBOOK);
		cadastroPersonalRest.setCadastroFacebookRest(cadastroFacebookRest);
		MockHttpServletRequestBuilder builder = post("/personal/cadastro").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(cadastroPersonalRest));
		byte[] retorno = mvc.perform(builder).andExpect(status().isOk()).andExpect(jsonPath("$.CR", is(equalTo(0))))
				.andReturn().getResponse().getContentAsByteArray();
		RetornoCadastroJSON retornoCadastroRest = (RetornoCadastroJSON) TestUtil
				.convertJsonBytesToObject(retorno, RetornoCadastroJSON.class);
		// Valida o cadastro
		mvc.perform(post("/personal/" + retornoCadastroRest.getCodigoCadastro().toString()).header("Authorization",
				"Bearer " + accessToken))
				.andExpect(jsonPath("$.lista[0].NM", is(equalTo(NOVO_NOME))))
				.andExpect(jsonPath("$.lista[0].MAIL", is(equalTo(NOVO_EMAIL))))
				.andExpect(jsonPath("$.lista[0].CPF", is(equalTo(NOVO_CPF))))
				.andExpect(jsonPath("$.lista[0].CREF", is(equalTo(NOVO_CREF))))
				.andExpect(jsonPath("$.lista[0].CFB.CF", is(equalTo(NOVO_CODIGO_FACEBOOK))))
				.andExpect(jsonPath("$.lista[0].CFB.NICK", is(equalTo(NOVO_NICK_FACEBOOK))))
				.andExpect(jsonPath("$.lista[0].CFB.PGFB", is(equalTo(NOVO_PAGINA_FACEBOOK))))
				.andExpect(jsonPath("$.lista[0].CFB.FN", is(equalTo(NOVO_NOME_FACEBOOK))))
				.andExpect(jsonPath("$.lista[0].CFB.LN", is(equalTo(NOVO_SOBRENOME_FACEBOOK))))
				.andExpect(jsonPath("$.lista[0].CFB.LOC", is(equalTo(NOVO_LOCALE_FACEBOOK))));

	}

}
