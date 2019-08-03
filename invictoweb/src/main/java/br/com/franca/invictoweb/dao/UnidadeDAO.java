package br.com.franca.invictoweb.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.franca.invictoweb.model.Unidade;
import br.com.franca.invictoweb.util.EntityManagerUtil;
import br.com.franca.invictoweb.util.Util;

public class UnidadeDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5344268670413852352L;
	private String mensagem = "";
	private EntityManager em;

	public UnidadeDAO() {
		this.em = EntityManagerUtil.getEntityManager();
	}

	public List<Unidade> getLista() {
		TypedQuery<Unidade> q = em.createQuery("from Unidade order by nome", Unidade.class);
		List<Unidade> listaUnidades = q.getResultList();
		return listaUnidades;
	}

	public boolean salvar(Unidade unidade) {
		try {
			em.getTransaction().begin();
			em.persist(unidade);
			em.getTransaction().commit();
			mensagem = "sucesso";
			return true;
		} catch (Exception e) {
			if (em.getTransaction().isActive() == false) {
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			Util.setMensagemErro(e);
			mensagem = "falha: " + Util.getMensagemErro();
			return false;
		}
	}

	public Unidade buscarPorID(Long id) {
		return em.find(Unidade.class, id);
	}
}