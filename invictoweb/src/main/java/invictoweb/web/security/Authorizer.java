package invictoweb.web.security;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import invictoweb.model.Usuario;

public class Authorizer implements PhaseListener {

	private static final long serialVersionUID = 4031554023462566875L;	

	@Override
	public void afterPhase(PhaseEvent event) {
		// recuperar a arvore para saber o nome da pagina
		FacesContext context = event.getFacesContext();
		@SuppressWarnings("unused")
		String nomePagina = context.getViewRoot().getViewId();
		System.out.println(nomePagina);
		if ("/login.xhtml".equals(nomePagina)) {
			return;
		}

		@SuppressWarnings("unused")
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);

		// recupera os dados que estão na sessão http
		Usuario usuarioLogado = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
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
