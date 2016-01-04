package com.test.repository;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.findpersonal.findpersonaljpa.entity.FaixaAulaPersonal;
import com.findpersonal.findpersonaljpa.repository.FaixaAulaPersonalRepository;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;
import com.test.config.RepositoryConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RepositoryConfiguration.class)
public class FaixaRepositoryTest {

	private static final Logger LOGGER = LogManager.getLogger(FaixaRepositoryTest.class);

	@Autowired
	private FaixaAulaPersonalRepository faixaAulaPersonalRepository;

	@Test
	public void buscarPersonaisPorfaixa() throws Exception {
		LOGGER.info("TESTE INICIO JPA faixaRepository");
		final FaixaAulaPersonal faixaAulaPersonal = faixaAulaPersonalRepository.findOne(0);
		LOGGER.info("TESTE FIM JPA faixaRepository");
	}
}
