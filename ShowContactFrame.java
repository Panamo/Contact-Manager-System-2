package contactList;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ShowContactFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowContactFrame frame = new ShowContactFrame();
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
		contactList.reader();
		contactList.sort();
		
		lblname.setText(contactList.getContact().get(i).getName());
		lblfamily.setText(contactList.getContact().get(i).getFamily());
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
