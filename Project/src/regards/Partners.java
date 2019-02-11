package regards;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import application.MainWindows;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Window.Type;

public class Partners extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Partners frame = new Partners();
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
	public Partners() {
		setType(Type.POPUP);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 686, 542);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDevelopers = new JLabel("Developers");
		lblDevelopers.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblDevelopers.setBounds(190, 0, 174, 49);
		contentPane.add(lblDevelopers);
		
		JLabel lblSrNo = new JLabel("Sr. No.");
		lblSrNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSrNo.setBounds(10, 61, 71, 31);
		contentPane.add(lblSrNo);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(89, 61, 71, 31);
		contentPane.add(lblName);
		
		JLabel lblPost = new JLabel("Post");
		lblPost.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPost.setBounds(325, 61, 71, 31);
		contentPane.add(lblPost);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContact.setBounds(464, 61, 71, 31);
		contentPane.add(lblContact);
		
		JLabel label = new JLabel("1-");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(10, 103, 46, 31);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("2-");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(10, 159, 46, 31);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("3-");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(10, 218, 46, 31);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("4-");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(10, 276, 46, 31);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("5-");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(10, 331, 46, 31);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("6-");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(10, 388, 46, 31);
		contentPane.add(label_5);
		
		JLabel lblNaveedSultan = new JLabel("Naveed Sultan");
		lblNaveedSultan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNaveedSultan.setBounds(89, 103, 132, 31);
		contentPane.add(lblNaveedSultan);
		
		JLabel lblOrganizer = new JLabel("Head Organizer");
		lblOrganizer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOrganizer.setBounds(253, 103, 132, 31);
		contentPane.add(lblOrganizer);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Desktop d = Desktop.getDesktop();
			try {
				d.browse(new URI("https://www.facebook.com/naveed.sultan.9615"));
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\usman\\eclipse-workspace\\Project\\src\\images\\fb.jpg"));
		button.setBounds(464, 85, 46, 49);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Desktop d = Desktop.getDesktop();
			try {
				d.browse(new URI("https://twitter.com/usmankhan1159"));
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\usman\\eclipse-workspace\\Project\\src\\images\\twitter.jpg"));
		btnNewButton.setBounds(528, 141, 56, 49);
		contentPane.add(btnNewButton);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Desktop d = Desktop.getDesktop();
			try {
				d.browse(new URI("https://www.facebook.com/profile.php?id=100007545585150"));
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		button_1.setIcon(new ImageIcon("C:\\Users\\usman\\eclipse-workspace\\Project\\src\\images\\fb.jpg"));
		button_1.setBounds(464, 141, 46, 49);
		contentPane.add(button_1);
		
		JLabel lblMUsmanKhan = new JLabel("M. Usman Khan");
		lblMUsmanKhan.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMUsmanKhan.setBounds(89, 159, 132, 31);
		contentPane.add(lblMUsmanKhan);
		
		JLabel lblDeveloper = new JLabel("Head Developer");
		lblDeveloper.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDeveloper.setBounds(253, 159, 143, 31);
		contentPane.add(lblDeveloper);
		
		JLabel lblDaudAzeem = new JLabel("Farhan Iqbal");
		lblDaudAzeem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDaudAzeem.setBounds(89, 218, 132, 31);
		contentPane.add(lblDaudAzeem);
		
		JLabel lblF = new JLabel("Daud Azeem");
		lblF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblF.setBounds(89, 276, 132, 31);
		contentPane.add(lblF);
		
		JLabel lblAnwarulhaq = new JLabel("Anwar-ul-Haq");
		lblAnwarulhaq.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAnwarulhaq.setBounds(89, 331, 132, 31);
		contentPane.add(lblAnwarulhaq);
		
		JLabel lblUsmanYousaf = new JLabel("Usman Yousaf");
		lblUsmanYousaf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsmanYousaf.setBounds(89, 388, 132, 31);
		contentPane.add(lblUsmanYousaf);
		
		JLabel lblGraphics = new JLabel("Front-End Designer");
		lblGraphics.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGraphics.setBounds(253, 218, 160, 31);
		contentPane.add(lblGraphics);
		
		JLabel lblMarketingManager = new JLabel("Marketing Manager");
		lblMarketingManager.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMarketingManager.setBounds(253, 276, 160, 31);
		contentPane.add(lblMarketingManager);
		
		JLabel lblSupervisor = new JLabel("Supervisor");
		lblSupervisor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSupervisor.setBounds(253, 331, 160, 31);
		contentPane.add(lblSupervisor);
		
		JLabel lblGraphicsDesinger = new JLabel("Graphics Desinger");
		lblGraphicsDesinger.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGraphicsDesinger.setBounds(253, 388, 160, 31);
		contentPane.add(lblGraphicsDesinger);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Desktop d = Desktop.getDesktop();
			try {
				d.browse(new URI("https://www.facebook.com/farhanbajwa203"));
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		button_2.setIcon(new ImageIcon("C:\\Users\\usman\\eclipse-workspace\\Project\\src\\images\\fb.jpg"));
		button_2.setBounds(464, 200, 46, 49);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Desktop d = Desktop.getDesktop();
			try {
				d.browse(new URI("https://www.facebook.com/daud.azeem0331"));
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		button_3.setIcon(new ImageIcon("C:\\Users\\usman\\eclipse-workspace\\Project\\src\\images\\fb.jpg"));
		button_3.setBounds(464, 258, 46, 49);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Desktop d = Desktop.getDesktop();
			try {
				d.browse(new URI("https://www.facebook.com/anwarulhaq7662"));
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		button_4.setIcon(new ImageIcon("C:\\Users\\usman\\eclipse-workspace\\Project\\src\\images\\fb.jpg"));
		button_4.setBounds(464, 313, 46, 49);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Desktop d = Desktop.getDesktop();
			try {
				d.browse(new URI("https://www.facebook.com/profile.php?id=100008416811773"));
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		button_5.setIcon(new ImageIcon("C:\\Users\\usman\\eclipse-workspace\\Project\\src\\images\\fb.jpg"));
		button_5.setBounds(464, 370, 46, 49);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		button_6.setIcon(new ImageIcon("C:\\Users\\usman\\eclipse-workspace\\Project\\src\\images\\twitter.jpg"));
		button_6.setBounds(528, 258, 56, 49);
		contentPane.add(button_6);
		
		JButton btnMainWindows = new JButton("Main Menu");
		btnMainWindows.setBackground(Color.WHITE);
		btnMainWindows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			new MainWindows().setVisible(true);
			}
		});
		btnMainWindows.setBounds(528, 470, 118, 23);
		contentPane.add(btnMainWindows);
	}

}
