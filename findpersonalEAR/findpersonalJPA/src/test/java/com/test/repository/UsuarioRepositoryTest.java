package com.test.repository;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.findpersonal.findpersonaljpa.entity.PapelSistema;
import com.findpersonal.findpersonaljpa.repository.PapelSistemaRepository;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;
import com.test.config.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class UsuarioRepositoryTest {

	private static final Logger LOGGER = LogManager.getLogger(UsuarioRepositoryTest.class);

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PapelSistemaRepository papelSistemaRepository;
	
	@Test
	public void buscarAluno() throws Exception {
		LOGGER.info("TESTE INICIO JPA Usuario");
		usuarioRepository.findAll().forEach(
				a-> {
					PapelSistema papelSistema = papelSistemaRepository.findOne(1);
					a.getPapeis().add(papelSistema);
					papelSistema.getUsuarios().add(a);
					usuarioRepository.save(a);});
//		Usuario usuario = usuarioRepository.findByEmail("well@gmail.com").get();
//		System.out.println(usuario.getPersonal().getNome());
		LOGGER.info("TESTE FIM JPA ALUNO");
	}
}
