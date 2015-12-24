package com.findpersonal.findpersonalws.test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Test;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.findpersonal.findpersonalws.rest.dto.CadastroAlunoJSON;

/**
 * @author Ricardo Cafalchio
 */
public class AlunoConsultaRestTest extends RestTest {

	@After
	public void deleteOutputFile() {
		System.out.println("DELETANDO...");
		repository.deleteAll();
	}

	@Test
	public void buscarAlunosAcesoNegado() throws Exception {
		mvc.perform(post("/aluno/todos")).andExpect(status().is(401));
	}

	@Test
	public void buscarAlunosAutorizado() throws Exception {
		mvc.perform(post("/aluno/todos").header("Authorization", "Bearer " + accessToken)).andExpect(status().isOk());
	}

	@Test
	public void buscarAlunoAutorizado() throws Exception {
		mvc.perform(post("/aluno/1").header("Authorization", "Bearer " + accessToken)).andExpect(status().isOk());
	}

	@Test
	public void buscarAlunoAcesoNegado() throws Exception {
		mvc.perform(post("/aluno/1")).andExpect(status().is(401));
	}

	@Test
	public void buscarAlunos() throws Exception {

		// Efetua o cadastro de 2 alunos

		// ALUNO A
		final CadastroAlunoJSON cadastroAlunoRestA = new CadastroAlunoJSON();
		cadastroAlunoRestA.setApplicationVersion(1.00);
		cadastroAlunoRestA.setNome("A");
		cadastroAlunoRestA.setEmail("A@mail.com.br");
		cadastroAlunoRestA.setSenha("123");
		cadastroAlunoRestA.setCpf(99999999999L);
		MockHttpServletRequestBuilder builderA = post("/aluno/cadastro").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(cadastroAlunoRestA));
		mvc.perform(builderA).andExpect(status().isOk());
		mvc.perform(post("/aluno/1").header("Authorization", "Bearer " + accessToken)).andExpect(status().isOk()).andExpect(jsonPath("$.CR", is(equalTo(0))));

		// ALUNO B
		final CadastroAlunoJSON cadastroAlunoRestB = new CadastroAlunoJSON();
		cadastroAlunoRestB.setApplicationVersion(1.00);
		cadastroAlunoRestB.setNome("B");
		cadastroAlunoRestB.setEmail("B@mail.com.br");
		cadastroAlunoRestB.setSenha("123");
		cadastroAlunoRestB.setCpf(99999999999L);
		MockHttpServletRequestBuilder builderB = post("/aluno/cadastro").contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(cadastroAlunoRestB));
		mvc.perform(builderB).andExpect(status().isOk()).andExpect(jsonPath("$.CR", is(equalTo(0))));

		mvc.perform(post("/aluno/todos").header("Authorization", "Bearer " + accessToken)).andExpect(status().isOk())
				.andExpect(jsonPath("$.lista.length()", is(equalTo(3))));
	}

}
