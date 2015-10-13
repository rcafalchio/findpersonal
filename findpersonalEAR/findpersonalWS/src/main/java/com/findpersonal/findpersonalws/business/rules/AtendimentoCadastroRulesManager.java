package com.findpersonal.findpersonalws.business.rules;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.findpersonal.findpersonaljpa.entity.DatabaseEntity;
import com.findpersonal.findpersonaljpa.entity.LocalAtendimento;
import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonalutil.constant.ValidationEnum;
import com.findpersonal.findpersonalws.business.charge.DatabaseInformation;
import com.findpersonal.findpersonalws.exception.BusinessException;

public class AtendimentoCadastroRulesManager extends RulesManager {

	private static final Logger LOGGER = LogManager.getLogger(AtendimentoCadastroRulesManager.class);

	private List<LocalAtendimento> locaisAtendimento;
	private Personal personal;

	public AtendimentoCadastroRulesManager(List<LocalAtendimento> locaisAtendimento, Personal personal) {
		super();
		this.locaisAtendimento = locaisAtendimento;
		this.personal = personal;
	}

	private void validarCadastro(List<ValidationEnum> listaValidacoes) {
		for (LocalAtendimento localAtendimento : locaisAtendimento) {
			if (localAtendimento.getId() == null || localAtendimento.getId().getCodigoCidade() == null
					|| localAtendimento.getId().getCodigoEstado() == null
					|| localAtendimento.getId().getCodigoPais() == null
					|| localAtendimento.getId().getCodigoPersonal() == null
					|| localAtendimento.getId().getCodigoZona() == null) {
				LOGGER.warn("CAMPOS PRINCIPAIS DO CADASTRO DO PERSONAL NAO PREENCHIDOS");
				listaValidacoes.add(ValidationEnum.CAMPOS_NAO_PREENCHIDOS);
			}
		}
	}

	@Override
	public void executarRegras(DatabaseInformation databaseInformation, DatabaseEntity databaseEntity)
			throws BusinessException {
		List<ValidationEnum> listaValidacoes = new ArrayList<ValidationEnum>();
		// VALIDA O PREENCHIMENTO DOS CAMPOS PRINCIPAIS
		this.validarCadastro(listaValidacoes);
		// VALIDA O PREENCHIMENTO DO PÈRSONAL
		// this.validarDadosPersonal(listaValidacoes);
	}

}
