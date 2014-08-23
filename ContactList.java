package contactList;

import java.util.ArrayList;

public class ContactList {

	static ArrayList<Contact> contact;

	public ContactList() {
		contact = new ArrayList<>();
	}

	public ArrayList<Contact> getContact() {
		return contact;
	}

	void addToContact(Contact contact) {
		this.contact.add(contact);
	}
}