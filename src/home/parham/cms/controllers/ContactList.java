package home.parham.cms.controllers;

import home.parham.cms.domain.Contact;
import home.parham.cms.domain.info.Mail;
import home.parham.cms.domain.info.Number;
import home.parham.cms.domain.info.OtherData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ContactList implements List<Contact> {

	private ArrayList<Contact> contacts;

	public ContactList() {
		contacts = new ArrayList<>();
	}

	private boolean addContact(ArrayList<String> contactString) {

		String[] sA;

		String name = "";
		String family = "";

		sA = contactString.get(0).split(" ");

		if (sA.length > 1)
			name = sA[1];

		sA = contactString.get(1).split(" ");

		if (sA.length > 1)
			family = sA[1];

		Contact c = new Contact(name, family);

		if (contactString.size() > 2) {
			for (int i = 2; i < contactString.size(); i++) {
				sA = contactString.get(i).split(" ");

				if (sA[0].equals("number")) {
					c.addToNumbers(new Number(sA[1], sA[2]));
				}
				if (sA[0].equals("mail")) {
					c.addToMails(new Mail(sA[1], sA[2]));
				}
				if (sA[0].equals("data")) {
					String data = "";
					for (int j = 2; j < sA.length; j++) {
						data += sA[j];
						if (j != sA.length - 1)
							data += " ";
					}
					c.addToOthers(new OtherData(sA[1], data));
				}
			}
		}
		return add(c);
	}

	public void write() {
		File file = new File("Contact.txt");
		FileWriter fw;

		try {
			fw = new FileWriter(file, false);

			for (int i = 0; i < contacts.size(); i++) {

				fw.write("{\n");
				fw.write("name " + contacts.get(i).getName());
				fw.write("\nfamily " + contacts.get(i).getFamily());

				for (int j = 0; j < contacts.get(i).getNumbers().size(); j++) {
					fw.write("\nnumber "
							+ contacts.get(i).getNumbers().get(j).getLabel()
							+ " "
							+ contacts.get(i).getNumbers().get(j).getString());
				}

				for (int j = 0; j < contacts.get(i).getMails().size(); j++) {
					fw.write("\nmail "
							+ contacts.get(i).getMails().get(j).getLabel()
							+ " "
							+ contacts.get(i).getMails().get(j).getString());
				}

				for (int j = 0; j < contacts.get(i).getOthers().size(); j++) {
					fw.write("\ndata "
							+ contacts.get(i).getOthers().get(j).getLabel()
							+ " "
							+ contacts.get(i).getOthers().get(j).getString());
				}

				fw.write("\n}\n");
			}

			fw.close();
		} catch (IOException e) {
			System.out.println("Unable to write on file:" + file.toString());
		}
	}

	void genPreview() {
		for (int i = 0; i < contacts.size(); i++) {
			contacts.get(i).setPreview();
		}
	}

	void sort() {
		Collections.sort(contacts);
	}

	ArrayList<Contact> search(String search) {
		ArrayList<Contact> searched = new ArrayList<>();

		for (int i = 0; i < contacts.size(); i++)
			if (contacts.get(i).isSearched(search))
				searched.add(contacts.get(i));

		return searched;
	}

	@Override
	public boolean add(Contact contact) {
		return contacts.add(contact);
	}

	public boolean add(ArrayList<String> contactString) {
		return addContact(contactString);
	}

	@Override
	public void add(int index, Contact contact) {
		contacts.add(index, contact);
	}

	@Override
	public boolean addAll(Collection<? extends Contact> collection) {
		return contacts.addAll(collection);
	}

	@Override
	public boolean addAll(int index, Collection<? extends Contact> collection) {
		return contacts.addAll(index, collection);
	}

	@Override
	public void clear() {
		contacts.clear();
	}

	@Override
	public boolean contains(Object object) {
		return contacts.contains(object);
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		return contacts.containsAll(collection);
	}

	@Override
	public Contact get(int index) {
		return contacts.get(index);
	}

	@Override
	public int indexOf(Object object) {
		return contacts.indexOf(object);
	}

	@Override
	public boolean isEmpty() {
		return contacts.isEmpty();
	}

	@Override
	public Iterator<Contact> iterator() {
		return contacts.iterator();
	}

	@Override
	public int lastIndexOf(Object object) {
		return contacts.lastIndexOf(object);
	}

	@Override
	public ListIterator<Contact> listIterator() {
		return contacts.listIterator();
	}

	@Override
	public ListIterator<Contact> listIterator(int index) {
		return contacts.listIterator(index);
	}

	@Override
	public boolean remove(Object object) {
		return contacts.remove(object);
	}

	@Override
	public Contact remove(int index) {
		return contacts.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		return contacts.removeAll(collection);
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		return contacts.retainAll(collection);
	}

	@Override
	public Contact set(int index, Contact contact) {
		return contacts.set(index, contact);
	}

	@Override
	public int size() {
		return contacts.size();
	}

	@Override
	public List<Contact> subList(int fromIndex, int toIndex) {
		return contacts.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return contacts.toArray();
	}

	@Override
	public <T> T[] toArray(T[] array) {
		return contacts.toArray(array);
	}
}