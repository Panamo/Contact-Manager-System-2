package home.parham.cms.net.handler;

import home.parham.cms.conf.ConfigurationHandler;

public class HandlerFactory {

	public static Handler getInstance() {
		String handlerClass = ConfigurationHandler.getInstance()
				.getConfiguration().getString("net-difinition.HandlerClass");
		if (handlerClass == null) {
			return new JsonHandler();
		}
		try {
			Class<?> clazz = Class.forName(handlerClass);
			return (Handler) clazz.newInstance();
		} catch (ClassNotFoundException | IllegalAccessException
				| ClassCastException | InstantiationException exception) {
			exception.printStackTrace();
			return new JsonHandler();
		}
	}

	private HandlerFactory() {
	}
}
