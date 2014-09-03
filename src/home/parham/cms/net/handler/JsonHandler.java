package home.parham.cms.net.handler;

import home.parham.cms.controllers.ContactController;
import home.parham.cms.net.request.JsonRequest;
import home.parham.cms.net.request.Request;

import java.io.PrintWriter;

import javax.naming.OperationNotSupportedException;

public class JsonHandler implements Handler {

	private JsonRequest request;
	private PrintWriter writer;
	
	@Override
	public void run() {
		if (request.getVerb().equalsIgnoreCase("CREATE")) {
			ContactController.getInstace().buildContact(request.getContact());
			writer.println("OK");
		} else if (request.getVerb().equalsIgnoreCase("MODIFY")) {

		} else if (request.getVerb().equalsIgnoreCase("DELETE")) {

		} else {
			return;
		}
	}

	@Override
	public void setRequest(Request request, PrintWriter writer)
			throws OperationNotSupportedException {
		this.writer = writer;
		if (request instanceof JsonRequest) {
			this.request = (JsonRequest) request;
		} else {
			throw new OperationNotSupportedException(
					"Must use JsonRequest with this handler");
		}
	}

}
