package br.com.franca.invictoweb.business;

import br.com.franca.invictoweb.dao.UnidadeDAO;
import br.com.franca.invictoweb.model.Unidade;

public class UnidadeBusiness extends AbstractBaseBusiness<Unidade, UnidadeDAO> {
	private UnidadeDAO dao;

	@Override
	public Unidade createNewEntity() {
		return new Unidade();
	}

	@Override
	public UnidadeDAO getDao() {
		if (dao == null) {
			dao = new UnidadeDAO();
		}
		return dao;
	}
}
