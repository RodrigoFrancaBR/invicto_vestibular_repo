package invictoweb.dao;

import javax.persistence.EntityManager;

import invictoweb.dao.factory.IDAOFactory;

public abstract class BaseDAO {
	private IDAOFactory daoFactory;

	protected BaseDAO(IDAOFactory daoFactory) {
		super();
		this.daoFactory = daoFactory;
	}

	public <T> T findEntityById(Class<T> classe, Long id) throws Exception {
		EntityManager em = null;
		T retorno = null;
		try {
			em = getEntityManager();
			retorno = em.find(classe, id);
		} catch (Exception e) {
			throw new Exception(e);
		} finally {
			closeEntityManager(em);
		}
		return retorno;
	}

	private EntityManager getTransactionEM() {
		return daoFactory.getBaseEM();
	}

	protected EntityManager getEntityManager() throws Exception {
		return daoFactory.getEntityManager();
	}

	protected void closeEntityManager(EntityManager em) {
		if (em != null && em != getTransactionEM() && em.isOpen()) {
			em.close();
		}
	}

}
