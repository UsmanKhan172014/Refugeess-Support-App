package supporter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.MainWindows;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import java.awt.TextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Supporter extends JFrame {
	private JPanel contentPane;
	static TextField textFieldRef = new TextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supporter frame = new Supporter();
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
	public Supporter() {
		setTitle("Support Section");
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 245, 254);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOption = new JMenu("Option");
		menuBar.add(mnOption);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			dispose();
			new MainWindows().setVisible(true);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(Supporter.class.getResource("/images/home.PNG")));
		mnOption.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblForTheSupport = new JLabel("for the support of Refugees");
		lblForTheSupport.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblForTheSupport.setBounds(10, 11, 219, 49);
		contentPane.add(lblForTheSupport);
		
		
		textFieldRef.setBounds(25, 72, 61, 29);
		contentPane.add(textFieldRef);
		
		JLabel label = new JLabel("&");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(92, 71, 46, 29);
		contentPane.add(label);
		
		JButton btnDonate = new JButton("Donate");
		btnDonate.setBackground(Color.WHITE);
		btnDonate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			new ConfirmTransection(textFieldRef.getText()).setVisible(true);
			}
		});
		btnDonate.setBounds(58, 111, 116, 29);
		contentPane.add(btnDonate);
	}
}
