package home.parham.cms.gui;

import home.parham.cms.controllers.ContactList;
import home.parham.cms.domain.Contact;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = -5539260990965127487L;

	private JPanel contentPane;
	private JTextField textField;

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 400);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewContactDialog newFrame = new NewContactDialog();
				newFrame.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 11, 41, 23);
		contentPane.add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(61, 12, 270, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		final ContactList contactList = new ContactList();

		final Vector<String> listData = new Vector<>();
		for (int i = 0; i < contactList.size(); i++) {
			listData.add(contactList.get(i).getPreview());
		}

		final JList<String> list = new JList<>(listData);
		list.setBounds(61, 38, 270, 312);
		contentPane.add(list);

		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				if (!text.equals("")) {
					listData.clear();
					ArrayList<Contact> searchResult = contactList.search(text);
					for (int i = 0; i < searchResult.size(); i++) {
						listData.add(searchResult.get(i).getPreview());
					}

					list.setListData(listData);
					contentPane.revalidate();
					contentPane.repaint();
				} else {
					listData.clear();
					for (int i = 0; i < contactList.size(); i++) {
						listData.add(contactList.get(i).getPreview());
					}
					list.setListData(listData);
					contentPane.revalidate();
					contentPane.repaint();
				}

			}
		});
		btnNewButton_1.setBounds(341, 11, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String preview = (String) listData.get(list.getSelectedIndex());
				for (int i = 0; i < contactList.size(); i++) {
					if (contactList.get(i).getPreview().equals(preview)) {
						ShowContactFrame show = new ShowContactFrame(i);
						show.setVisible(true);
						break;
					}
				}
			}
		});
		btnShow.setBounds(341, 63, 89, 23);
		contentPane.add(btnShow);

		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(341, 327, 89, 23);
		contentPane.add(btnNewButton_2);

	}
}