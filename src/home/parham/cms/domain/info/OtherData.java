package home.parham.cms.domain.info;

public class OtherData extends Info {

	public OtherData() {
		setLabel("");
		setString("");
	}

	public OtherData(String label, String data) {
		setLabel(label);
		setString(data);
	}
}
