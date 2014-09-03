package home.parham.cms.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import home.parham.cms.controllers.ContactList;

public class JsonContactDao implements ContactDao {

	@Override
	public ContactList read(String path) throws IOException, DaoException {
		Gson gson = new Gson();
		ContactList contacts = null;
		BufferedReader read = new BufferedReader(new InputStreamReader(
				new FileInputStream(path)));
		String contactsString = read.readLine();
		read.close();
		try {
			contacts = gson.fromJson(contactsString, ContactList.class);
		} catch (JsonParseException exception) {
			throw new DaoException(exception);
		}
		return contacts;
	}

	@Override
	public void write(ContactList contacts, String path)
			throws FileNotFoundException {
		Gson gson = new Gson();
		String contactsString = gson.toJson(contacts);
		PrintWriter writer = new PrintWriter(path);
		writer.write(contactsString);
		writer.close();
	}
}
