package Textbook_selling_system;
/**
 * 
 *
 */
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Create_ac extends JFrame {

	private JPanel contentPane;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField email;
	private JTextField username;
	private JTextField mob;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create_ac frame = new Create_ac();
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
	
	public Create_ac() {
		// setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\admin\\Desktop\\Book Selling System\\0 (Custom).jpg"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewUserRegister = new JLabel("New User Register");
		lblNewUserRegister.setForeground(new Color(102, 255, 0));
		lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
		lblNewUserRegister.setBounds(362, 52, 325, 50);
		contentPane.add(lblNewUserRegister);
		
		JLabel lblName = new JLabel("First name");
		lblName.setForeground(new Color(255, 204, 51));
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(58, 151, 99, 43);
		contentPane.add(lblName);
		
		JLabel lblNewLabel = new JLabel("Last name");
		lblNewLabel.setForeground(new Color(255, 204, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(58, 243, 110, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmailAddress = new JLabel("Email\r\n address");
		lblEmailAddress.setForeground(new Color(255, 204, 0));
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmailAddress.setBounds(58, 324, 124, 36);
		contentPane.add(lblEmailAddress);
		
		firstname = new JTextField();
		firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
		firstname.setBounds(214, 151, 228, 50);
		contentPane.add(firstname);
		firstname.setColumns(10);
		
		lastname = new JTextField();
		lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lastname.setBounds(214, 235, 228, 50);
		contentPane.add(lastname);
		lastname.setColumns(10);
		
		email = new JTextField();

		email.setFont(new Font("Tahoma", Font.PLAIN, 32));
		email.setBounds(214, 320, 228, 50);
		contentPane.add(email);
		email.setColumns(10);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 32));
		username.setBounds(707, 151, 228, 50);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(255, 204, 0));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(542, 159, 99, 29);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 204, 0));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(542, 245, 99, 24);
		contentPane.add(lblPassword);
		
		JLabel lblMobileNumber = new JLabel("Mobile number");
		lblMobileNumber.setForeground(new Color(255, 204, 0));
		lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMobileNumber.setBounds(542, 329, 139, 26);
		contentPane.add(lblMobileNumber);
		
		mob = new JTextField();
		mob.setFont(new Font("Tahoma", Font.PLAIN, 32));
		mob.setBounds(707, 320, 228, 50);
		contentPane.add(mob);
		mob.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		passwordField.setBounds(707, 235, 228, 50);
		contentPane.add(passwordField);
		
		btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String first=firstname.getText();
				String last=lastname.getText();
				String emailadd=email.getText();
				String user1=username.getText();
				String mbRaw = mob.getText();
				String mb = mbRaw == null ? "" : mbRaw.replaceAll("[^\\d]", "");
				int len = mb.length();
				// Capture password correctly from JPasswordField
				char[] passChars = passwordField.getPassword();
				String pass1 = passChars == null ? "" : new String(passChars);
				String msg=""+first;
				msg+=" \n";
				if(len >= 8 && len <= 15)
				{
					// Basic required fields validation
					if (first == null || first.trim().isEmpty() ||
						last == null || last.trim().isEmpty() ||
						emailadd == null || emailadd.trim().isEmpty() ||
						user1 == null || user1.trim().isEmpty() ||
						pass1 == null || pass1.trim().isEmpty()) {
						JOptionPane.showMessageDialog(btnNewButton, "Please fill all fields");
						return;
					}
					try{
						//	String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
						//	Class.forName("com.mysql.jdbc.Driver");
							Class.forName("com.mysql.cj.jdbc.Driver");
							try (Connection con = DriverManager.getConnection(
										"jdbc:mysql://localhost:3306/book_selling_system","root","");
									PreparedStatement check = con.prepareStatement(
										"SELECT 1 FROM account WHERE user1 = ? LIMIT 1");
									PreparedStatement ps = con.prepareStatement(
										"INSERT INTO account (first, last, user1, pass1, emailadd, mb) VALUES (?,?,?,?,?,?)")) {

								// Check duplicate username
								check.setString(1, user1.trim());
								try (ResultSet rs = check.executeQuery()) {
									if (rs.next()) {
										JOptionPane.showMessageDialog(btnNewButton, "Username already exists");
										return;
									}
								}

								// Insert new account
								ps.setString(1, first.trim());
								ps.setString(2, last.trim());
								ps.setString(3, user1.trim());
								ps.setString(4, pass1.trim());
								ps.setString(5, emailadd.trim());
								ps.setString(6, mb);
								int rows = ps.executeUpdate();
								if (rows == 1) {
									JOptionPane.showMessageDialog(btnNewButton, "Welcome, "+msg+"Your account is successfully created");
								} else {
									JOptionPane.showMessageDialog(btnNewButton, "Registration failed. Please try again.");
								}
							}
						}
						catch(Exception f)
						{
							System.out.println(f.getMessage());
							JOptionPane.showMessageDialog(btnNewButton, "Database error: " + f.getMessage());
						}
				}
				else
				{
					JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number (8â€“15 digits)");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(345, 397, 139, 50);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Already Have Account ? Sign in");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Userlogin us=new Userlogin();
				us.setTitle("Book Selling System");
				us.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(297, 474, 435, 50);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Reset\r\n\r\n\r\n");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_2.setBounds(542, 397, 139, 50);
		contentPane.add(btnNewButton_2);
		
		label = new JLabel("");
		label.setForeground(new Color(255, 204, 0));
		// label.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\Book Selling System\\3 (Custom).jpg"));
		label.setBounds(0, 0, 1008, 562);
		contentPane.add(label);
	}
}
