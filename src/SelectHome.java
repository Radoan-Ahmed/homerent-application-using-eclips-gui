import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import java.awt.Color;

public class SelectHome extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectHome frame = new SelectHome();
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
	public SelectHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 281, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(85, 30, 177, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Address");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 33, 89, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String num = textField.getText();
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/homerent","root","");
					Statement stmt = con.createStatement();
					
					 String sql = "Select * from owner where  Address = '"+num+"'";
					@SuppressWarnings("unused")
					ResultSet rs = stmt.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					con.close();
					
				}catch(Exception e1) {
					
				}
				
			}
		});
		btnNewButton.setBounds(53, 61, 89, 23);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		table.setBounds(0, 95, 265, 166);
		contentPane.add(table);
		
		btnNewButton_1 = new JButton("Home");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Home home = new Home();
				home.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("View Profile");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				ViewCustomerPro view = new ViewCustomerPro();
				view.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(85, 0, 89, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		btnNewButton_3.setBounds(173, 0, 92, 23);
		contentPane.add(btnNewButton_3);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(SelectHome.class.getResource("k.jpg")));
		lblNewLabel_1.setBounds(0, 0, 265, 111);
		contentPane.add(lblNewLabel_1);
	}

}
