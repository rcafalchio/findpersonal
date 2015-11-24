package com.findpersonal.findpersonalws.business.charge;

import com.findpersonal.findpersonalws.util.SpringContext;

public abstract class ChargeManager {

	ChargeService chargeService;

	public ChargeManager() {
		this.chargeService = (ChargeService) SpringContext.getApplicationContext().getBean("chargeService");
	}

	public abstract DatabaseInformation obterCarga(ChargeInputData dataInput);

	/**
	 * @return the chargeService
	 */
	public ChargeService getChargeService() {
		return chargeService;
	}

}
