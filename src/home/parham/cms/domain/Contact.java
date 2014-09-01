package home.parham.cms.domain;

import home.parham.cms.domain.info.Info;

import java.util.ArrayList;

public class Contact {

	private String name;
	private String family;
	private ArrayList<Info> infos;

	public Contact() {
		this("", "");
	}

	public Contact(String name, String family) {

		this.name = name;
		this.family = family;

		infos = new ArrayList<Info>();
	}

	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	void setFamily(String family) {
		this.family = family;
	}

	public ArrayList<Info> getInfos() {
		return infos;
	}

	public void setInfos(ArrayList<Info> infos) {
		this.infos = infos;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Contact) {
			Contact contact = (Contact) obj;
			if (contact.name == name && contact.family == family) {
				return true;
			} else {
				return false;
			}
		} else {
			throw new UnsupportedOperationException();
		}
	}
}