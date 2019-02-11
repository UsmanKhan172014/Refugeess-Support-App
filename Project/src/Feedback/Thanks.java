package Feedback;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.MainWindows;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Thanks extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thanks frame = new Thanks();
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
	public Thanks() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 542, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThanksForYour = new JLabel("Thanks for your feedback!!!");
		lblThanksForYour.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThanksForYour.setBounds(114, 11, 336, 60);
		contentPane.add(lblThanksForYour);
		
		JLabel lblWeMustConsider = new JLabel("We must consider it");
		lblWeMustConsider.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWeMustConsider.setBounds(114, 59, 336, 60);
		contentPane.add(lblWeMustConsider);
		
		JLabel lblThisWillMake = new JLabel("This will make our app much better");
		lblThisWillMake.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThisWillMake.setBounds(114, 114, 336, 60);
		contentPane.add(lblThisWillMake);
		
		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			MainWindows mw = new MainWindows();
			mw.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(370, 244, 105, 33);
		contentPane.add(btnNewButton);
	}
}
