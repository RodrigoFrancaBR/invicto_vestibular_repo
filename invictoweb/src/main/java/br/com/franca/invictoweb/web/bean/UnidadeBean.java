package br.com.franca.invictoweb.web.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.franca.invictoweb.dao.UnidadeDAO;
import br.com.franca.invictoweb.model.Unidade;

@ManagedBean
@SessionScoped
public class UnidadeBean implements Serializable {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 4859594067758699906L;
	private UnidadeDAO dao;
	private Unidade unidade;
	private List<Unidade> listaDeUnidades;

	@PostConstruct
	public void init() {
		this.listaDeUnidades = dao.getLista(); // processo custoso
	}

	public List<Unidade> getListaDeUnidades() {
		return listaDeUnidades;
	}

	public void setListaDeUnidades(List<Unidade> listaDeUnidades) {
		this.listaDeUnidades = listaDeUnidades;
	}

	public UnidadeBean() {
		this.dao = new UnidadeDAO();
	}

	public UnidadeDAO getDao() {
		return dao;
	}

	public void setDao(UnidadeDAO dao) {
		this.dao = dao;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

}
