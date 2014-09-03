package home.parham.cms.net.request;

import home.parham.cms.conf.ConfigurationHandler;

public class RequestFactory {

	public static Request getInstance() {
		String requestClass = ConfigurationHandler.getInstance()
				.getConfiguration().getString("net-difinition.RequestClass");
		if (requestClass == null) {
			return new JsonRequest();
		}
		try {
			Class<?> clazz = Class.forName(requestClass);
			return (Request) clazz.newInstance();
		} catch (ClassNotFoundException | IllegalAccessException
				| ClassCastException | InstantiationException exception) {
			exception.printStackTrace();
			return new JsonRequest();
		}
	}

	private RequestFactory() {
	}
}
