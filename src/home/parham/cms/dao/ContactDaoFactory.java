package home.parham.cms.dao;

import home.parham.cms.conf.ConfigurationHandler;

public class ContactDaoFactory {

	public static ContactDao getInstance() {
		String contactDaoClass = ConfigurationHandler.getInstance()
				.getConfiguration()
				.getString("ContactDAO-difinition.ContactDaoClass");
		if (contactDaoClass == null) {
			return new JsonContactDao();
		}
		try {
			Class<?> clazz = Class.forName(contactDaoClass);
			return (ContactDao) clazz.newInstance();
		} catch (ClassNotFoundException | IllegalAccessException
				| ClassCastException | InstantiationException exception) {
			exception.printStackTrace();
			return new JsonContactDao();
		}
	}

	private ContactDaoFactory() {
	}
}
