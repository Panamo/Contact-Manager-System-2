package home.parham.cms.gui;

import home.parham.cms.controllers.ContactList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ShowContactFrame extends JFrame {

	private static final long serialVersionUID = -2485402066416431724L;
	private JPanel contentPane;

	public ShowContactFrame(int i) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 11, 46, 37);
		contentPane.add(lblName);

		JLabel lblname = new JLabel("(name)");
		lblname.setBounds(64, 11, 95, 37);
		contentPane.add(lblname);

		JLabel lblFamily = new JLabel("Family:");
		lblFamily.setBounds(198, 11, 39, 37);
		contentPane.add(lblFamily);

		JLabel lblfamily = new JLabel("(family)");
		lblfamily.setBounds(251, 11, 95, 37);
		contentPane.add(lblfamily);

		ContactList contactList = new ContactList();

		lblname.setText(contactList.get(i).getName());
		lblfamily.setText(contactList.get(i).getFamily());
	}

	public ShowContactFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 11, 46, 37);
		contentPane.add(lblName);

		JLabel lblname = new JLabel("(name)");
		lblname.setBounds(64, 11, 95, 37);
		contentPane.add(lblname);

		JLabel lblFamily = new JLabel("Family:");
		lblFamily.setBounds(198, 11, 39, 37);
		contentPane.add(lblFamily);

		JLabel lblfamily = new JLabel("(family)");
		lblfamily.setBounds(251, 11, 95, 37);
		contentPane.add(lblfamily);
	}
}