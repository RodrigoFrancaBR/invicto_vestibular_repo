package br.com.franca.invictoweb.dao;

import java.util.List;

public interface IDAO<E> {
	public void save(E entity);

	public void update(E entity);

	public void delete(E entity);	

	public List<E> findAll();
}
