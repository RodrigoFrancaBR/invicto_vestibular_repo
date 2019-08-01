package br.com.franca.invictoweb.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	private static final String PERSISTENCE_UNIT_NAME = "invictoPU";
	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;

	public static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}
		if (em == null) {
			em = emf.createEntityManager();
		}
		return em;
	}
}
