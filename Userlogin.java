package Textbook_selling_system;
/**
 * 
 *
 */
import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

import java.sql.*;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Userlogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Userlogin frame = new Userlogin();
					
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
	public Userlogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\admin\\Desktop\\Book Selling System\\0 (Custom).jpg"));
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\admin\\Desktop\\STDM.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 190, 1014, 597);
		setResizable(false);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setBackground(new Color(250, 250, 252));
	setContentPane(contentPane);
	contentPane.setLayout(null);
		
	JLabel lblNewLabel = new JLabel("User Login");
	lblNewLabel.setForeground(new Color(45, 55, 72));
	lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
		lblNewLabel.setBounds(373, 42, 273, 93);
		contentPane.add(lblNewLabel);
		
	textField = new JTextField();
	textField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	textField.setBounds(481, 170, 281, 48);
		contentPane.add(textField);
		textField.setColumns(10);
		
	passwordField = new JPasswordField();
	passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 20));
	passwordField.setBounds(481, 286, 281, 48);
		contentPane.add(passwordField);
		
	JLabel lblUsername = new JLabel("Username");
	lblUsername.setForeground(new Color(60, 60, 60));
	lblUsername.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	lblUsername.setBounds(204, 178, 193, 32);
		contentPane.add(lblUsername);
		
	JLabel lblPassword = new JLabel("Password");
	lblPassword.setForeground(new Color(60, 60, 60));
	lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	lblPassword.setBounds(204, 294, 193, 32);
		contentPane.add(lblPassword);
		
	btnNewButton = new JButton("Login");
	btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 16));
	UIUtils.styleButton(btnNewButton, new Color(60, 120, 215));
	btnNewButton.setBounds(481, 387, 113, 44);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ustr = textField.getText() == null ? "" : textField.getText().trim();
				// Use getPassword() (returns char[]) and convert to String for simple comparisons
				char[] pwd = passwordField.getPassword();
				String pstr = pwd == null ? "" : new String(pwd).trim();

				boolean loggedIn = false;
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/book_selling_system", "root", "");
					String sql = "SELECT 1 FROM account WHERE user1 = ? AND pass1 = ? LIMIT 1";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, ustr);
					ps.setString(2, pstr);
					ResultSet rs = ps.executeQuery();
					if (rs.next()) {
						loggedIn = true;
					}
					rs.close();
					ps.close();
					con.close();
				} catch (Exception dbEx) {
					System.out.println("DB login check failed: " + dbEx.getMessage());
					JOptionPane.showMessageDialog(btnNewButton, "Database error: " + dbEx.getMessage());
				}

				if (loggedIn) {
					dispose();
					UserHost uh = new UserHost();
					uh.setTitle("Book Selling System");
					uh.setVisible(true);
					JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
				} else {
					JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
				}
			}
		});
	
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Admin Login");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminLogin al=new AdminLogin();
				al.setTitle("Book Selling System");
				al.setVisible(true);
			}
		});
	btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
	UIUtils.styleButton(btnNewButton_1, new Color(108, 117, 125));
	btnNewButton_1.setBounds(204, 419, 216, 64);
		contentPane.add(btnNewButton_1);
		
	btnNewButton_2 = new JButton("Create new account");
	btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	UIUtils.styleButton(btnNewButton_2, new Color(40, 167, 69));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Create_ac ca = new Create_ac();
				ca.setTitle("Book Selling System");
				ca.setVisible(true);
			}
		});
	btnNewButton_2.setBounds(481, 470, 281, 44);
		contentPane.add(btnNewButton_2);
		
	btnNewButton_3 = new JButton("Reset ");
	btnNewButton_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
	UIUtils.styleButton(btnNewButton_3, new Color(220, 53, 69));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(649, 387, 113, 44);
		contentPane.add(btnNewButton_3);
	

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\Book Selling System\\books-wallpaper-49796-51475-hd-wallpapers (Custom).jpg"));
		label_1.setBounds(0, 0, 1008, 562);
		contentPane.add(label_1);
		
	
	}

}
