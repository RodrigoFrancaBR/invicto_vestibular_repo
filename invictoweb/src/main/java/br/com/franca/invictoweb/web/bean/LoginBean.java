package br.com.franca.invictoweb.web.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ReferencedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.xml.bind.ValidationException;

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
	
	public void verificarEmail(FacesContext context, UIComponent component, Object valorDigitado)throws ValidatorException {
		String valor = valorDigitado.toString();
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_WARN, "Email",
				"O valor do campo precisa ter no máximo 30 caracteres.");
		
		if (valor.length() > 30){
			System.err.println("erro");
			context.addMessage("formLogin:inpEmail", mensagem);
			}			
	}
	
	public void verificarSenha(FacesContext context, UIComponent component, Object valorDigitado)
			throws ValidatorException {
		String valor = valorDigitado.toString();
		if (!valor.startsWith("1")) {
			// throw new ValidatorException(new FacesMessage("Toda Senha deve
			// iniciar com 1"));
			FacesContext.getCurrentInstance().addMessage("inpSenha", new FacesMessage("Toda Senha deve iniciar com 1"));
		}
	}

	public String efetuarLogin() {
		System.out.println("Ola");
		
		/*FacesContext context = FacesContext.getCurrentInstance();

		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email",
				"Email inválido: " + this.usuario.getEmail());

		// context.addMessage("formLogin:inpEmail", mensagem);

		LoginResource loginResource = new LoginResource();

		boolean isAutorizado = loginResource.efetuarLogin(usuario);

		if (isAutorizado) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			// return "welcome?faces-redirect=true";
			return "principal?faces-redirect=true";
		} else {
			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage("formLogin:inpEmail", mensagem);
			// context.addMessage("formLogin:inpEmail", new
			// FacesMessage("Usuário não encontrado"));
			return "login?faces-redirect=true";
		}
*/
		 return null;
	}

}
