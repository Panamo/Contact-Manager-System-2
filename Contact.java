package contactList;

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
	
	public ArrayList<Number> getFields() {
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
}
