import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Owner extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Owner frame = new Owner();
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
	public Owner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Owner Login");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setBounds(77, 34, 155, 32);
		contentPane.add(lblNewLabel);
		
		user = new JTextField();
		user.setBounds(94, 88, 174, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(96, 135, 172, 20);
		contentPane.add(pass);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homerent","root","");
					Statement stmt = con.createStatement();
					@SuppressWarnings("deprecation")
					String sql = "Select * from owner where UserName='"+user.getText()+"' and Password = '"+pass.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"Login Sucessfully...");
						
						dispose();
						ViewOwnerpro viewoner = new ViewOwnerpro();
						viewoner.setVisible(true);
						
						
						}
					else {
						JOptionPane.showMessageDialog(null,"Incorrect username and Password...");
						}
					con.close();
					
				}catch(Exception e1) {
					
				}
				
			}
		});
		btnNewButton.setBounds(23, 165, 71, 20);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Click Here for Register");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				OwnerRegister register = new OwnerRegister();
				register.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(73, 210, 171, 14);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(23, 91, 77, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(23, 138, 77, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Home");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Home home = new Home();
				home.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(0, 0, 103, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Owner");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Owner owner = new Owner();
				owner.setVisible(true);
				
				
				
			}
		});
		btnNewButton_3.setBounds(102, 0, 115, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_4.setBounds(212, 0, 114, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Owner.class.getResource("o.jpg")));
		lblNewLabel_3.setBounds(0, 0, 326, 280);
		contentPane.add(lblNewLabel_3);
	}
}
