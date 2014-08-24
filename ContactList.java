package contactList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {

	static ArrayList<Contact> contact;
	File file;
	ArrayList<String> lineStringArr;

	public ContactList() {
		contact = new ArrayList<>();
		file = new File("Contact.txt");
	}

	public ArrayList<Contact> getContact() {
		return contact;
	}

	void addToContact(Contact contact) {
		this.contact.add(contact);
	}

	void readeFile() {

		try {
			RandomAccessFile fi = new RandomAccessFile(file, "r");
			Scanner read = new Scanner(file);
			lineStringArr = new ArrayList<>();
			while (read.hasNext())
				lineStringArr.add(read.nextLine());
			for (int i = 0; i < lineStringArr.size(); i++) {
				if (lineStringArr.get(i).equals("{")) {
					System.out.println(i);
					i = setContactLines(i);
					System.out.println(i);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private int setContactLines(int n) {

		ArrayList<String> contactString = new ArrayList<>();
		int i;
		for (i = n + 1; i < lineStringArr.size(); i++) {
			if (!lineStringArr.get(i).equals("}")) {
				contactString.add(lineStringArr.get(i));
			}
			if (lineStringArr.get(i).equals("}")) {
				addToContacts(contactString);
				break;
			}
		}
		return i;
	}

	private void addToContacts(ArrayList<String> contactString) {

		System.out.println(contactString);

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
		addToContact(c);
	}

	public void listWriter() {
		File file = new File("Contact.txt");
		FileWriter fw;
		for (int i = 0; i < contact.size(); i++) {
			try {
				fw = new FileWriter(file, false);

				fw.write("{\n");
				fw.write("name " + contact.get(i).name);
				fw.write("\nfamily " + contact.get(i).family);

				for (int j = 0; j < contact.get(i).numbers.size(); j++) {
					fw.write("\nnumber "
							+ contact.get(i).numbers.get(j).getLabel() + " "
							+ contact.get(i).numbers.get(j).getString());
				}

				for (int j = 0; j < contact.get(i).mails.size(); j++) {
					fw.write("\nmail " + contact.get(i).mails.get(j).getLabel()
							+ " " + contact.get(i).mails.get(j).getString());
				}

				for (int j = 0; j < contact.get(i).others.size(); j++) {
					fw.write("\ndata "
							+ contact.get(i).others.get(j).getLabel() + " "
							+ contact.get(i).others.get(j).getString());
				}

				fw.write("\n}\n");

				fw.close();
			} catch (IOException e) {
				System.out.println("Unable to write on file:" + file.toString());
			}
		}
	}

}