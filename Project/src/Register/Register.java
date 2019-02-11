package Register;

import java.awt.BorderLayout;
import Linklist.*;
import application.MainWindows;
import supporter.Supporter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.Binder;

import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;


public class Register extends JFrame {
	static Register frame;
	private JPanel contentPane;
	private JTextField name;
	private JTextField father;
	private JTextField campAdress;
	private final ButtonGroup bg=new ButtonGroup();;
	Node node = new Node();
	public static ImplementLinkList ill = new ImplementLinkList();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Register();
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
	public Register() {
		ButtonGroup bg = new ButtonGroup();
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
		setTitle("Register as Refugee");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name = new JTextField();
		name.setToolTipText("Enter your name for the Registration");
		name.setBounds(165, 76, 289, 28);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(10, 74, 94, 28);
		contentPane.add(lblName);
		
		father = new JTextField();
		father.setToolTipText("Enter your name for the Registration");
		father.setColumns(10);
		father.setBounds(165, 115, 289, 28);
		contentPane.add(father);
		
		JLabel lblFatherName = new JLabel("Father Name : ");
		lblFatherName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFatherName.setBounds(10, 113, 145, 28);
		contentPane.add(lblFatherName);
		
		JLabel lblRegion = new JLabel("Belongs To :");
		lblRegion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRegion.setBounds(10, 152, 145, 28);
		contentPane.add(lblRegion);
		
		JLabel lblCampRegion = new JLabel("Camp Address :");
		lblCampRegion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCampRegion.setBounds(10, 191, 145, 28);
		contentPane.add(lblCampRegion);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGender.setBounds(10, 230, 145, 28);
		contentPane.add(lblGender);
		
		JLabel lblReligion = new JLabel("Religion :");
		lblReligion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblReligion.setBounds(10, 269, 145, 28);
		contentPane.add(lblReligion);
		
		JComboBox<String> comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Islam", "Hinduism", "Christian", "Budhist", "Secular"}));
		comboBox.setBounds(165, 269, 289, 28);
		contentPane.add(comboBox);
		
		campAdress = new JTextField();
		campAdress.setToolTipText("Enter your name for the Registration");
		campAdress.setColumns(10);
		campAdress.setBounds(165, 191, 289, 28);
		contentPane.add(campAdress);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setActionCommand("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnMale.setBounds(165, 235, 109, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setActionCommand("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnFemale.setBounds(345, 235, 109, 23);
		contentPane.add(rdbtnFemale);
		
		bg.add(rdbtnFemale);
		bg.add(rdbtnMale);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Yemen", "Afghanistan", "Rohangia", "Syria", "Libia", "Other"}));
		comboBox_1.setBounds(165, 154, 289, 28);
		contentPane.add(comboBox_1);
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			node.name = name.getText();
			node.fname = father.getText();
			node.gender = bg.getSelection().getActionCommand();
			node.CampAddress= campAdress.getText();
			node.Region = comboBox_1.getSelectedItem().toString();
			node.Religion= comboBox.getSelectedItem().toString();
			try {
				FileWriter fw = new FileWriter("refugee.txt",true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(node.name);
				bw.newLine();
				bw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ill.Insert(node);
			dispose();
			new success().setVisible(true);
			}
		});
		btnRegister.setBounds(165, 332, 89, 36);
		contentPane.add(btnRegister);
		
		JLabel lblRegisterationForm = new JLabel("Registeration Form");
		lblRegisterationForm.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblRegisterationForm.setBounds(119, 11, 231, 54);
		contentPane.add(lblRegisterationForm);
	}
	
	
}
