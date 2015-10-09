package com.test.repository;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.findpersonal.findpersonaljpa.repository.EstadoRepository;
import com.test.config.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class EstadoRepositoryTest {

	private static final Logger LOGGER = LogManager.getLogger(EstadoRepositoryTest.class);

	@Autowired
	private EstadoRepository estadoRepository;

	@Test
	public void cadastrarEstado() throws Exception {
		LOGGER.info("TESTE INICIO JPA ESTADO");
		estadoRepository.findAll();
		LOGGER.info("TESTE FIM JPA ESTADO");
	}

}
