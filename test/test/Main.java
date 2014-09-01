package test;

import home.parham.cms.controllers.ContactController;
import home.parham.cms.gui.MainFrame;

public class Main {
	public static void main(String[] args) {
		new MainFrame().setVisible(true);
		ContactController.getInstace().load("contacts.txt");
	}
}
