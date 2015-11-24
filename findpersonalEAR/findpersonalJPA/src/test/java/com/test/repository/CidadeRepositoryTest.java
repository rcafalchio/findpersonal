package com.test.repository;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.findpersonal.findpersonaljpa.entity.Cidade;
import com.findpersonal.findpersonaljpa.repository.CidadeRepository;
import com.test.config.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class CidadeRepositoryTest {

	private static final Logger LOGGER = LogManager.getLogger(CidadeRepositoryTest.class);
	
	@Autowired
	private CidadeRepository cidadeRepository;

	@Test
	public void cadastrarCidade() throws Exception {
		LOGGER.info("TESTE INICIO JPA CIDADE");
		Cidade entity = new Cidade();
		entity.setNome("TESTE JPA");
		cidadeRepository.save(entity);
		LOGGER.info("TESTE FIM JPA CIDADE");
	}

}
