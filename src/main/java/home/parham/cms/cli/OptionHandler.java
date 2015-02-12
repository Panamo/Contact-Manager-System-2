package home.parham.cms.cli;

import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class OptionHandler {
	private Options options;

	public OptionHandler() {
		options = new Options();
	}

	public void addOption(Option option) {
		options.addOption(option);
	}
}
