package home.parham.cms.domain;

import java.util.ArrayList;
import java.util.UUID;

public class Contact {

	private String name;
	private String family;
	private UUID id;
	private ArrayList<Info> infoes;

	public Contact() {
		this("", "");
	}

	public Contact(String name, String family) {
		this.name = name;
		this.family = family;
		this.id = UUID.randomUUID();
		infoes = new ArrayList<Info>();
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

	public ArrayList<Info> getInfoes() {
		return infoes;
	}

	public void setInfeos(ArrayList<Info> infos) {
		this.infoes = infos;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Contact) {
			Contact contact = (Contact) obj;
			if (contact.id == id) {
				return true;
			} else {
				return false;
			}
		} else {
			throw new UnsupportedOperationException();
		}
	}

}