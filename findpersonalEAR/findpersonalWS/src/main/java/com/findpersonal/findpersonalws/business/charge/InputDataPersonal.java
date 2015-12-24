package com.findpersonal.findpersonalws.business.charge;

import com.findpersonal.findpersonaljpa.entity.Personal;
import com.findpersonal.findpersonalws.rest.dto.FiltroPersonalJSON;

public class InputDataPersonal implements ChargeInputData {

	private Personal personal;
	private FiltroPersonalJSON filtroPersonalJSON;

	public InputDataPersonal(Personal personal) {
		super();
		this.personal = personal;
	}

	public InputDataPersonal(FiltroPersonalJSON filtroPersonalJSON) {
		super();
		this.filtroPersonalJSON = filtroPersonalJSON;
	}

	/**
	 * @return the personal
	 */
	public Personal getPersonal() {
		return personal;
	}

	/**
	 * @return the filtroPersonalJSON
	 */
	public FiltroPersonalJSON getFiltroPersonalJSON() {
		return filtroPersonalJSON;
	}

}
