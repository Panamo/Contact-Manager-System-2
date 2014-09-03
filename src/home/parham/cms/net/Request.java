package home.parham.cms.net;

public class Request {

	private String verb;
	private String request;

	public Request(String verb, String request) {
		this.verb = verb;
		this.request = request;
	}

	public String getVerb() {
		return verb;
	}

	public String getRequest() {
		return request;
	}

}
