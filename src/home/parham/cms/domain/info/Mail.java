package home.parham.cms.domain.info;

public class Mail extends Info {

	public Mail() {
		setLabel("");
		setString("");
	}

	public Mail(String label, String mail) {
		setLabel(label);
		setString(mail);
	}
}
