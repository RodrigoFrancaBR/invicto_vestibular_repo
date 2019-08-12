package br.com.franca.invictoweb.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.franca.invictoweb.model.Unidade;
import br.com.franca.invictoweb.service.UnidadeService;

@ManagedBean
@SessionScoped
public class UnidadeBean extends AbstractBaseManagedBean<Unidade, UnidadeService> {
	private UnidadeService service;

	@Override
	public Unidade createNewEntity() {
		return new Unidade();
	}

	@Override
	public UnidadeService getService() {
		if (service == null) {
			service = new UnidadeService();
		}
		return service;	
	}
}
