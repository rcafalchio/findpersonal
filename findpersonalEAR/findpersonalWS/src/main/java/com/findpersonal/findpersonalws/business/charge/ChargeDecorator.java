package com.findpersonal.findpersonalws.business.charge;

public abstract class ChargeDecorator extends ChargeManager {

	protected ChargeManager chargeManager;

	public ChargeDecorator(ChargeManager chargeManager) {
		this.chargeManager = chargeManager;
	}	
}
