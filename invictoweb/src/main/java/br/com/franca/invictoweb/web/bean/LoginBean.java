package br.com.franca.invictoweb.web.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.xml.bind.ValidationException;

import br.com.franca.invictoweb.model.Usuario;
import br.com.franca.invictoweb.web.rs.LoginResource;

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
	
	public void verificarSenha(FacesContext context , UIComponent component, Object valorDigitado)throws ValidatorException{
		String valor = valorDigitado.toString();
		if (!valor.startsWith("1")){
			// throw new ValidatorException(new FacesMessage("Toda Senha deve iniciar com 1"));
			FacesContext.getCurrentInstance().addMessage("inpSenha", new FacesMessage("Toda Senha deve iniciar com 1"));
		}
	}

	public String efetuarLogin() {

		FacesContext context = FacesContext.getCurrentInstance();

		LoginResource loginResource = new LoginResource();

		boolean isAutorizado = loginResource.efetuarLogin(usuario);

		if (isAutorizado) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			// return "welcome?faces-redirect=true";
			return "principal?faces-redirect=true";
		} else {
			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null, new FacesMessage("Usuário não encontrado"));
			return "login?faces-redirect=true";
		}
	}

}
