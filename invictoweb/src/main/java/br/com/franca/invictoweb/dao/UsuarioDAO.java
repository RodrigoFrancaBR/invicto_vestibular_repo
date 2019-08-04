package br.com.franca.invictoweb.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.franca.invictoweb.model.Usuario;
import br.com.franca.invictoweb.util.EntityManagerUtil;
import br.com.franca.invictoweb.util.Util;

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

	public Usuario buscarPor(String nomeUsuario, String senha) {
		String jpql = "Select u from Usuario u"
				  + " Where " + "u.nomeUsuario = :nomeUsuario"
				  + " and "   + "u.senha = :senha";

		try {
			TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
			query.setParameter("nomeUsuario", nomeUsuario);
			query.setParameter("senha", senha);
			Usuario usuario = query.getSingleResult();
			return usuario;
		} catch (Exception e) {
			if (em.getTransaction().isActive() == false) {
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();			
			mensagem = "falha: " + Util.getMensagemErro(e);
			// e.printStackTrace();
			return null;
		}
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
