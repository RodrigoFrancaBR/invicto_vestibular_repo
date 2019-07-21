package invictoweb.web.rs;

import javax.persistence.EntityManagerFactory;

import invictoweb.business.factory.InvictoBusinessFactory;
import invictoweb.dao.factory.InvictoDAOFactory;
import invictoweb.web.app.InvictoWebApplication;

public class BaseResource {
	private InvictoBusinessFactory businessFactory = null;

	public InvictoBusinessFactory getBusinessFactory() {
		// verifica se já existe uma fábrica de negócios
		if (businessFactory == null) {

			// TokenUsuarioVO usuarioValido = getUsuarioLogado();
			InvictoWebApplication invictoWeb = new InvictoWebApplication();

			EntityManagerFactory emf = invictoWeb.getEntityManagerFactory();

			InvictoDAOFactory daoFactory = new InvictoDAOFactory(emf);

			// qdo se cria uma fábrica precisa passar um usuário válido e uma
			// fábrica de DAO
			this.businessFactory = new InvictoBusinessFactory(daoFactory);

			// businessFactory = new
			// InvictoBusinessFactory(getUsuarioLogado(),new
			// InvictoDAOFactory(getUsuarioLogado(),new
			// JaxRsApplication().getEntityManagerFactory()));
			// businessFactory = new
			// InvictoBusinessFactory(getUsuarioLogado(),new
			// InvictoDAOFactory(getUsuarioLogado(),
			// JaxRsApplication.getEntityManagerFactory()));
		}
		return businessFactory;
	}
}
