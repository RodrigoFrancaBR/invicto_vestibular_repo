package br.com.franca.invictoweb.web.rs;

import br.com.franca.invictoweb.business.UsuarioBusiness;
import br.com.franca.invictoweb.model.Usuario;

public class LoginResource extends BaseResource {
	public Boolean efetuarLogin(Usuario usuario) {

		UsuarioBusiness usuarioBusiness = getBusinessFactory().getBusiness(UsuarioBusiness.class);

		Usuario usuarioLogado = null;

		try {
			usuarioLogado = usuarioBusiness.validarUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null == usuarioLogado)
			return false;
		else {
			return true;
		}

	}

}
