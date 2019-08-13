package br.com.franca.invictoweb.dao;

import java.util.List;

public abstract class AbstractBaseDAO<E> implements IDAO<E> {
	
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

	@Override
	public List<E> findAll() {
		return null;
	}

}
