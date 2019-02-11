package application;

import java.awt.EventQueue;
import Register.Register;
import regards.Partners;
import supporter.Supporter;
import ChatRoom.*;
import Feedback.Feedback;
import Register.Register;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

import Administration.LoginAdmin;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MainWindows extends JFrame {

	private JPanel contentPane;
	 
	
			/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindows frame = new MainWindows();
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
	public MainWindows() {
		setTitle("Refugee Support App");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 625, 486);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToRefugee = new JLabel("Welcome To Refugee Support App");
		lblWelcomeToRefugee.setForeground(UIManager.getColor("ColorChooser.foreground"));
		lblWelcomeToRefugee.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 29));
		lblWelcomeToRefugee.setBounds(78, 40, 462, 54);
		contentPane.add(lblWelcomeToRefugee);
		
		JButton btnNewButton = new JButton("Feedback");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\usman\\eclipse-workspace\\Project\\src\\images\\feedback.PNG"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			new Feedback().setVisible(true);
			
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setBounds(10, 105, 253, 54);
		contentPane.add(btnNewButton);
		
		JButton btnAdministration = new JButton("Administration");
		btnAdministration.setBackground(Color.WHITE);
		btnAdministration.setIcon(new ImageIcon("C:\\Users\\usman\\eclipse-workspace\\Project\\src\\images\\admin c.PNG"));
		btnAdministration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				LoginAdmin la = new LoginAdmin();
				la.setVisible(true);
				
			}
		});
		btnAdministration.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnAdministration.setBounds(346, 105, 253, 54);
		contentPane.add(btnAdministration);
		
		JButton btnSupporter = new JButton("Supporter");
		btnSupporter.setBackground(new Color(255, 255, 255));
		btnSupporter.setIcon(new ImageIcon("C:\\Users\\usman\\eclipse-workspace\\Project\\src\\images\\partners.PNG"));
		btnSupporter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
				new Supporter().setVisible(true);
			
			}
		});
		btnSupporter.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSupporter.setBounds(10, 227, 253, 54);
		contentPane.add(btnSupporter);
		
		JButton btnChat = new JButton("Live Reporting");
		btnChat.setBackground(Color.WHITE);
		btnChat.setIcon(new ImageIcon("C:\\Users\\usman\\eclipse-workspace\\Project\\src\\images\\report.PNG"));
		btnChat.setToolTipText("This is message sending and only applicable while server is running");
		btnChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClientGUI c = new ClientGUI("Localhost",7000);
				dispose();
				c.setVisible(true);
			}
		});
		btnChat.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnChat.setBounds(346, 227, 253, 54);
		contentPane.add(btnChat);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(Color.WHITE);
		btnRegister.setIcon(new ImageIcon("C:\\Users\\usman\\eclipse-workspace\\Project\\src\\images\\register.PNG"));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
				new Register().setVisible(true);
			}
		});
		btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnRegister.setBounds(10, 338, 253, 54);
		contentPane.add(btnRegister);
		
		JButton btnListRefugees = new JButton("List Refugee");
		btnListRefugees.setBackground(Color.WHITE);
		btnListRefugees.setIcon(new ImageIcon("C:\\Users\\usman\\eclipse-workspace\\Project\\src\\images\\list.PNG"));
		btnListRefugees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			new ListRefugees().setVisible(true);
			
			}
		});
		btnListRefugees.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnListRefugees.setBounds(346, 338, 253, 54);
		contentPane.add(btnListRefugees);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 609, 21);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setBackground(Color.WHITE);
		mntmExit.setIcon(new ImageIcon("C:\\Users\\usman\\eclipse-workspace\\Project\\src\\images\\exit.PNG"));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			}
		});
		
		JMenuItem mntmPartners = new JMenuItem("Partners");
		mntmPartners.setBackground(Color.WHITE);
		mntmPartners.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			new Partners().setVisible(true);
			}
		});
		mntmPartners.setIcon(new ImageIcon("C:\\Users\\usman\\eclipse-workspace\\Project\\src\\images\\partners.PNG"));
		mnFile.add(mntmPartners);
		mnFile.add(mntmExit);
	}
}
