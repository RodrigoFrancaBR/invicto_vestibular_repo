package invictoweb.web.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import invictoweb.model.Usuario;

@ManagedBean
@ViewScoped
public class LoginBean {
	private Usuario usuario;

	public LoginBean() {
		if (null == this.usuario) {
			this.usuario = new Usuario();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void efetuarLogin() {
		System.out.println(this.usuario.toString());
	}

}
