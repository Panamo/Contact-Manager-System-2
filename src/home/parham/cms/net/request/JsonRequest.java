package home.parham.cms.net.request;

import com.google.gson.Gson;

import home.parham.cms.domain.Contact;

public class JsonRequest implements Request {

	private Contact contact;
	private String verb;

	@Override
	public void setRequestString(String verb, String request) {
		this.verb = verb;
		Gson gson = new Gson();
		this.contact = gson.fromJson(request, Contact.class);
	}

	public String getVerb() {
		return verb;
	}

	public Contact getContact() {
		return contact;
	}

}
