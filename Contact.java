package contactList;

import java.util.ArrayList;

public class Contact implements Comparable<Contact> {
	private String name;
	private String family;
	private String preview;
	private ArrayList<Number> numbers;
	private ArrayList<Mail> mails;
	private ArrayList<OtherData> others;

	public Contact() {
		name = "";
		family = "";
		preview = "";

		numbers = new ArrayList<>();
		mails = new ArrayList<>();
		others = new ArrayList<>();
	}

	public Contact(String name, String family) {

		this.name = name;
		this.family = family;
		preview = "";

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

	void setPreview() {

		if (!name.equals("")) {
			preview = name;
		}

		if (!family.equals("")) {
			if (preview.equals(""))
				preview = family;
			else
				preview += " " + family;
		}

		if (preview.equals("")) {
			if (numbers.size() != 0)
				preview = numbers.get(0).getString();
			else {
				if (mails.size() != 0)
					preview = mails.get(0).getString();
				else {
					if (others.size() != 0)
						preview = others.get(0).getString();
				}
			}
		}
	}

	String getPreview() {
		return this.preview;
	}

	@Override
	public int compareTo(Contact o) {
		return preview.compareTo(o.getPreview());
	}
}