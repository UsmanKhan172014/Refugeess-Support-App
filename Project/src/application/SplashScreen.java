package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;

public class SplashScreen extends JFrame {

	private JPanel contentPane;
	public JProgressBar progressBar = new JProgressBar();
	public JLabel label = new JLabel("99%");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen frame = new SplashScreen();
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
	public SplashScreen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 485, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRefugeeSupportApp = new JLabel("Refugee Support App");
		lblRefugeeSupportApp.setForeground(Color.YELLOW);
		lblRefugeeSupportApp.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 32));
		lblRefugeeSupportApp.setBounds(72, 0, 359, 58);
		contentPane.add(lblRefugeeSupportApp);
		
		JLabel lblPleaseWaitWhile = new JLabel("Please wait...");
		lblPleaseWaitWhile.setForeground(Color.YELLOW);
		lblPleaseWaitWhile.setFont(new Font("Arial", Font.PLAIN, 21));
		lblPleaseWaitWhile.setBounds(35, 191, 146, 41);
		contentPane.add(lblPleaseWaitWhile);
		
		
		label.setForeground(Color.YELLOW);
		label.setFont(new Font("Tahoma", Font.PLAIN, 34));
		label.setBounds(383, 176, 76, 58);
		contentPane.add(label);
		progressBar.setBackground(Color.GREEN);
		
		progressBar.setBounds(35, 243, 406, 19);
		contentPane.add(progressBar);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\usman\\eclipse-workspace\\Project\\src\\images\\Main.PNG"));
		label_1.setBounds(0, 0, 469, 300);
		contentPane.add(label_1);
	}
}
