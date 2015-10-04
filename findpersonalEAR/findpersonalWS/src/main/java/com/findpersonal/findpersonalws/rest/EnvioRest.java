package com.findpersonal.findpersonalws.rest;

import javax.validation.constraints.NotNull;

public abstract class EnvioRest {

	@NotNull
	protected double applicationVersion;

	public double getApplicationVersion() {
		return applicationVersion;
	}

	public void setApplicationVersion(double applicationVersion) {
		this.applicationVersion = applicationVersion;
	}

}
