package home.parham.cms.net.handler;

import home.parham.cms.net.request.EchoRequest;
import home.parham.cms.net.request.Request;

import java.io.PrintWriter;

import javax.naming.OperationNotSupportedException;

public class EchoHandler implements Handler {

	private PrintWriter writer;
	private EchoRequest request;

	@Override
	public void run() {
		writer.write("Hello.... " + request.getVerb() + " : "
				+ request.getRequest());
	}

	@Override
	public void setRequest(Request request, PrintWriter writer)
			throws OperationNotSupportedException {
		this.writer = writer;
		if (request instanceof EchoRequest) {
			this.request = (EchoRequest) request;
		} else {
			throw new OperationNotSupportedException(
					"Must use EchoRequest with this handler");
		}
	}

}
