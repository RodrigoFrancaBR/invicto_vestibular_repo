package br.com.franca.invictoweb.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.franca.invictoweb.dao.factory.IDAOFactory;
import br.com.franca.invictoweb.model.Usuario;

public class UsuarioDAO extends BaseDAO {

	protected UsuarioDAO(IDAOFactory daoFactory) {
		super(daoFactory);
	}

	public Usuario findUser(Usuario user) throws Exception {

		Usuario resultado = null;
		EntityManager em = null;

		try {
			em = getEntityManager();

			TypedQuery<Usuario> query = em.createQuery(
					" select u from Usuario u " + " where u.nome = :pNome and u.senha = :pSenha", Usuario.class);

			query.setParameter("pNome", user.getNome());
			query.setParameter("pSenha", user.getSenha());

			return resultado = query.getSingleResult();

		} finally {
			closeEntityManager(em);
		}
	}
}
