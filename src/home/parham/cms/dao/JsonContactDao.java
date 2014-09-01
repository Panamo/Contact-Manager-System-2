package home.parham.cms.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.google.gson.Gson;

import home.parham.cms.controllers.ContactList;

public class JsonContactDao implements ContactDao {

	@Override
	public ContactList read(String path) {
		Gson gson = new Gson();
		ContactList contacts = null;
		try {
			BufferedReader read = new BufferedReader(new InputStreamReader(
					new FileInputStream(path)));
			String contactsString = read.readLine();
			contacts = gson.fromJson(contactsString, ContactList.class);
			read.close();
			return contacts;
		} catch (IOException exception) {
			return contacts;
		}
	}

	@Override
	public void write(ContactList contacts, String path) {
		Gson gson = new Gson();
		String contactsString = gson.toJson(contacts);
		try {
			PrintWriter writer = new PrintWriter(path);
			writer.write(contactsString);
			writer.close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}

	}

}
