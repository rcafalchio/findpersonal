package com.test.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.findpersonal.findpersonaljpa.entity.Estado;
import com.findpersonal.findpersonaljpa.repository.EstadoRepository;
import com.test.config.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class EstadoRepositoryTest {

	@Autowired
	private EstadoRepository estadoRepository;

	@Test
	public void cadastrarEstado() throws Exception {
		Estado estado = new Estado();
		estado.setNome("SP");
		estadoRepository.save(estado);
	}

}
