package home.parham.cms.system;

import java.io.FileNotFoundException;
import java.io.IOException;

import home.parham.cms.conf.ConfigurationHandler;
import home.parham.cms.controllers.ContactController;
import home.parham.cms.dao.DaoException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class FileHandler {
	private static Logger logger = Logger.getLogger(FileHandler.class);

	public static void saveContactList() {
		String path = ConfigurationHandler.getInstance().getConfiguration()
				.getString("ContactDAO-difinition.ContactDaoPath");
		try {
			ContactController.getInstace().save(path);
		} catch (FileNotFoundException | DaoException exception) {
			exception.printStackTrace();
			logger.log(Level.ERROR, "", exception);
		}
	}

	public static void loadContactList() {
		String path = ConfigurationHandler.getInstance().getConfiguration()
				.getString("ContactDAO-difinition.ContactDaoPath");
		try {
			ContactController.getInstace().load(path);
		} catch (IOException | DaoException exception) {
			exception.printStackTrace();
			logger.log(Level.ERROR, "", exception);
		}
	}
}
