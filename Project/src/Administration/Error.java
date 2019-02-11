package Administration;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.MainWindows;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class Error extends JFrame {

	private JPanel contentPane;
	static Panel frame = new Panel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {       
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
	public Error() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 328);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOption = new JMenu("Option");
		menuBar.add(mnOption);
		
		JMenuItem mntmRetry = new JMenuItem("");
		mntmRetry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			new LoginAdmin().setVisible(true);
			}
		});
		mntmRetry.setBackground(Color.WHITE);
		mntmRetry.setIcon(new ImageIcon(Error.class.getResource("/images/retry.PNG")));
		mnOption.add(mntmRetry);
		
		JMenuItem mntmMainMenu = new JMenuItem("");
		mntmMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			new MainWindows().setVisible(true);
			}
		});
		mntmMainMenu.setIcon(new ImageIcon(Error.class.getResource("/images/home.PNG")));
		mnOption.add(mntmMainMenu);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFailed = new JLabel("Failed");
		lblFailed.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblFailed.setBounds(149, 94, 104, 67);
		contentPane.add(lblFailed);
	}
}
