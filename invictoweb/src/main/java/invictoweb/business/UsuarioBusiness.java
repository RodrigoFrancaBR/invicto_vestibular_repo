package invictoweb.business;

import invictoweb.business.factory.InvictoBusinessFactory;
import invictoweb.dao.UsuarioDAO;
import invictoweb.model.Usuario;

public class UsuarioBusiness extends BaseBusiness {

	protected UsuarioBusiness(InvictoBusinessFactory factory) {
		super(factory);
		this.dao = createDAO(UsuarioDAO.class);
	}

	private UsuarioDAO dao;

	@Override
	protected UsuarioDAO getDAO() {
		return dao;
	}

	@SuppressWarnings("unused")
	public Usuario validarUsuario(Usuario usuario) throws Exception {

		if (null == usuario) {
			throw new RuntimeException();
		}

		if (null == usuario.getEmail()) {
			throw new RuntimeException();
		}

		if (null == usuario.getSenha()) {
			throw new RuntimeException();
		}


		Usuario user = getDAO().findUser(usuario);
		if (null == user) {
			return null;
		} else {
			return user;
		}
	}
}
