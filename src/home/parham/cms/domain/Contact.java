package home.parham.cms.domain;

import home.parham.cms.domain.info.Mail;
import home.parham.cms.domain.info.Number;
import home.parham.cms.domain.info.OtherData;

import java.io.Serializable;
import java.util.ArrayList;

public class Contact implements Comparable<Contact>, Serializable {

	private static final long serialVersionUID = -4305861548474119088L;

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

	public void addToMails(Mail mail) {
		mails.add(mail);
	}

	public void addToNumbers(Number number) {
		numbers.add(number);
	}

	public ArrayList<OtherData> getOthers() {
		return others;
	}

	public void addToOthers(OtherData other) {
		others.add(other);
	}

	public void setPreview() {

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
				preview = numbers.get(0).toString();
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

	public String getPreview() {
		return this.preview;
	}

	public boolean isSearched(String search) {

		if (name.contains(search) || family.contains(search))
			return true;
		for (int i = 0; i < numbers.size(); i++)
			if (numbers.get(i).toString().contains(search))
				return true;
		for (int i = 0; i < mails.size(); i++)
			if (mails.get(i).getString().contains(search))
				return true;
		for (int i = 0; i < others.size(); i++)
			if (others.get(i).getString().contains(search))
				return true;
		return false;
	}

	@Override
	public int compareTo(Contact object) {
		return preview.compareToIgnoreCase(object.getPreview());
	}
}