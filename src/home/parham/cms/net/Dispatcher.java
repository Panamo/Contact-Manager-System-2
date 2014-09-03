package home.parham.cms.net;

import home.parham.cms.controllers.ContactController;
import home.parham.cms.net.handler.Handler;
import home.parham.cms.net.handler.HandlerFactory;
import home.parham.cms.net.request.Request;
import home.parham.cms.net.request.RequestFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.naming.OperationNotSupportedException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Dispatcher extends Thread {

	private ServerSocket serverSocket;
	private Logger logger;

	public Dispatcher() {
		super("Dispatcher Thread");
		ContactController.getInstace().load("contact.xml");
		logger = Logger.getLogger(this.getClass());
		try {
			serverSocket = new ServerSocket(1373);
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				String requestVerb = reader.readLine();
				String requestString = reader.readLine();
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(
						socket.getOutputStream()));
				Request request = RequestFactory.getInstance();
				request.setRequestString(requestVerb, requestString);
				Handler handler = HandlerFactory.getInstance();
				handler.setRequest(request, writer);
				handler.run();
				writer.flush();
				socket.close();
			} catch (IOException | OperationNotSupportedException exception) {
				exception.printStackTrace();
				logger.log(Level.ERROR, "", exception);
			}
		}
	}
}
