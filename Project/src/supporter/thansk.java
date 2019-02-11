package supporter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.MainWindows;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class thansk extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					thansk frame = new thansk();
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
	public thansk() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			new MainWindows().setVisible(true);
			}
		});
		btnMainMenu.setBackground(Color.LIGHT_GRAY);
		btnMainMenu.setBounds(617, 277, 109, 33);
		contentPane.add(btnMainMenu);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\usman\\eclipse-workspace\\Project\\src\\images\\thanksforgiving.PNG"));
		label.setBounds(0, 0, 726, 341);
		contentPane.add(label);
	}

}
