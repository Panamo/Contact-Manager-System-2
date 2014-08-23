package contactList;

import java.util.ArrayList;

public class Contact {

	String name;
	String family;
	
	ArrayList<Field> numbers;
	ArrayList<Mail> mails;
	ArrayList<OtherData> others;
	
	public Contact() {
		name = "";
		family = "";
		
		fields = new ArrayList<>();
		mails = new ArrayList<>();
		others = new ArrayList<>()
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
	
	public ArrayList<Field> getFields() {
		return fields;
	}
	
	public ArrayList<Mail> getMails() {
		return mails;
	}
	
	void addToMails(Mail mail) {
		mails.add(mail);
	}
	
	void addToFields(Field field) {
		fields.add(field);
	}
	
	public ArrayList<OtherData> getOthers() {
		return others;
	}
	
	void addToOthers(OtherData other) {
		others.add(other);
	}
}
