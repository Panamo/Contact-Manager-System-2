package home.parham.cms.net.handler;

import java.io.PrintWriter;

import javax.naming.OperationNotSupportedException;

import home.parham.cms.net.request.Request;

public interface Handler extends Runnable {
	void setRequest(Request request, PrintWriter writer)
			throws OperationNotSupportedException;
}
