package br.com.franca.invictoweb.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.franca.invictoweb.model.Usuario;
import br.com.franca.invictoweb.util.EntityManagerUtil;

public class UsuarioDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5863741478489628684L;

	private String mensagem = "";
	private EntityManager em;

	public UsuarioDAO() {
		this.em = EntityManagerUtil.getEntityManager();
	}

	public Usuario efetuarLogin(String nome, String senha) {
		String jpql = "Select u from Usuario u Where " + "u.nome = :nome" + " and " + "u.senha = :senha";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		query.setParameter("nome", nome);
		query.setParameter("senha", senha);
		return query.getSingleResult();

	}
}
