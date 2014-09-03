package home.parham.cms.net.handler;

import home.parham.cms.net.Request;

import java.io.PrintWriter;

public class EchoHandler implements Handler {

	private PrintWriter writer;
	private Request request;

	@Override
	public void run() {
		writer.write("Hello.... " + request.getVerb() + " : "
				+ request.getRequest());
	}

	@Override
	public void setRequest(Request request, PrintWriter writer) {
		this.writer = writer;
		this.request = request;
	}

}
