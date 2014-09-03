package home.parham.cms.net.handler;

import home.parham.cms.controllers.ContactController;
import home.parham.cms.domain.Contact;
import home.parham.cms.net.Request;

import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

public class JsonHandler implements Handler {

	private Request request;
	private PrintWriter writer;

	@Override
	public void run() {
		if (request.getVerb().equalsIgnoreCase("CREATE")) {
			Gson gson = new Gson();
			try {
				Contact contact = gson.fromJson(request.getRequest().trim(),
						Contact.class);
				ContactController.getInstace().buildContact(contact);
			} catch (JsonParseException exception) {
				exception.printStackTrace();
				writer.println("Syntax error : " + exception.getMessage());
				return;
			}
			writer.println("OK");
		} else if (request.getVerb().equalsIgnoreCase("MODIFY")) {

		} else if (request.getVerb().equalsIgnoreCase("DELETE")) {

		} else {
			return;
		}
	}

	@Override
	public void setRequest(Request request, PrintWriter writer) {
		this.writer = writer;
		this.request = request;

	}

}
