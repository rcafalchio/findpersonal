package com.findpersonal.findpersonalws.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.findpersonal.findpersonaljpa.entity.LocalAtendimento;
import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonalutil.constant.CadastroValidationEnum;
import com.findpersonal.findpersonalws.exception.BusinessException;

public class AtendimentoCadastroRulesManager implements RulesManager {

	private static final Logger LOGGER = LogManager.getLogger(AtendimentoCadastroRulesManager.class);

	private List<LocalAtendimento> locaisAtendimento;
	private Personal personal;

	public AtendimentoCadastroRulesManager(List<LocalAtendimento> locaisAtendimento, Personal personal) {
		super();
		this.locaisAtendimento = locaisAtendimento;
		this.personal = personal;
	}

	@Override
	public void executarRegras() throws BusinessException {
		List<CadastroValidationEnum> listaValidacoes = new ArrayList<CadastroValidationEnum>();
		// VALIDA O PREENCHIMENTO DOS CAMPOS PRINCIPAIS
		this.validarCadastro(listaValidacoes);
		// VALIDA O PREENCHIMENTO DO PÈRSONAL
//		this.validarDadosPersonal(listaValidacoes);
	}

	private void validarCadastro(List<CadastroValidationEnum> listaValidacoes) {
		for (LocalAtendimento localAtendimento : locaisAtendimento) {
			if (localAtendimento.getId() == null || localAtendimento.getId().getCodigoCidade() == null
					|| localAtendimento.getId().getCodigoEstado() == null
					|| localAtendimento.getId().getCodigoPais() == null
					|| localAtendimento.getId().getCodigoPersonal() == null
					|| localAtendimento.getId().getCodigoZona() == null) {
				LOGGER.warn("CAMPOS PRINCIPAIS DO CADASTRO DO PERSONAL NAO PREENCHIDOS");
				listaValidacoes.add(CadastroValidationEnum.CAMPOS_NAO_PREENCHIDOS);
			}
		}
	}

}
