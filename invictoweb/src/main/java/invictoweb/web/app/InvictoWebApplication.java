package invictoweb.web.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InvictoWebApplication {

	public InvictoWebApplication() {
		init();
	}

	private static final String PERSISTENCE_UNIT_NAME = "invictoPU";
	private static EntityManagerFactory emf;

	public static void init() {
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

	public static void finish() {
		if (emf != null) {
			emf.close();
		}
	}

	public static EntityManager createEntityManager() {
		if (emf == null) {
			throw new IllegalStateException("Context is not initialized yet.");
		}

		return emf.createEntityManager();
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
}
