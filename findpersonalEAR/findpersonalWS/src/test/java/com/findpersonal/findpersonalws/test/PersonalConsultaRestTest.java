package com.findpersonal.findpersonalws.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Test;

/**
 * @author Ricardo Cafalchio
 */
public class PersonalConsultaRestTest extends RestTest {

	@After
	public void deleteOutputFile() {
		System.out.println("DELETANDO...");
		repository.deleteAll();
	}

	@Test
	public void buscarPersonaisAcesoNegado() throws Exception {
		mvc.perform(post("/personal/todos")).andExpect(status().is(401));
	}

	@Test
	public void buscarPersonaisAutorizado() throws Exception {
		mvc.perform(post("/personal/todos").header("Authorization", "Bearer " + accessToken)).andExpect(status().isOk());
	}

	@Test
	public void buscarPersonalAcesoNegado() throws Exception {
		mvc.perform(post("/personal/1")).andExpect(status().is(401));
	}

	@Test
	public void buscarPersonalAutorizado() throws Exception {
		mvc.perform(post("/personal/1").header("Authorization", "Bearer " + accessToken)).andExpect(status().isOk());
	}

}
