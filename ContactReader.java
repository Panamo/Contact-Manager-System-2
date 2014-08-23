package contactList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactReader {

	File contacts;
	ArrayList<String> lineStringArr;
	ContactList contactList;

	private ContactReader(ContactList contactList) {

		contacts = new File("contacts");
		this.contactList = contactList;
	}

	void fileReader() {

		try {
			RandomAccessFile fi = new RandomAccessFile(contacts, "r");
			Scanner read = new Scanner(contacts);
			lineStringArr = new ArrayList<>();
			while (read.hasNext())
				lineStringArr.add(read.nextLine());
			for (int i = 0; i < lineStringArr.size(); i++) {
				if (lineStringArr.get(i).equals("{")) {
					i = setContactLines(i);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	int setContactLines(int n) {
		// TODO
		ArrayList<String> contactString = new ArrayList<>();
		
		for (int i = n; i < lineStringArr.size(); i++) {
			if (!lineStringArr.get(i).equals("}"))
				contactString.add(lineStringArr.get(i));
			else
				addToContacts(contactString);
				return i + 1;
		}
		return 0;
	}

	void addToContacts(ArrayList<String> s) {

		String[] sA;

		Contact c = new Contact(s.get(0).split(" ")[1], s.get(1).split(" ")[1]);

		if (s.size() > 2) {
			for (int i = 2; i < s.size(); i++) {
				sA = s.get(i).split(" ");

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
		
		contactList.addToContact(c);
	}
}
