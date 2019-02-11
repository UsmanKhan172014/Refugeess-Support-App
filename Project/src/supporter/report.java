package supporter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class report extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					report frame = new report();
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
	public report() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 484, 354);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSomethingIsNot = new JLabel("Something is not right please give correct data");
		lblSomethingIsNot.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSomethingIsNot.setBounds(76, 49, 341, 38);
		contentPane.add(lblSomethingIsNot);
		
		JButton btnBackToTransection = new JButton("back to transection screen");
		btnBackToTransection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			new Supporter().setVisible(true);
			}
		});
		btnBackToTransection.setBackground(Color.WHITE);
		btnBackToTransection.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBackToTransection.setBounds(131, 128, 226, 51);
		contentPane.add(btnBackToTransection);
	}
}
