package com.findpersonal.findpersonalws.rest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AgencyResource {

	@NotNull
	@Min(1)
	@Max(20)
	private Integer id;

	@NotNull
	private String name;

	@NotNull
	private String EIN;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEIN() {
		return EIN;
	}

	public void setEIN(String eIN) {
		EIN = eIN;
	}
}
