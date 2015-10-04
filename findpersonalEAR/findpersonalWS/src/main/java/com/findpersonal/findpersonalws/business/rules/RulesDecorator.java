package com.findpersonal.findpersonalws.business.rules;

public abstract class RulesDecorator extends RulesManager {

	protected RulesManager rulesManager;

	public RulesDecorator(RulesManager rulesManager) {
		this.rulesManager = rulesManager;
	}
}
