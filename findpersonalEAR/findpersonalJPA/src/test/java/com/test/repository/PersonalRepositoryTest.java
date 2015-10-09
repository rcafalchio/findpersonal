package com.test.repository;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;
import com.test.config.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class PersonalRepositoryTest {

	private static final Logger LOGGER = LogManager.getLogger(PersonalRepositoryTest.class);

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Test
	public void cadastrarUsuario() throws Exception {
		LOGGER.info("TESTE INICIO JPA USUARIO");
		usuarioRepository.findAll();
		LOGGER.info("TESTE FIM JPA USUARIO");
	}
}
