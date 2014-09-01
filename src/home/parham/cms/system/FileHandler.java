package home.parham.cms.system;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.FileConfiguration;
import org.apache.commons.configuration.XMLConfiguration;

public class FileHandler {

	private static FileHandler instance;

	private XMLConfiguration configuration;

	public static FileHandler getInstance() {
		if (instance == null) {
			instance = new FileHandler();
		}
		return instance;
	}

	private FileHandler() {
		try {
			configuration = new XMLConfiguration("conf.xml");
		} catch (ConfigurationException e) {
			e.printStackTrace();
			configuration = null;
		}
	}

	public FileConfiguration getConfiguration() {
		return configuration;
	}
}
