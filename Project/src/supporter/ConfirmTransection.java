package supporter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Administration.Error;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import java.awt.Choice;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConfirmTransection extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	int sizecard=0;
	int sizedate=0;
	int sizepin=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmTransection frame = new ConfirmTransection("Amount");
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
	public ConfirmTransection(String amount) {
		setResizable(false);
		setForeground(Color.WHITE);
		setTitle("for Refugees");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 347);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(164, 73, 267, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblCreditCardNumber = new JLabel("Credit Card Number : ");
		lblCreditCardNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCreditCardNumber.setBounds(10, 113, 144, 30);
		contentPane.add(lblCreditCardNumber);
		JLabel amount1 = new JLabel(amount);
		
		amount1.setFont(new Font("Tahoma", Font.BOLD, 16));
		amount1.setBounds(197, 11, 98, 30);
		contentPane.add(amount1);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
			char c = evt.getKeyChar();
			sizecard++;
			if (!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE) ) {
				evt.consume();
			}
			if (sizecard>12) {
				lblNewLabel.setText("Something is wrong");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}});
		formattedTextField.setBounds(164, 114, 267, 30);
		contentPane.add(formattedTextField);
		
		JLabel lblExpiryOfCard = new JLabel("Expiry of Card : ");
		lblExpiryOfCard.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblExpiryOfCard.setBounds(10, 154, 144, 30);
		contentPane.add(lblExpiryOfCard);
		
		JLabel lblEnterThe = new JLabel("Enter the 4 digit pin : ");
		lblEnterThe.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnterThe.setBounds(10, 195, 151, 30);
		contentPane.add(lblEnterThe);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.addKeyListener(new KeyAdapter() {
			int charsize=0;
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				charsize++;
				if (!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE) ) {
					e.consume();
				}
				if (charsize>6) {
				lblNewLabel.setText("Something is wrong");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				}
			}
		});
		formattedTextField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		formattedTextField_1.setToolTipText("ddmmyy");
		formattedTextField_1.setBounds(164, 154, 267, 30);
		contentPane.add(formattedTextField_1);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				sizepin++;
				if (!(Character.isDigit(c)) || (c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE) ) {
					e.consume();
				}
				if (sizepin>4) {
				lblNewLabel.setText("Something is wrong");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}});
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordField.setBounds(164, 195, 267, 30);
		contentPane.add(passwordField);
		
		JButton btnInsert = new JButton("Confirm");
		btnInsert.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			
			public void actionPerformed(ActionEvent arg0) {
			if(formattedTextField.getText().length()+formattedTextField_1.getText().length()+passwordField.getText().length()<22||formattedTextField.getText().length()+formattedTextField_1.getText().length()+passwordField.getText().length()>22) {
				dispose();
				//new report().setVisible(true);
			}
			else {
				StringBuilder sb = new StringBuilder(amount);
			try {
				FileWriter fw = new FileWriter(sb.append(".txt").toString());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(formattedTextField.getText());
				bw.newLine();
				bw.write(formattedTextField_1.getText());
				bw.newLine();
				bw.write(passwordField.getText());
				bw.newLine();
				bw.close();
				fw.close();
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dispose();
			new thansk().setVisible(true);
			}
			}
		});
		btnInsert.setBounds(197, 240, 98, 23);
		contentPane.add(btnInsert);
		
		JLabel lblDonating = new JLabel("Donating : ");
		lblDonating.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDonating.setBounds(91, 11, 98, 30);
		contentPane.add(lblDonating);
		
		JLabel label = new JLabel("$");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(298, 11, 46, 30);
		contentPane.add(label);
		
		
	}
}
