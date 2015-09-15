package com.findpersonal.findpersonaljpa.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("findpersonal");

	public EntityManager createEntityManager() {
		return factory.createEntityManager();
	}
}
