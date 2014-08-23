package contactList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {

	ArrayList<Contact> contact;
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

}