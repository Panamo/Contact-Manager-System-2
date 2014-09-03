package home.parham.cms.net.handler;

import home.parham.cms.net.Request;

import java.io.PrintWriter;

public interface Handler extends Runnable {
	void setRequest(Request request, PrintWriter writer);
}
