package home.parham.cms.domain.info;

public class Mail implements Info {

	String value;
	String label;

	public Mail() {
		setLabel("");
		setValue("");
	}

	public Mail(String label, String mail) {
		setLabel(label);
		setValue(mail);
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}
}
