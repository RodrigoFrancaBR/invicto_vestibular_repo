package br.com.franca.invictoweb.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.franca.invictoweb.dao.UsuarioDAO;
import br.com.franca.invictoweb.model.Usuario;
import br.com.franca.invictoweb.util.Util;

@ManagedBean
@SessionScoped
public class LoginBean {
	private String nomeUsuario;
	private String senha;
	private Usuario usuario;
	private UsuarioDAO dao;

	public LoginBean() {
		this.dao = new UsuarioDAO();
	}

	public String efetuarLogin() {
		usuario = dao.buscarPor(nomeUsuario, senha);

		FacesContext context = FacesContext.getCurrentInstance();

		if (usuario != null) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", usuario);
			return "principal?faces-redirect=true";
		} else {
			context.getExternalContext().getFlash().setKeepMessages(true);
			Util.mensagemErro(dao.getMensagem());
			return "login?faces-redirect=true";
		}
	}

	public String efetuarLogout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		this.usuario = null;
		return "login?faces-redirect=true";
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDAO getDao() {
		return dao;
	}

	public void setDao(UsuarioDAO dao) {
		this.dao = dao;
	}

}