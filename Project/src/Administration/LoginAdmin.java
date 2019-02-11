package Administration;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.MainWindows;

import javax.swing.JTextField;
import java.awt.TextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class LoginAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	static Admin admin = new Admin();
	
	private JMenuBar menuBar;
	private JMenu mnOption;
	private JMenuItem mntmMainmenu;
	private static int retry =0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginAdmin frame = new LoginAdmin();
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
	public LoginAdmin() {
		setTitle("Login For Administration");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 434, 332);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnOption = new JMenu("Option");
		menuBar.add(mnOption);
		
		mntmMainmenu = new JMenuItem("");
		mntmMainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			new MainWindows().setVisible(true);
			}
		});
		mntmMainmenu.setIcon(new ImageIcon(LoginAdmin.class.getResource("/images/home.PNG")));
		mnOption.add(mntmMainmenu);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.GRAY);
		textField.setToolTipText("Enter your login UserName");
		textField.setBounds(63, 117, 311, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblLoginAdmin = new JLabel("Login Admin");
		lblLoginAdmin.setForeground(Color.BLACK);
		lblLoginAdmin.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 30));
		lblLoginAdmin.setBounds(126, 11, 192, 88);
		contentPane.add(lblLoginAdmin);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(Color.GRAY);
		passwordField.setBounds(63, 160, 311, 32);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon(LoginAdmin.class.getResource("/images/login.PNG")));
		btnLogin.setBackground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if (textField.getText().equals("root") && passwordField.getText().equals("root")) {
				dispose();
				admin.setVisible(true);
			} else {
				retry++;
				if(retry==3) {
					System.exit(1);
				}
				dispose();
				Error error = new Error();
				error.setVisible(true);
			}
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 11));
		btnLogin.setBounds(168, 208, 95, 54);
		contentPane.add(btnLogin);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginAdmin.class.getResource("/images/loginWindows.PNG")));
		label.setBounds(0, -23, 418, 298);
		contentPane.add(label);
	}
}
