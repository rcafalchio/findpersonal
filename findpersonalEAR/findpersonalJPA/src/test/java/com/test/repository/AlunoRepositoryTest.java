package com.test.repository;

import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.findpersonal.findpersonaljpa.entity.Aluno;
import com.findpersonal.findpersonaljpa.entity.Usuario;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;
import com.test.config.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class AlunoRepositoryTest {

	private static final Logger LOGGER = LogManager.getLogger(AlunoRepositoryTest.class);

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Test
	public void cadastrarUsuario() throws Exception {
		LOGGER.info("TESTE INICIO RICARDO");
//		Aluno aluno = new Aluno();
//		aluno.setDataNascimento(new Date());
//		aluno.setNome("TESTE JUNIT");
//		aluno.setSiglaSexo("M");
//		aluno.setUsuario(new Usuario(aluno, "ricardo", "123", "ricardo@gmail.com", true, false));
//		Usuario user = usuarioRepository.save(aluno.getUsuario());
//		usuarioRepository.delete(user);
		LOGGER.info("TESTE FIM RICARDO");
	}
}
