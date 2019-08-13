package br.com.franca.invictoweb.business;

import java.util.List;

import br.com.franca.invictoweb.dao.AbstractBaseDAO;
import br.com.franca.invictoweb.dao.IDAO;

public abstract class AbstractBaseBusiness<E, D extends AbstractBaseDAO> implements IDAO<E> {
	protected E entity;

	private List<E> listEntitys;

	private D dao;

	// Métodos implementados na classe filha

	public abstract D getDao();

	public abstract E createNewEntity();

	// Métodos Crud

	@Override
	public List<E> findAll() {
		dao = getDao();		
		return dao.findAll();
		// return listEntitys;
	}

	@Override
	public void save(E entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void update(E entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(E entity) {
		// TODO Auto-generated method stub

	}
}
