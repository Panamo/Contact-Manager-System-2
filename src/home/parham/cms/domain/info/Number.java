package home.parham.cms.domain.info;

public class Number implements Info {

	String label;
	String value;

	public Number() {
		setLabel("");
		setValue("");
	}

	public Number(String label, String number) {
		setLabel(label);
		setValue(number);
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
