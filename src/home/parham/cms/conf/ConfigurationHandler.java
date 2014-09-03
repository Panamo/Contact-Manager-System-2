package home.parham.cms.conf;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.FileConfiguration;
import org.apache.commons.configuration.XMLConfiguration;

public class ConfigurationHandler {

	private static ConfigurationHandler instance;

	private XMLConfiguration configuration;

	public static ConfigurationHandler getInstance() {
		if (instance == null) {
			instance = new ConfigurationHandler();
		}
		return instance;
	}

	private ConfigurationHandler() {
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
