package com.findpersonal.findpersonalws.business.rules;

public abstract class PersonalCadastroRulesDecorator extends RulesManager {

	private RulesManager rulesManagerDecorate;

	public PersonalCadastroRulesDecorator(RulesManager rulesManagerDecorate) {
		this.rulesManagerDecorate = rulesManagerDecorate;
	}
}
