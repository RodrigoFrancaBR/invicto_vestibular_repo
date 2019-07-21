package invictoweb.business.factory;

import java.lang.reflect.Constructor;
import java.util.HashMap;

import invictoweb.business.BaseBusiness;
import invictoweb.dao.factory.IDAOFactory;

public class InvictoBusinessFactory {
	
	private final HashMap<String, BaseBusiness> listaBusiness;

	private final IDAOFactory daoFactory;

	public InvictoBusinessFactory(IDAOFactory daoFactory) {
		super();
		this.listaBusiness = new HashMap<>();
		this.daoFactory = daoFactory;
	}

	public <U extends BaseBusiness> U getBusiness(Class<U> clazz) {
		U retorno = getInstance(clazz);
		if (retorno == null) {
			retorno = createInstance(clazz);
		}
		return retorno;
	}

	protected <U extends BaseBusiness> U createInstance(Class<U> clazz) {
		U retorno = null;
		try {
			Constructor<U> construtor = clazz.getDeclaredConstructor(InvictoBusinessFactory.class);
			construtor.setAccessible(true);
			retorno = construtor.newInstance(this);
			if (retorno != null) {
				addInstanceList(clazz.getName(), retorno);
			}
		} catch (Exception e) {
			System.out.println("Error" + e);
		}
		return retorno;
	}

	protected void addInstanceList(String className, BaseBusiness instance) {
		this.listaBusiness.put(className, instance);
	}

	@SuppressWarnings("unchecked")
	protected <U extends BaseBusiness> U getInstance(Class<U> clazz) {
		U retorno = (U) listaBusiness.get(clazz.getName());
		return retorno;
	}

	public IDAOFactory getDAOFactory() {
		return this.daoFactory;
	}
}
