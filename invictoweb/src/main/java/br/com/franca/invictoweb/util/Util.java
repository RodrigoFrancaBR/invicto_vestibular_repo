package br.com.franca.invictoweb.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Util {

	public static String getMensagemErro(Exception e) {
		while (e.getCause() != null) {
			e = (Exception) e.getCause();
		}
		return e.getMessage();	
	}

	public static void mensagemInformacao(String msg) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getExternalContext().getFlash().setKeepMessages(true);
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "");
		facesContext.addMessage(null, mensagem);
	}

	public static void mensagemErro(String msg) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.getExternalContext().getFlash().setKeepMessages(true);
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "");
		facesContext.addMessage(null, mensagem);
	}
}
