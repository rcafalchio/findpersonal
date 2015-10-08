package com.test.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.findpersonal.findpersonaljpa.entity.LocalAtendimento;
import com.findpersonal.findpersonaljpa.entity.LocalAtendimentoPK;
import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonaljpa.entity.Usuario;
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
//		List<LocalAtendimento> locaisAtendimento = new ArrayList<LocalAtendimento>();
//		LocalAtendimento localAtendimento = new LocalAtendimento();
//		LocalAtendimentoPK localAtendimentoPK = new LocalAtendimentoPK(null,1,2,1,1);
//		localAtendimento.setId(localAtendimentoPK);
//		LOGGER.info("TESTE JUNIT CADASTRO PERSONAL");
//		final Personal personal = new Personal("Personal Teste", new Date());
//		personal.setUsuario(new Usuario(personal, "personal", "123", "ricardo@gmail.com", true, false));
//		personal.setLocaisAtendimento(locaisAtendimento);
//		usuarioRepository.save(personal.getUsuario());
//		usuarioRepository.delete(user);
		LOGGER.info("TESTE JUNIT CADASTRO PERSONAL");
	}
}
