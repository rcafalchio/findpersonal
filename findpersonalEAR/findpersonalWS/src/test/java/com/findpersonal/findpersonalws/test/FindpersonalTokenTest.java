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
import org.junit.Test;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Base64Utils;
import org.springframework.web.context.WebApplicationContext;

import com.findpersonal.findpersonalws.rest.PersonalRestService;
import com.findpersonal.findpersonalws.test.config.Application;

/**
 * @author Ricardo Cafalchio
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = Application.class)
public class FindpersonalTokenTest {

	@Autowired
	WebApplicationContext context;

	@Autowired
	private FilterChainProxy springSecurityFilterChain;

	@InjectMocks
	PersonalRestService controller;

	private MockMvc mvc;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.webAppContextSetup(context).addFilter(springSecurityFilterChain).build();
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

	@Test
	public void greetingUnauthorized() throws Exception {
		// @formatter:off
		mvc.perform(post("/Personal/Cadastro").accept(MediaType.APPLICATION_JSON)).andExpect(status().isUnauthorized())
				.andExpect(jsonPath("$.error", is("unauthorized")));
		// @formatter:on
	}

	@Test
	public void greetingAuthorized() throws Exception {
		String accessToken = getAccessToken("ricardo@gmail.com", "123");

		// @formatter:off
		mvc.perform(post("/Personal/1").header("Authorization", "Bearer " + accessToken)).andExpect(status().isOk());
		// @formatter:on

	}

	// @Test
	// public void usersEndpointAuthorized() throws Exception {
	// // @formatter:off
	// mvc.perform(get("/users").header("Authorization", "Bearer " + getAccessToken("roy", "spring")))
	// .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3)));
	// // @formatter:on
	// }

	@Test
	public void usersEndpointAccessDenied() throws Exception {
		// @formatter:off
		mvc.perform(post("/Aluno/").header("Authorization", "Bearer " + getAccessToken("ricardo@gmail.com", "123")))
				.andExpect(status().is(403));
		// @formatter:on
	}

}
