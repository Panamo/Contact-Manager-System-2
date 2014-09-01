package home.parham.cms.controllers;

import home.parham.cms.dao.ContactDaoFactory;
import home.parham.cms.domain.Contact;

import java.util.Iterator;

public class ContactController implements Iterable<Contact> {
	private static ContactController instance;

	private ContactList contacts;

	public static ContactController getInstace() {
		if (instance == null) {
			instance = new ContactController();
		}
		return instance;
	}

	private ContactController() {
		contacts = new ContactList();
	}

	public void save(String path) {
		ContactDaoFactory.getInstance().write(contacts, path);
	}

	public void load(String path) {
		contacts = ContactDaoFactory.getInstance().read(path);
	}

	public void buildContact(Contact contact) {
		contacts.add(contact);
	}

	@Override
	public Iterator<Contact> iterator() {
		return contacts.iterator();
	}

}
