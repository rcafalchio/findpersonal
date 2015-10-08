package com.findpersonal.findpersonalws.rest;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class EnvioRest {

	@JsonProperty("apv")
	@NotNull
	protected double applicationVersion;

	public double getApplicationVersion() {
		return applicationVersion;
	}

	public void setApplicationVersion(double applicationVersion) {
		this.applicationVersion = applicationVersion;
	}

}
