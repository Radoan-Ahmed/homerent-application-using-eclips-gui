import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Label;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;

public class AddHome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddHome frame = new AddHome();
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
	public AddHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 277, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Home home = new Home();
				home.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(0, 0, 92, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("View Profile");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				ViewOwnerpro view = new ViewOwnerpro();
				view.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(85, 0, 99, 23);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(85, 43, 135, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(85, 83, 135, 20);
		contentPane.add(choice);
		choice.add("single");
		choice.add("double");
		
		textField_1 = new JTextField();
		textField_1.setBounds(85, 117, 135, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(85, 197, 135, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(85, 239, 135, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Location");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 46, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Catagory");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 83, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Bedroom");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 120, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("E-mail");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(10, 200, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(10, 242, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(85, 157, 135, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		Button button = new Button("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
String num = choice.getSelectedItem();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String quary = "INSERT INTO `addhome`(`Location`, `Catagory`, `Bedroom`, `Name`, `E-mail`, `Mobile`) VALUES (?,?,?,?,?,?)";
				
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homerent","root","");
					PreparedStatement pst = con.prepareStatement(quary);
					pst.setString(1, textField.getText());
					pst.setString(2, num);
					pst.setString(3, textField_1.getText());
					pst.setString(4, textField_2.getText());
					pst.setString(5, textField_3.getText());
					pst.setString(6, textField_4.getText());
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Home Add Successfully");
					
					
					
				}catch(Exception ex) {
					
					JOptionPane.showMessageDialog(null, "ex");
					
				}
				
			}
		});
		button.setBounds(57, 274, 70, 22);
		contentPane.add(button);
		
		table = new JTable();
		table.setBounds(607, 141, -203, -97);
		contentPane.add(table);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
			}
		});
		btnNewButton_3.setBounds(170, 0, 92, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_5 = new JLabel("Name");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(10, 160, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(AddHome.class.getResource("k.jpg")));
		lblNewLabel_6.setBounds(0, 46, 276, 279);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon(AddHome.class.getResource("k.jpg")));
		lblNewLabel_7.setBounds(0, 0, 262, 63);
		contentPane.add(lblNewLabel_7);
	}
}
