package invictoweb.web.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import invictoweb.model.Usuario;
import invictoweb.web.rs.LoginResource;

@ManagedBean
@SessionScoped
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

	public String efetuarLogin() {

		FacesContext context = FacesContext.getCurrentInstance();

		LoginResource loginResource = new LoginResource();

		boolean isAutorizado = loginResource.efetuarLogin(usuario);

		if (isAutorizado) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			return "welcome?faces-redirect=true";
		} else {
			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null, new FacesMessage("Usuário não encontrado"));
			return "login?faces-redirect=true";
		}
	}

}
