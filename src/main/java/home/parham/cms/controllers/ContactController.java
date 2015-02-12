package home.parham.cms.controllers;

import home.parham.cms.dao.ContactDaoFactory;
import home.parham.cms.dao.DaoException;
import home.parham.cms.domain.Contact;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class ContactController implements Iterable<Contact> {
	private static ContactController instance;

	private Logger logger;
	private ContactList contacts;

	public static ContactController getInstace() {
		if (instance == null) {
			instance = new ContactController();
		}
		return instance;
	}

	private ContactController() {
		contacts = new ContactList();
		logger = Logger.getLogger(this.getClass());
	}

	public void save(String path) throws FileNotFoundException, DaoException {
		ContactDaoFactory.getInstance().write(contacts, path);
	}

	public void load(String path) throws IOException, DaoException {
		ContactList contacts = ContactDaoFactory.getInstance().read(path);
		if (contacts == null) {
			logger.log(Level.DEBUG, path + " not loaded.");
		} else {
			logger.log(Level.DEBUG, "contacts update.");
			this.contacts = contacts;
		}

	}

	public void buildContact(Contact contact) {
		contacts.add(contact);
	}

	@Override
	public Iterator<Contact> iterator() {
		return contacts.iterator();
	}

}
