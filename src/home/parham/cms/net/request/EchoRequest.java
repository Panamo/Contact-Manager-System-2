package home.parham.cms.net.request;

public class EchoRequest implements Request {

	private String verb;
	private String request;

	@Override
	public void setRequestString(String verb, String request) {
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
