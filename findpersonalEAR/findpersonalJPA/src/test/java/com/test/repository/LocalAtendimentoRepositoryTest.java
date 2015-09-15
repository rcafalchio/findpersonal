package com.test.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.findpersonal.findpersonaljpa.entity.LocalAtendimento;
import com.findpersonal.findpersonaljpa.entity.LocalAtendimentoPK;
import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonaljpa.repository.CidadeRepository;
import com.findpersonal.findpersonaljpa.repository.EstadoRepository;
import com.findpersonal.findpersonaljpa.repository.LocalAtendimentoRepository;
import com.findpersonal.findpersonaljpa.repository.PaisRepository;
import com.findpersonal.findpersonaljpa.repository.PersonalRepository;
import com.findpersonal.findpersonaljpa.repository.ZonaRepository;
import com.test.config.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest
public class LocalAtendimentoRepositoryTest {
	
	@Autowired
	private LocalAtendimentoRepository localAtendimentoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private ZonaRepository zonaRepository;

	@Autowired
	private PersonalRepository personalRepository;

	@Test
	public void cadastrarLocaisAtendimento() throws Exception {
		Personal personal = personalRepository.findAll().get(0);
		LocalAtendimento localAtendimento = new LocalAtendimento();
		LocalAtendimentoPK localAtendimentoPK = new LocalAtendimentoPK(personal.getCodigo(),
				estadoRepository.findAll().get(0).getCodigo(), zonaRepository.findAll().get(0).getCodigo(),
				paisRepository.findAll().get(0).getCodigo(), cidadeRepository.findAll().get(0).getCodigo());
		localAtendimento.setId(localAtendimentoPK);;
		localAtendimentoRepository.save(localAtendimento);

	}
}
