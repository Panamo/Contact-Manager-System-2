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
					i = setContactLines(i);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private int setContactLines(int n) {

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

	private void addToContacts(ArrayList<String> contactString) {

		String[] stringArray;

		Contact c = new Contact(contactString.get(0).split(" ")[1], contactString.get(1).split(" ")[1]);

		if (contactString.size() > 2) {
			for (int i = 2; i < contactString.size(); i++) {
				stringArray = contactString.get(i).split(" ");

				if (stringArray[0].equals("number")) {
					c.addToNumbers(new Number(stringArray[1], stringArray[2]));
				}
				if (stringArray[0].equals("mail")) {
					c.addToMails(new Mail(stringArray[1], stringArray[2]));
				}
				if (stringArray[0].equals("data")) {
					String data = "";
					for (int j = 2; j < stringArray.length; j++) {
						data += stringArray[j];
						if (j != stringArray.length - 1)
							data += " ";
					}
					c.addToOthers(new OtherData(stringArray[1], data));
				}
			}
		}
		
		addToContact(c);
	}
	
	public void write(Contact contact) {

		FileWriter fw;

		try {
			fw = new FileWriter(file, true);

			fw.write("{\n");
			fw.write("name " + contact.name);
			fw.write("\nfamily " + contact.family);

			for (int i = 0; i < contact.numbers.size(); i++) {
				fw.write("\nnumber " + contact.numbers.get(i).getLabel() + " "
						+ contact.numbers.get(i).getString());
			}
			
			for (int i = 0;i < contact.mails.size() ; i++){
				fw.write("\nmail " + contact.mails.get(i).getLabel() + " "
						+ contact.mails.get(i).getString());
			}
			
			for (int i = 0;i < contact.others.size() ; i++){
				fw.write("\ndata " + contact.others.get(i).getLabel() + " "
						+ contact.others.get(i).getString());
			}
			
			fw.write("\n}\n");
			
			fw.close();
		} catch (IOException e) {
			System.out.println("Unable to wite on file:" + file.toString());
		}
	}
}