package home.parham.cms.domain.info;

public class Number extends Info {

	public Number() {
		setLabel("");
		setString("");
	}

	public Number(String label, String number) {
		setLabel(label);
		setString(number);
	}
}
