package home.parham.cms.dao;

import home.parham.cms.controllers.ContactList;

public interface ContactDao {
	ContactList read(String path);

	void write(ContactList contacts, String path);
}
