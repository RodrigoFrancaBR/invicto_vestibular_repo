package br.com.franca.invictoweb.business;

import br.com.franca.invictoweb.business.factory.InvictoBusinessFactory;
import br.com.franca.invictoweb.dao.BaseDAO;
import br.com.franca.invictoweb.dao.factory.IDAOFactory;

public abstract class BaseBusiness {
	private final InvictoBusinessFactory factory;
	private final IDAOFactory daoFactory;

	protected BaseBusiness(InvictoBusinessFactory factory) {
		super();
		this.factory = factory;
		this.daoFactory = factory.getDAOFactory();
	}

	public synchronized void startGlobalTransaction() {
		this.daoFactory.startGlobalTransaction();
	}

	public synchronized void commitGlobalTransaction() {
		this.daoFactory.commitGlobalTransaction();
	}

	public synchronized void rollbackGlobalTransaction() {
		this.daoFactory.rollbackGlobalTransaction();
	}

	protected abstract BaseDAO getDAO();

	protected <U extends BaseBusiness> U createBusiness(Class<U> clazz) {
		return factory.getBusiness(clazz);
	}

	protected <U extends BaseDAO> U createDAO(Class<U> clazz) {
		return daoFactory.getDAO(clazz);
	}
}
