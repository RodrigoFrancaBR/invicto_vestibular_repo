package br.com.franca.invictoweb.service;

import java.util.List;

import br.com.franca.invictoweb.business.AbstractBaseBusiness;
import br.com.franca.invictoweb.dao.IDAO;

public abstract class AbstractBaseService<E, B extends AbstractBaseBusiness> implements IDAO<E> {
	protected E entity;

	private List<E> listEntitys;

	private B business;

	// Métodos implementados na classe filha

	public abstract B getBusiness();

	public abstract E createNewEntity();

	// Getters e Setters de Entity

	public E getEntity() {
		return entity;
	}

	public void setEntity(E entity) {
		this.entity = entity;
	}

	public List<E> getListEntitys() {
		return listEntitys;
	}

	public void setListEntitys(List<E> listEntitys) {
		this.listEntitys = listEntitys;
	}

	// Método para criar uma nova entidade generica
	public void newEntity() {
		entity = createNewEntity();
	}

	// Métodos Crud

	@Override
	public List<E> findAll() {
		business = getBusiness();
		return business.findAll();
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
