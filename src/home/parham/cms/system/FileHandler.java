package home.parham.cms.system;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileHandler {

	private static FileHandler instance;

	public static FileHandler getInstance() {
		if (instance == null) {
			instance = new FileHandler();
		}
		return instance;
	}

	private FileHandler() {
	}

	public void readContacts(String path) {
		try {
			BufferedReader read = new BufferedReader(new InputStreamReader(
					new FileInputStream(path)));
			ArrayList<String> lineStringArr = new ArrayList<>();
			String line;
			while ((line = read.readLine()) != null) {
				lineStringArr.add(line);
			}
			for (int i = 0; i < lineStringArr.size(); i++) {
				if (lineStringArr.get(i).equals("{")) {
//					 i = setContactLines(i);
				}
			}
			read.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	private int setContactLines(int n) {
//		ArrayList<String> contactString = new ArrayList<>();
//		int i;
//		for (i = n + 1; i < lineStringArr.size(); i++) {
//			if (!lineStringArr.get(i).equals("}")) {
//				contactString.add(lineStringArr.get(i));
//			}
//			if (lineStringArr.get(i).equals("}")) {
//				addContact(contactString);
//				break;
//			}
//		}
//		return i;
//	}

}
