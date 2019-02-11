package Feedback;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.MainWindows;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.Button;

import javax.activation.MailcapCommandMap;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Feedback extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private static ButtonGroup bg = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Feedback frame = new Feedback();
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
	public Feedback() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 417);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 11, 100, 32);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setForeground(Color.BLACK);
		textField.setBackground(Color.WHITE);
		textField.setBounds(133, 11, 332, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JRadioButton radioButton = new JRadioButton("1");
		radioButton.setToolTipText("Bad");
		radioButton.setActionCommand("Bad");
		radioButton.setBackground(Color.WHITE);
		radioButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		radioButton.setBounds(133, 81, 51, 23);
		contentPane.add(radioButton);
		
		
		JLabel lblStars = new JLabel("Stars :");
		lblStars.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStars.setBounds(10, 81, 100, 32);
		contentPane.add(lblStars);
		
		JRadioButton radioButton_1 = new JRadioButton("2");
		radioButton_1.setToolTipText("Normal");
		radioButton_1.setActionCommand("Normal");
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		radioButton_1.setBounds(186, 81, 51, 23);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("3");
		radioButton_2.setToolTipText("Good");
		radioButton_2.setActionCommand("Good");
		radioButton_2.setBackground(Color.WHITE);
		radioButton_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		radioButton_2.setBounds(259, 81, 51, 23);
		contentPane.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("4");
		radioButton_3.setToolTipText("Very Good");
		radioButton_3.setActionCommand("Very Good");
		radioButton_3.setBackground(Color.WHITE);
		radioButton_3.setFont(new Font("Tahoma", Font.BOLD, 17));
		radioButton_3.setBounds(331, 81, 51, 23);
		contentPane.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("5");
		radioButton_4.setToolTipText("Excellent");
		radioButton_4.setActionCommand("Excellent");
		radioButton_4.setBackground(Color.WHITE);
		radioButton_4.setFont(new Font("Tahoma", Font.BOLD, 17));
		radioButton_4.setBounds(397, 81, 51, 23);
		contentPane.add(radioButton_4);
		
		JLabel lblComment = new JLabel("Comment :");
		lblComment.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblComment.setBounds(10, 124, 89, 32);
		contentPane.add(lblComment);
		
		TextArea textArea = new TextArea();
		textArea.setFont(new Font("Dialog", Font.ITALIC, 14));
		textArea.setBounds(10, 163, 489, 160);
		contentPane.add(textArea);
		//for combining the radio buttons
		//so no can select more then one button
		bg.add(radioButton_4);
		bg.add(radioButton_3);
		bg.add(radioButton_2);
		bg.add(radioButton_1);
		bg.add(radioButton);
		JButton btnSub = new JButton("Submit");
		btnSub.setBackground(Color.WHITE);
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				FileWriter fw = new FileWriter("feedback.txt",true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(textField.getText());
				bw.newLine();
				bw.write(bg.getSelection().getActionCommand());
				bw.newLine();
				bw.write(textArea.getText());
				bw.newLine();
				bw.newLine();
				bw.close();
				fw.close();
				dispose();
				Thanks t = new Thanks();
				t.setVisible(true);
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnSub.setFont(new Font("Tahoma", Font.ITALIC, 13));
		btnSub.setBounds(391, 345, 89, 23);
		contentPane.add(btnSub);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.setBackground(Color.WHITE);
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			new MainWindows().setVisible(true);
			}
		});
		btnMainMenu.setBounds(293, 346, 89, 23);
		contentPane.add(btnMainMenu);
	}
}
