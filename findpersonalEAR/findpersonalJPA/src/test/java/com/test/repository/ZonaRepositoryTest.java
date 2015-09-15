package com.test.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.findpersonal.findpersonaljpa.entity.Zona;
import com.findpersonal.findpersonaljpa.repository.ZonaRepository;
import com.test.config.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class ZonaRepositoryTest {

	@Autowired
	private ZonaRepository zonaRepository;

	@Test
	public void cadastrarZona() throws Exception {
		Zona zona = new Zona();
		zona.setDescricao("ZONA NORTE");
		zonaRepository.save(zona);
	}

}
