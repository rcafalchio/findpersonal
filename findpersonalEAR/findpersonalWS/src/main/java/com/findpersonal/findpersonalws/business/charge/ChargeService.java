package com.findpersonal.findpersonalws.business.charge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.findpersonal.findpersonaljpa.repository.AlunoRepository;
import com.findpersonal.findpersonaljpa.repository.FaixaAulaPersonalRepository;
import com.findpersonal.findpersonaljpa.repository.PersonalRepository;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;

/**
 * Bean responsável por instanciar os componentes de carga do spring
 * 
 * @author Ricardo
 *
 */
@Service
public class ChargeService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	PersonalRepository personalRepository;

	@Autowired
	FaixaAulaPersonalRepository faixaAulaPersonalRepository;

	public void setFaixaAulaPersonalRepository(FaixaAulaPersonalRepository faixaAulaPersonalRepository) {
		this.faixaAulaPersonalRepository = faixaAulaPersonalRepository;
	}

	/**
	 * @param usuarioRepository
	 *            the usuarioRepository to set
	 */
	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	/**
	 * @param alunoRepository
	 *            the alunoRepository to set
	 */
	public void setAlunoRepository(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	/**
	 * @param personalRepository
	 *            the personalRepository to set
	 */
	public void setPersonalRepository(PersonalRepository personalRepository) {
		this.personalRepository = personalRepository;
	}

}
