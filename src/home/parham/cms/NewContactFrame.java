package home.parham.cms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class NewContactFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField textField_1;
	private JLabel lblNumber;
	private JTextField txtLabel;
	private JTextField txtNumber;
	private JTextField txtLabel_1;
	private JTextField txtNumber_1;
	private JTextField txtLabel_2;
	private JTextField txtNumber_2;
	private JTextField txtLabel_3;
	private JTextField txtLabel_4;
	private JTextField txtLabel_5;
	private JTextField txtEmail;
	private JTextField txtEmail_1;
	private JTextField txtEmail_2;
	private JLabel lblOtherDatas;
	private JTextField txtLabel_6;
	private JTextField txtData;
	private JTextField txtLabel_7;
	private JTextField txtData_1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewContactFrame frame = new NewContactFrame();
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
	public NewContactFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 493, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First name:");
		lblNewLabel.setBounds(10, 11, 67, 32);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(88, 17, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Family:");
		lblNewLabel_1.setBounds(184, 11, 58, 32);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(252, 17, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNumber = new JLabel("Numbers:");
		lblNumber.setBounds(10, 55, 58, 32);
		contentPane.add(lblNumber);
		
		txtLabel = new JTextField();
		txtLabel.setText("Label");
		txtLabel.setBounds(10, 98, 58, 20);
		contentPane.add(txtLabel);
		txtLabel.setColumns(10);
		
		txtNumber = new JTextField();
		txtNumber.setText("Number");
		txtNumber.setBounds(106, 98, 102, 20);
		contentPane.add(txtNumber);
		txtNumber.setColumns(10);
		
		txtLabel_1 = new JTextField();
		txtLabel_1.setText("Label");
		txtLabel_1.setBounds(10, 129, 58, 20);
		contentPane.add(txtLabel_1);
		txtLabel_1.setColumns(10);
		
		txtNumber_1 = new JTextField();
		txtNumber_1.setText("Number");
		txtNumber_1.setBounds(106, 129, 102, 20);
		contentPane.add(txtNumber_1);
		txtNumber_1.setColumns(10);
		
		txtLabel_2 = new JTextField();
		txtLabel_2.setText("Label");
		txtLabel_2.setBounds(10, 160, 58, 20);
		contentPane.add(txtLabel_2);
		txtLabel_2.setColumns(10);
		
		txtNumber_2 = new JTextField();
		txtNumber_2.setText("Number");
		txtNumber_2.setBounds(106, 160, 102, 20);
		contentPane.add(txtNumber_2);
		txtNumber_2.setColumns(10);
		
		JLabel lblEmails = new JLabel("Emails:");
		lblEmails.setBounds(233, 55, 76, 32);
		contentPane.add(lblEmails);
		
		txtLabel_3 = new JTextField();
		txtLabel_3.setText("Label");
		txtLabel_3.setBounds(233, 98, 58, 20);
		contentPane.add(txtLabel_3);
		txtLabel_3.setColumns(10);
		
		txtLabel_4 = new JTextField();
		txtLabel_4.setText("Label");
		txtLabel_4.setBounds(233, 129, 58, 20);
		contentPane.add(txtLabel_4);
		txtLabel_4.setColumns(10);
		
		txtLabel_5 = new JTextField();
		txtLabel_5.setText("Label");
		txtLabel_5.setBounds(233, 160, 58, 20);
		contentPane.add(txtLabel_5);
		txtLabel_5.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setText("Email");
		txtEmail.setBounds(309, 98, 115, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtEmail_1 = new JTextField();
		txtEmail_1.setText("Email");
		txtEmail_1.setBounds(309, 129, 115, 20);
		contentPane.add(txtEmail_1);
		txtEmail_1.setColumns(10);
		
		txtEmail_2 = new JTextField();
		txtEmail_2.setText("Email");
		txtEmail_2.setBounds(309, 160, 115, 20);
		contentPane.add(txtEmail_2);
		txtEmail_2.setColumns(10);
		
		lblOtherDatas = new JLabel("Other Datas:");
		lblOtherDatas.setBounds(10, 191, 76, 32);
		contentPane.add(lblOtherDatas);
		
		txtLabel_6 = new JTextField();
		txtLabel_6.setText("Label");
		txtLabel_6.setBounds(10, 227, 86, 20);
		contentPane.add(txtLabel_6);
		txtLabel_6.setColumns(10);
		
		txtData = new JTextField();
		txtData.setText("Data");
		txtData.setBounds(106, 227, 184, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		txtLabel_7 = new JTextField();
		txtLabel_7.setText("Label");
		txtLabel_7.setBounds(10, 266, 86, 20);
		contentPane.add(txtLabel_7);
		txtLabel_7.setColumns(10);
		
		txtData_1 = new JTextField();
		txtData_1.setText("Data");
		txtData_1.setBounds(106, 266, 184, 20);
		contentPane.add(txtData_1);
		txtData_1.setColumns(10);
		
		btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(326, 213, 115, 73);
		contentPane.add(btnNewButton);
	}
}
