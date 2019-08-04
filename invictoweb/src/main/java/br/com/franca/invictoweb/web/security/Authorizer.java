package br.com.franca.invictoweb.web.security;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.franca.invictoweb.model.Usuario;

public class Authorizer implements PhaseListener {

	private static final long serialVersionUID = 4031554023462566875L;

	@Override
	public void afterPhase(PhaseEvent event) {

		System.out.println("FASE: " + event.getPhaseId());

		FacesContext context = event.getFacesContext();

		// recuperar a arvore para saber o nome da pagina
		String nomePagina = context.getViewRoot().getViewId();

		System.out.println(nomePagina);

		if ("/login.xhtml".equals(nomePagina)) {
			return;
		}

		Usuario usuarioLogado = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
		System.out.println(usuarioLogado);

		if (null == usuarioLogado) {
			// navegacao programaticamente
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			handler.handleNavigation(context, null, "/login?faces-redirect=true");
			context.renderResponse();
		} else {
			return;
		}

	}

	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("FASE: " + event.getPhaseId());

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}
}
