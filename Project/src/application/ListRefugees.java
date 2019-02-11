package application;

import java.awt.BorderLayout;
import Linklist.ImplementLinkList;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

public class ListRefugees extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private DefaultListModel dlm = new DefaultListModel<String>();
	private JButton btnLoad;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListRefugees frame = new ListRefugees();
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
	public ListRefugees() {
		
		setTitle("Refugee's List");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 453, 495);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOption = new JMenu("Option");
		menuBar.add(mnOption);
		
		JMenuItem mntmMainMenu = new JMenuItem("");
		mntmMainMenu.setIcon(new ImageIcon(ListRefugees.class.getResource("/images/home.PNG")));
		mntmMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			new MainWindows().setVisible(true);
			}
		});
		mnOption.add(mntmMainMenu);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JList list = new JList();
		list.setBounds(10, 81, 421, 376);
		contentPane.add(list);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
			DefaultListModel<String> filter = new DefaultListModel<String>();
			try {
				FileReader fr = new FileReader("refugee.txt");
				BufferedReader br = new BufferedReader(fr);
				ArrayList aal = new ArrayList();
				String val;
				while((val=br.readLine())!=null) {
					aal.add(val);
				}
				aal.stream().forEach((start)->{
					String name = aal.toString().toLowerCase();
					if (name.contains(textField.getText().toLowerCase())) {
						filter.addElement((String) start);
					}
					dlm = filter;
					list.setModel(dlm);
				});
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		});
		
		textField.setBounds(10, 25, 322, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		btnLoad = new JButton("load");
		btnLoad.addActionListener(new ActionListener() {
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent arg0) {
			FileReader fr;
			try {
				fr = new FileReader("refugee.txt");
				BufferedReader br = new BufferedReader(fr);
				String data;
				while ((data=br.readLine())!=null) {
					dlm.addElement(data);
				}
				list.setModel(dlm);
				list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				br.close();
				fr.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			}
		});
		btnLoad.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLoad.setBounds(342, 23, 89, 38);
		contentPane.add(btnLoad);
	}
}
