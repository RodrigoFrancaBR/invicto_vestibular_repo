package br.com.franca.invictoweb.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.franca.invictoweb.dao.IDAO;
import br.com.franca.invictoweb.service.AbstractBaseService;

public abstract class AbstractBaseManagedBean<E, S extends AbstractBaseService> implements IDAO<E> {
	protected E entity;

	private List<E> listEntitys;

	private S service;

	protected String estadoTela = "buscar";

	// Metodos para saber o estado da tela
	public boolean isInserir() {
		return "inserir".equals(estadoTela);
	}

	public boolean isEditar() {
		return "editar".equals(estadoTela);
	}

	public boolean isBuscar() {
		return "buscar".equals(estadoTela);
	}

	// Métodos para mudar o estado da tela
	public void mudarParaInserir() {
		estadoTela = "inserir";
	}

	public void mudarParaEditar() {
		estadoTela = "editar";
	}

	public void mudarParaBuscar() {
		estadoTela = "buscar";
	}

	// Métodos implementados na classe filha

	public abstract S getService();

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
		mudarParaInserir();
	}

	// Métodos Crud

	@Override
	public List<E> findAll() {
		if (isBuscar() == false) {
			mudarParaBuscar();
		}
		
		service = getService();
		
		listEntitys = service.findAll();
		return null;
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

	// Metodos para mostrar mensagens
	public void addErrorMessage(String componentId, String errorMessage) {
		addMessage(componentId, errorMessage, FacesMessage.SEVERITY_ERROR);
	}

	public void addErrorMessage(String errorMessage) {
		addErrorMessage(null, errorMessage);
	}

	public void addInfoMessage(String componentId, String infoMessage) {
		addMessage(componentId, infoMessage, FacesMessage.SEVERITY_INFO);
	}

	public void addInfoMessage(String infoMessage) {
		addInfoMessage(null, infoMessage);
	}

	private void addMessage(String componentId, String errorMessage, FacesMessage.Severity severity) {
		FacesMessage message = new FacesMessage(errorMessage);
		message.setSeverity(severity);
		FacesContext.getCurrentInstance().addMessage(componentId, message);
	}
}
