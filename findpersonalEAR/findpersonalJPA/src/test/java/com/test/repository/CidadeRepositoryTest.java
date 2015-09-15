package com.test.repository;

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

	@Autowired
	private CidadeRepository cidadeRepository;

	@Test
	public void cadastrarCidade() throws Exception {
		Cidade cidade = new Cidade();
		cidade.setNome("SÃO PAULO");
		cidadeRepository.save(cidade);
	}

}
