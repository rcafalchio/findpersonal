package com.findpersonal.findpersonalws.rest.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class EnvioJSON {

	@JsonProperty("APV")
	@NotNull
	protected double applicationVersion;

	public double getApplicationVersion() {
		return applicationVersion;
	}

	public void setApplicationVersion(double applicationVersion) {
		this.applicationVersion = applicationVersion;
	}

}
