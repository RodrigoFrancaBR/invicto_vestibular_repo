package br.com.franca.invictoweb.dao.factory;

import java.lang.reflect.Constructor;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.franca.invictoweb.dao.BaseDAO;

public class InvictoDAOFactory implements IDAOFactory {

	private EntityManager baseEM = null;

	private int controlTransaction = 0;
	private final EntityManagerFactory emf;
	private final HashMap<String, BaseDAO> listaDAO;

	public InvictoDAOFactory(EntityManagerFactory emf) {
		super();
		this.emf = emf;
		this.listaDAO = new HashMap<>();

	}

	public static Integer[] TRS = { 0, 0, 0 };

	@Override
	public synchronized void startGlobalTransaction() {
		if (baseEM == null) {
			baseEM = emf.createEntityManager();
		}
		if (controlTransaction == 0) {
			baseEM.getTransaction().begin();
		}
		controlTransaction++;
		TRS[0] = TRS[0] + 1;
	}

	@Override
	public synchronized void commitGlobalTransaction() {
		controlTransaction--;
		if (baseEM != null && controlTransaction == 0) {
			baseEM.getTransaction().commit();
			if (baseEM.isOpen()) {
				baseEM.close();
			}
			baseEM = null;
			TRS[1] = TRS[1] + 1;
		}
	}

	@Override
	public synchronized void rollbackGlobalTransaction() {
		controlTransaction--;
		if (baseEM != null && controlTransaction == 0) {
			baseEM.getTransaction().rollback();
			if (baseEM.isOpen()) {
				baseEM.close();
			}
			baseEM = null;
			TRS[2] = TRS[2] + 1;
		}
	}

	public <U extends BaseDAO> U getDAO(Class<U> clazz) {
		U retorno = getInstance(clazz);
		if (retorno == null) {
			retorno = createInstance(clazz);
		}
		return retorno;
	}

	protected <U extends BaseDAO> U createInstance(Class<U> clazz) {
		U retorno = null;
		try {
			Constructor<U> construtor = clazz.getDeclaredConstructor(IDAOFactory.class);
			construtor.setAccessible(true);
			retorno = construtor.newInstance(this);
			if (retorno != null) {
				listaDAO.put(clazz.getName(), retorno);
			}
		} catch (Exception e) {
		}
		return retorno;
	}

	@SuppressWarnings("unchecked")
	protected <U extends BaseDAO> U getInstance(Class<U> clazz) {
		U retorno = (U) listaDAO.get(clazz.getName());
		return retorno;
	}

	@Override
	public EntityManager getBaseEM() {
		return this.baseEM;
	}

	@Override
	public synchronized EntityManager getEntityManager() throws Exception {
		try {
			if (this.baseEM != null) {
				return this.baseEM;
			} else {
				return emf.createEntityManager();
			}
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}
