package br.com.franca.invictoweb.service;

import br.com.franca.invictoweb.business.UnidadeBusiness;
import br.com.franca.invictoweb.model.Unidade;

public class UnidadeService extends AbstractBaseService<Unidade, UnidadeBusiness>  {
	private UnidadeBusiness business;

	@Override
	public UnidadeBusiness getBusiness() {
		if (business == null) {
			business = new UnidadeBusiness();
		}
		return business;
	}

	@Override
	public Unidade createNewEntity() {
		return new Unidade();
	}
}
