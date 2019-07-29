package br.com.franca.invictoweb.web.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.franca.invictoweb.model.Usuario;
import br.com.franca.invictoweb.web.rs.LoginResource;

@ManagedBean
@RequestScoped
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

	/*
	 * public void verificarUsuario(FacesContext context, UIComponent component,
	 * Object valorDigitado) throws ValidatorException { String nomeUsuario =
	 * valorDigitado.toString();
	 * 
	 * if (nomeUsuario.length() < 7 || nomeUsuario.length() > 10) {
	 * context.addMessage("formLogin:inpUsuario", new
	 * FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário",
	 * "O valor do campo deve ter no mínimo 7 e no máximo 10 caracteres.")); } }
	 * 
	 * public void verificarSenha(FacesContext context, UIComponent component,
	 * Object valorDigitado) throws ValidatorException { String senha =
	 * valorDigitado.toString(); if (senha.length() < 7 || senha.length() > 10)
	 * { context.addMessage("formLogin:inpUsuario", new
	 * FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha",
	 * "O valor do campo deve ter no mínimo 7 e no máximo 10 caracteres.")); } }
	 */

	public String efetuarLogin() {

		LoginResource loginResource = new LoginResource();

		boolean isAutorizado = loginResource.efetuarLogin(usuario);
		FacesContext context = FacesContext.getCurrentInstance();

		if (isAutorizado) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			return "principal?faces-redirect=true";
		} else {
			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Login", "Usuário não encontrado"));
			return "login?faces-redirect=true";
		}
	}

}