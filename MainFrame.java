package contactList;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.SystemColor;
import java.util.Vector;

import javax.swing.JTextField;

import javax.swing.JList;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
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
				NewContactFrame newFrame = new NewContactFrame();
				newFrame.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 11, 41, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(61, 12, 270, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		ContactList contactList = new ContactList();
		
		Vector listData = new Vector();
		for(int i = 0; i < contactList.getContact().size(); i++){
			listData.add(contactList.getContact().get(i).getPreview());
		}
		
		
		JList list = new JList(listData);
		list.setBounds(61, 38, 270, 312);
		contentPane.add(list);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = textField.getText();
				if (!text .equals("")){
					listData.clear();
					ArrayList<Contact> searchResult = contactList.search(text);
					for (int i = 0; i<searchResult.size(); i++){
						listData.add(searchResult.get(i).getPreview());
					}
					
					list.setListData(listData);
					contentPane.revalidate();
					contentPane.repaint();
				}
				else {
					listData.clear();
					for(int i = 0; i < contactList.getContact().size(); i++){
						listData.add(contactList.getContact().get(i).getPreview());
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
				String preview = (String)listData.get(list.getSelectedIndex());
				for(int i = 0; i < contactList.getContact().size(); i++){
					if (contactList.getContact().get(i).getPreview().equals(preview)){
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
