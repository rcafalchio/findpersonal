package com.findpersonal.findpersonalws.business.charge;

import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;
import com.findpersonal.findpersonaljpa.repository.AlunoRepository;
import com.findpersonal.findpersonaljpa.repository.UsuarioRepository;

public abstract class ChargeManager {
	
	public ChargeManager() {
	}

	protected AlunoRepository alunoRepository;
	protected UsuarioRepository usuarioRepository;

	public ChargeManager(AlunoRepository alunoRepository, UsuarioRepository usuarioRepository) {
		super();
		this.alunoRepository = alunoRepository;
		this.usuarioRepository = usuarioRepository;
	}
	
	public abstract DatabaseInformation obterCarga(DatabaseEntity entity, DatabaseInformation databaseInformation);
}
