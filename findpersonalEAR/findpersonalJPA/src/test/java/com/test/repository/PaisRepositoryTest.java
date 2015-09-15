package com.test.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.findpersonal.findpersonaljpa.entity.Pais;
import com.findpersonal.findpersonaljpa.repository.PaisRepository;
import com.test.config.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class PaisRepositoryTest {

	@Autowired
	private PaisRepository paisRepository;

	@Test
	public void cadastrarCidade() throws Exception {
		Pais pais = new Pais();
		pais.setNome("Brasil");
		paisRepository.save(pais);
	}

}
