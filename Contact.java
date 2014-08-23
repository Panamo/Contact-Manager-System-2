package ContactList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Contact {
	String name;
	String family;

	ArrayList<Number> numbers;
	ArrayList<Mail> mails;
	ArrayList<OtherData> others;

	public Contact() {
		name = "";
		family = "";

		numbers = new ArrayList<>();
		mails = new ArrayList<>();
		others = new ArrayList<>();
	}

	public Contact(String name, String family) {

		this.name = name;
		this.family = family;

		numbers = new ArrayList<>();
		mails = new ArrayList<>();
		others = new ArrayList<>();
	}

	void setName(String name) {
		this.name = name;
	}

	void setFamily(String family) {
		this.family = family;
	}

	public String getName() {
		return name;
	}

	public String getFamily() {
		return family;
	}

	public ArrayList<Number> getNumbers() {
		return numbers;
	}

	public ArrayList<Mail> getMails() {
		return mails;
	}

	void addToMails(Mail mail) {
		mails.add(mail);
	}

	void addToNumbers(Number number) {
		numbers.add(number);
	}

	public ArrayList<OtherData> getOthers() {
		return others;
	}

	void addToOthers(OtherData other) {
		others.add(other);
	}
	
	public void write() {
		File file = new File("Contact.txt");
		FileWriter fw;

		try {
			fw = new FileWriter(file, true);

			fw.write("{\n");
			fw.write("name " + this.name);
			fw.write("\nfamily " + this.family);

			for (int i = 0; i < this.numbers.size(); i++) {
				fw.write("\nnumber " + this.numbers.get(i).getLabel() + " "
						+ this.numbers.get(i).getString());
			}
			
			for (int i = 0;i < this.mails.size() ; i++){
				fw.write("\nmail " + this.mails.get(i).getLabel() + " "
						+ this.mails.get(i).getString());
			}
			
			for (int i = 0;i < this.others.size() ; i++){
				fw.write("\ndata " + this.others.get(i).getLabel() + " "
						+ this.others.get(i).getString());
			}
			
			fw.write("\n}\n");
			
			fw.close();
		} catch (IOException e) {
			System.out.println("Unable to write on file:" + file.toString());
		}
		
		ContactList.contact.add(this);
	}

}
