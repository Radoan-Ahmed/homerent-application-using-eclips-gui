import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Customar extends JFrame {

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
					Customar frame = new Customar();
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
	public Customar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 310, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home home = new Home();
				home.setVisible(true);
				
				
			}
		});
		btnNewButton.setBounds(0, 0, 99, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Customar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Customar customar = new Customar();
				customar.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(97, 0, 99, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
				
			}
		});
		btnNewButton_2.setBounds(195, 0, 99, 23);
		contentPane.add(btnNewButton_2);
		
		user = new JTextField();
		user.setBounds(110, 85, 146, 20);
		contentPane.add(user);
		user.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(110, 126, 146, 20);
		contentPane.add(pass);
		
		JButton btnNewButton_3 = new JButton("Submit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                 try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homerent","root","");
					Statement stmt = con.createStatement();
					@SuppressWarnings("deprecation")
					String sql = "Select * from customar where UserName='"+user.getText()+"' and Password = '"+pass.getText().toString()+"'";
					ResultSet rs = stmt.executeQuery(sql);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"Login Sucessfully...");
						
						dispose();
						ViewCustomerPro view = new ViewCustomerPro();
						view.setVisible(true);
						
						
						}
					else {
						JOptionPane.showMessageDialog(null,"Incorrect username and Password...");
						}
					con.close();
					
				}catch(Exception e1) {
					
				}
				
			}
		});
		btnNewButton_3.setBounds(22, 157, 65, 20);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Click Here for Resistar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				CustomarRegistration customer = new CustomarRegistration();
				customer.setVisible(true);
				
			}
		});
		btnNewButton_4.setBounds(62, 191, 194, 16);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel = new JLabel("UserName:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(22, 88, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(22, 129, 77, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Customar Login");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_2.setBounds(51, 34, 194, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Customar.class.getResource("o.jpg")));
		lblNewLabel_3.setBounds(0, 0, 294, 218);
		contentPane.add(lblNewLabel_3);
	}
}
