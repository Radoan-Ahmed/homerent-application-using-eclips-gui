import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Choice;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings({ "serial", "unused" })
public class OwnerRegister extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JPasswordField passwordField;
	private JTextField textFieldEmail;
	private JTextField textFieldMobile;
	private JTextField textFieldDateBirth;
	private JTextField textFieldAddress;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OwnerRegister frame = new OwnerRegister();
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
	public OwnerRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setBounds(90, 66, 149, 20);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(90, 97, 149, 20);
		contentPane.add(passwordField);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(90, 128, 149, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldMobile = new JTextField();
		textFieldMobile.setBounds(90, 159, 149, 20);
		contentPane.add(textFieldMobile);
		textFieldMobile.setColumns(10);
		
		textFieldDateBirth = new JTextField();
		textFieldDateBirth.setBounds(90, 190, 149, 20);
		contentPane.add(textFieldDateBirth);
		textFieldDateBirth.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(90, 222, 149, 20);
		contentPane.add(choice);
		choice.add("Male");
		choice.add("Female");
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(90, 248, 149, 20);
		contentPane.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String num = choice.getSelectedItem();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String quary = "INSERT INTO `owner`(`UserName`, `Password`, `Email`, `Mobile`, `DateofBirth`, `Gender`, `Address`) VALUES (?,?,?,?,?,?,?)";
					//INSERT INTO `owner`(`UserName`, `Password`, `Email`, `Mobile`, `DateofBirth`, `Gender`, `Address`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7])
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homerent","root","");
					PreparedStatement pst = con.prepareStatement(quary);
					pst.setString(1, textFieldUserName.getText());
					pst.setString(2, passwordField.getText());
					pst.setString(3, textFieldEmail.getText());
					pst.setString(4, textFieldMobile.getText());
					pst.setString(5, textFieldDateBirth.getText());
					pst.setString(6, num);
					pst.setString(7, textFieldAddress.getText());
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Registration complete");
					
					
					dispose();
					Owner owner = new Owner();
					owner.setVisible(true);
					
					
					
				}catch(Exception ex) {
					
					JOptionPane.showMessageDialog(null, "ex");
					
				}
				
			}
		});
		btnNewButton.setBounds(114, 293, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("UserName:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 69, 70, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 100, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 131, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(10, 159, 46, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date of Birth:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(10, 190, 70, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gender:");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(10, 228, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address:");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(10, 251, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Owner Registration From");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_7.setBounds(21, 11, 276, 30);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon(OwnerRegister.class.getResource("o.jpg")));
		lblNewLabel_9.setBounds(-21, 97, 328, 415);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon(OwnerRegister.class.getResource("k.jpg")));
		lblNewLabel_8.setBounds(-21, -5, 328, 225);
		contentPane.add(lblNewLabel_8);
	}
}
