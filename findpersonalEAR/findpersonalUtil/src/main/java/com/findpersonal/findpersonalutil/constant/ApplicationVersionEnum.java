package com.findpersonal.findpersonalutil.constant;

import java.util.ArrayList;
import java.util.List;

public enum ApplicationVersionEnum {

	VERSION_NOT_MATCH(-1.00, "-100"), VERSION_1_00(1.00, "100");

	private double version;
	private String versionName;

	public double getVersion() {
		return version;
	}

	public String getVersionName() {
		return versionName;
	}

	private ApplicationVersionEnum(double version, String versionName) {
		this.version = version;
		this.versionName = versionName;
	}

	/**
	 * Recupera o enum da versão
	 * 
	 * @param applicationVersion
	 *            Versão
	 * @return ApplicationVersionEnum
	 */
	public static ApplicationVersionEnum getEnum(double applicationVersion) {
		ApplicationVersionEnum enumReturn = ApplicationVersionEnum.VERSION_NOT_MATCH;
		for (ApplicationVersionEnum applicationVersionEnum : ApplicationVersionEnum.values()) {
			if (applicationVersionEnum.getVersion() == applicationVersion) {
				enumReturn = applicationVersionEnum;
			}
		}
		return enumReturn;
	}

	/**
	 * Recupera uma lista de enum com as versões antigas da aplicação
	 * 
	 * @return List<ApplicationVersionEnum>
	 */
	public List<ApplicationVersionEnum> recuperarOldVersions() {
		List<ApplicationVersionEnum> oldVersions = new ArrayList<ApplicationVersionEnum>();

		for (ApplicationVersionEnum applicationVersionEnum : ApplicationVersionEnum.values()) {
			if (applicationVersionEnum.version > this.version) {
				break;
			}
			if (applicationVersionEnum.version > 0) {
				oldVersions.add(applicationVersionEnum);
			}

		}
		return oldVersions;
	}

	// public static void main(String[] args) {
	// List<ApplicationVersionEnum> list = ApplicationVersionEnum.VERSION_2_00.recuperarOldVersions();
	// for (ApplicationVersionEnum applicationVersionEnum : list) {
	// System.out.println(applicationVersionEnum);
	// }
	// }

}
