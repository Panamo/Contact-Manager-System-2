package contactList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ContactList {

	private ArrayList<Contact> contacts;
	private File file;
	private ArrayList<String> lineStringArr;

	public ContactList() {
		contacts = new ArrayList<>();
		file = new File("Contact.txt");

		read();
		sort();
	}

	Thread tReader = new Thread(new Runnable() {

		@Override
		public void run() {

			try {
				RandomAccessFile fi = new RandomAccessFile(file, "r");
				Scanner read = new Scanner(file);
				lineStringArr = new ArrayList<>();
				while (read.hasNext())
					lineStringArr.add(read.nextLine());
				for (int i = 0; i < lineStringArr.size(); i++) {
					if (lineStringArr.get(i).equals("{")) {
						i = setContactLines(i);
					}
				}
				fi.close();
				read.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			genPreview();
		}
	});

	Thread tWriter = new Thread(new Runnable() {

		@Override
		public void run() {

			FileWriter fw;

			try {
				fw = new FileWriter(file, false);

				for (int i = 0; i < contacts.size(); i++) {

					fw.write("{\n");
					fw.write("name " + contacts.get(i).getName());
					fw.write("\nfamily " + contacts.get(i).getFamily());

					for (int j = 0; j < contacts.get(i).getNumbers().size(); j++) {
						fw.write("\nnumber "
								+ contacts.get(i).getNumbers().get(j)
										.getLabel()
								+ " "
								+ contacts.get(i).getNumbers().get(j)
										.getString());
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
								+ contacts.get(i).getOthers().get(j)
										.getString());
					}

					fw.write("\n}\n");
				}

				fw.close();
			} catch (IOException e) {
				System.out.println("Unable to write on file:" + file.toString());
			}
		}
	});

	void read() {

		tReader.start();
	}
	
	public void write() {

		tWriter.start();
	}
	
	public ArrayList<Contact> getContact() {
		return contacts;
	}

	void addToContacts(Contact contact) {
		contacts.add(contact);
	}

	private int setContactLines(int n) {

		ArrayList<String> contactString = new ArrayList<>();
		int i;
		for (i = n + 1; i < lineStringArr.size(); i++) {
			if (!lineStringArr.get(i).equals("}")) {
				contactString.add(lineStringArr.get(i));
			}
			if (lineStringArr.get(i).equals("}")) {
				addContact(contactString);
				break;
			}
		}
		return i;
	}

	private void addContact(ArrayList<String> contactString) {

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
		addToContacts(c);
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
}