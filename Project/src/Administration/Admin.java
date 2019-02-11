package Administration;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ChatRoom.ServerGUI;

import Linklist.AminsNode;
import application.MainWindows;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class Admin extends JFrame {

	private JPanel contentPane;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame= new Admin();
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
	public Admin() {
		setTitle("Admin Section");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 587, 406);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOption = new JMenu("Option");
		menuBar.add(mnOption);
		
		JMenuItem mntmMainMenu = new JMenuItem("");
		mntmMainMenu.setIcon(new ImageIcon(Admin.class.getResource("/images/home.PNG")));
		mntmMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			new MainWindows().setVisible(true);
			}
		});
		mnOption.add(mntmMainMenu);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnChatOnServer = new JButton("Start and Read on Server");
		btnChatOnServer.setBackground(Color.WHITE);
		btnChatOnServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ServerGUI sc = new ServerGUI(7000);
			dispose();
			sc.setVisible(true);
			
			
			}
		});
		btnChatOnServer.setFont(new Font("Lucida Bright", Font.PLAIN, 32));
		btnChatOnServer.setBounds(10, 189, 551, 153);
		contentPane.add(btnChatOnServer);
		
		JButton btnReadFeedbacks = new JButton("Read Feedbacks");
		btnReadFeedbacks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			new readfeedback().setVisible(true);
			}
		});
		btnReadFeedbacks.setBackground(Color.WHITE);
		btnReadFeedbacks.setFont(new Font("Lucida Bright", Font.PLAIN, 32));
		btnReadFeedbacks.setBounds(10, 25, 551, 153);
		contentPane.add(btnReadFeedbacks);
	}
}
