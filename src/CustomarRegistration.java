import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Choice;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CustomarRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private Choice choice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomarRegistration frame = new CustomarRegistration();
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
	public CustomarRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button button = new Button("Submit");
		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
String num = choice.getSelectedItem();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String quary = "INSERT INTO `customar`(`UserName`, `Password`, `Email`, `Mobile`, `DateofBirth`, `Gender`, `Address`) VALUES (?,?,?,?,?,?,?)";
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homerent","root","");
					PreparedStatement pst = con.prepareStatement(quary);
					pst.setString(1, textField.getText());
					pst.setString(2, passwordField.getText());
					pst.setString(3, textField_1.getText());
					pst.setString(4, textField_2.getText());
					pst.setString(5, textField_3.getText());
					pst.setString(6, num);
					pst.setString(7, textField_4.getText());
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Registration complete");
					
					
					dispose();
					Customar customar = new Customar();
					customar.setVisible(true);
					
					
					
				}catch(Exception ex) {
					
					JOptionPane.showMessageDialog(null, "ex");
					
				}
				
				
			}
		});
		button.setBounds(89, 264, 70, 22);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("UserName:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(20, 49, 75, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(20, 128, 46, -20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(20, 108, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(20, 139, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date of Birth:");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(20, 169, 70, 17);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Gender:");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(20, 197, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address:");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(20, 236, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(89, 38, 156, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(88, 69, 156, 20);
		contentPane.add(passwordField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(89, 105, 156, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(89, 136, 156, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(89, 167, 156, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		choice = new Choice();
		choice.setBounds(89, 193, 156, 20);
		contentPane.add(choice);
		choice.add("Male");
		choice.add("Female");
		
		textField_4 = new JTextField();
		textField_4.setBounds(89, 232, 159, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Customer Registar From");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_7.setBounds(20, 0, 232, 27);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Password:");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(20, 77, 59, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon(CustomarRegistration.class.getResource("k.jpg")));
		lblNewLabel_9.setBounds(0, 19, 275, 316);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon(CustomarRegistration.class.getResource("k.jpg")));
		lblNewLabel_10.setBounds(0, 0, 275, 63);
		contentPane.add(lblNewLabel_10);
	}

}
