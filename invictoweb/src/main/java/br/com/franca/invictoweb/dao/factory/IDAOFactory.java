package br.com.franca.invictoweb.dao.factory;

import javax.persistence.EntityManager;

import br.com.franca.invictoweb.dao.BaseDAO;

public interface IDAOFactory {
	public void startGlobalTransaction();

	public void commitGlobalTransaction();

	public void rollbackGlobalTransaction();

	public EntityManager getBaseEM();

	public EntityManager getEntityManager() throws Exception;

	public <U extends BaseDAO> U getDAO(Class<U> clazz);

}
