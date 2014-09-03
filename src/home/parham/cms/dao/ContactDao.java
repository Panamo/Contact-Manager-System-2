package home.parham.cms.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import home.parham.cms.controllers.ContactList;

public interface ContactDao {
	ContactList read(String path) throws IOException, DaoException;

	void write(ContactList contacts, String path) throws FileNotFoundException,
			DaoException;
}
