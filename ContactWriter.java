package ContactList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ContactWriter {

	private Contact contact;

	public ContactWriter(Contact contact) {
		this.contact = contact;
	}

	public void write() {

		File file = new File("Contact.txt");
		FileWriter fw;

		try {
			fw = new FileWriter(file, true);

			fw.write("{\n");
			fw.write("name " + contact.name);
			fw.write("\nfamily " + contact.family);

			for (int i = 0; i < contact.numbers.size(); i++) {
				fw.write("\nnumber " + contact.numbers.get(i).getLabel() + " "
						+ contact.numbers.get(i).getString());
			}
			
			for (int i = 0;i < contact.mails.size() ; i++){
				fw.write("\nmail " + contact.mails.get(i).getLabel() + " "
						+ contact.mails.get(i).getString());
			}
			
			for (int i = 0;i < contact.others.size() ; i++){
				fw.write("\ndata " + contact.others.get(i).getLabel() + " "
						+ contact.others.get(i).getString());
			}
			
			fw.write("\n}\n");
			
			fw.close();
		} catch (IOException e) {
			System.out.println("Unable to wite on file:" + file.toString());
		}
	}
}
