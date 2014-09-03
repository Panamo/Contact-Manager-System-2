package home.parham.cms.net;

import home.parham.cms.net.handler.Handler;
import home.parham.cms.net.handler.HandlerFactory;
import home.parham.cms.system.FileHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Dispatcher extends Thread {

	private ServerSocket serverSocket;
	private Logger logger;

	public Dispatcher() {
		super("Dispatcher Thread");
		logger = Logger.getLogger(this.getClass());
		FileHandler.loadContactList();
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
				String requestString = "";
				String line;
				while ((line = reader.readLine()).length() != 0) {
					requestString += line + "\n";
				}
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(
						socket.getOutputStream()));
				Request request = new Request(requestVerb, requestString);
				Handler handler = HandlerFactory.getInstance();
				handler.setRequest(request, writer);
				handler.run();
				writer.flush();
				socket.close();
				FileHandler.saveContactList();
			} catch (IOException exception) {
				exception.printStackTrace();
				logger.log(Level.ERROR, "", exception);
			}
		}
	}
}
