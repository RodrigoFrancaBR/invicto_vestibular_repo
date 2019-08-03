package br.com.franca.invictoweb.web.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.franca.invictoweb.dao.UsuarioDAO;
import br.com.franca.invictoweb.model.Usuario;
import br.com.franca.invictoweb.model.UsuarioLogado;

@ManagedBean
@RequestScoped
public class LoginBean {
	private UsuarioLogado usuarioLogado;
	private UsuarioDAO dao;
	private String nome;
	private String senha;

	public LoginBean() {
		usuarioLogado = new UsuarioLogado();
		dao = new UsuarioDAO();
	}

	public String efetuarLogin() {
		Usuario usuario = dao.efetuarLogin(nome, senha);

		FacesContext context = FacesContext.getCurrentInstance();

		if (usuario != null) {
			this.usuarioLogado.setUsuario(usuario);
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuarioLogado);
			return "principal?faces-redirect=true";
		} else {
			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Usuário não encontrado", ""));
			return "login?faces-redirect=true";
		}
	}

	public String efetuarLogout() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado", this.usuarioLogado);
		return "login?faces-redirect=true";
	}

	public UsuarioLogado getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(UsuarioLogado usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public UsuarioDAO getDao() {
		return dao;
	}

	public void setDao(UsuarioDAO dao) {
		this.dao = dao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}