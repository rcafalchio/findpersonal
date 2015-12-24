/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.findpersonal.findpersonalws.test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Base64Utils;
import org.springframework.web.context.WebApplicationContext;

import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;
import com.findpersonal.findpersonalws.rest.dto.CadastroAlunoJSON;
import com.findpersonal.findpersonalws.rest.service.AlunoRestService;
import com.findpersonal.findpersonalws.test.config.Application;

/**
 * @author Ricardo Cafalchio
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = Application.class)
public abstract class RestTest {
	
	@InjectMocks
	AlunoRestService alunoRestService;

	@Autowired
	UsuarioRepository repository;

	@Autowired
	protected WebApplicationContext context;

	@Autowired
	protected FilterChainProxy springSecurityFilterChain;

	protected MockMvc mvc;

	protected String accessToken;

	private static final String TOKEN_USER_NAME = "user_token@gmail.com";
	private static final String TOKEN_PASSWORD = "123";

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.webAppContextSetup(context).addFilter(springSecurityFilterChain).build();
		cadastrarAlunoToken();
		accessToken = this.getAccessToken(TOKEN_USER_NAME, TOKEN_PASSWORD);
	}


	
	private void cadastrarAlunoToken() throws Exception {
		// @formatter:off
		// mvc.perform(post("/Aluno/Cadastro").requestAttr("MAIL", "teste14@gmail.com").requestAttr("PW", "123")
		// .requestAttr("NM", "Well").requestAttr("APV", 1.00).accept(MediaType.APPLICATION_JSON))
		// .andExpect(status().isOk());
		final CadastroAlunoJSON cadastroAlunoRest = new CadastroAlunoJSON();
		cadastroAlunoRest.setApplicationVersion(1.00);
		cadastroAlunoRest.setEmail(TOKEN_USER_NAME);
		cadastroAlunoRest.setSenha(TOKEN_PASSWORD);
		cadastroAlunoRest.setNome("USER TESTE");
		cadastroAlunoRest.setCpf(9999999999L);
		TestUtil.convertObjectToJsonBytes(cadastroAlunoRest);
		MockHttpServletRequestBuilder builder = post("/aluno/cadastro").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(cadastroAlunoRest));
		System.out.println("#########################################################");
		String retorno = mvc.perform(builder).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		System.out.println("Cadastrou o código " + retorno);
		System.out.println("#########################################################");
		// @formatter:on
	}

	private String getAccessToken(String username, String password) throws Exception {
		String authorization = "Basic " + new String(Base64Utils.encode("clientapp:123456".getBytes()));
		String contentType = MediaType.APPLICATION_JSON + ";charset=UTF-8";

		// @formatter:off
		String content = mvc
				.perform(post("/oauth/token").header("Authorization", authorization)
						.contentType(MediaType.APPLICATION_FORM_URLENCODED).param("username", username)
						.param("password", password).param("grant_type", "password").param("scope", "read write")
						.param("client_id", "clientapp").param("client_secret", "123456"))
				.andExpect(status().isOk()).andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.access_token", is(notNullValue())))
				.andExpect(jsonPath("$.token_type", is(equalTo("bearer"))))
				.andExpect(jsonPath("$.refresh_token", is(notNullValue())))
				.andExpect(jsonPath("$.expires_in", is(greaterThan(4000))))
				.andExpect(jsonPath("$.scope", is(equalTo("read write")))).andReturn().getResponse()
				.getContentAsString();

		// @formatter:on
		String token = content.substring(17, 53);
		System.out.println("Funcionou - TOKEN => " + token);
		return token;
	}

}
