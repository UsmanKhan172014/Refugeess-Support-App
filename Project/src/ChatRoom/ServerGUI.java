package ChatRoom;
import javax.swing.*;

import ChatRoom.Server;
import application.MainWindows;
import supporter.Supporter;

import java.awt.*;
import java.awt.event.*;


public class ServerGUI extends JFrame implements ActionListener, WindowListener {
	
	private static final long serialVersionUID = 1L;
	private JButton stopStart;
	private JTextArea chat, event;
	private JTextField tPortNumber;
	private Server server;
	
	public ServerGUI(int port) {


		super("Chat Server");
		server = null;
		
		// in the NorthPanel the PortNumber the Start and Stop buttons
		
		JPanel north = new JPanel(new BorderLayout());
		JPanel p=new JPanel();
		JLabel l=new JLabel(new ImageIcon("ChatRoom/images/bak14.jpg"));
		north.add(l,"North");
		north.add(new JLabel("Port number: "));

		tPortNumber = new JTextField("  " + port,10);

		tPortNumber.setFont(new Font("Calibri", Font.BOLD, 20));
		p.add(tPortNumber);
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
		// to stop or start the server, we start with "Start"
		stopStart = new JButton("Start");
		stopStart.setBackground(Color.BLACK);
		stopStart.setForeground(Color.WHITE);
		stopStart.setFont(new Font("Calibri", Font.BOLD, 15));
		stopStart.addActionListener(this);
		p.add(stopStart);
		north.add(p,"South");
		add(north, BorderLayout.NORTH);
		north.setBackground(Color.black);
		p.setBackground(Color.orange);
		
		// the event and chat room

		JPanel center = new JPanel(new GridLayout(2,1));

		chat = new JTextArea(10,20)
		{
			Image image =new ImageIcon("ChatRoom/images/bak13.jpg").getImage();// imageIcon.getImage();

			  Image grayImage = GrayFilter.createDisabledImage(image);
			  {
				setOpaque(false);
			  }

			  public void paint(Graphics g) {
				  
				g.drawImage(grayImage, 0, 0,getWidth(),getHeight(), this);
				super.paint(g);
				
			  }
				};
		chat.setEditable(false);
		chat.setWrapStyleWord(true);
		chat.setFont(new Font("Arial",Font.BOLD,19));
		chat.setForeground(Color.red);
		appendRoom("Chat room.\n");

		center.add(new JScrollPane(chat));

		event = new JTextArea(10,20){
			Image image =new ImageIcon("ChatRoom/images/bak16.jpg").getImage();// imageIcon.getImage();

			  Image grayImage = GrayFilter.createDisabledImage(image);
			  {
				setOpaque(false);
			  }

			  public void paint(Graphics g) {
				  
				g.drawImage(grayImage, 0, 0,getWidth(),getHeight(), this);
				super.paint(g);
				
			  }
		};
		event.setFont(new Font("Arial",Font.BOLD,19));
		event.setForeground(Color.RED);
		event.setEditable(false);

		appendEvent("Events log.\n");
		center.add(new JScrollPane(event));	

		add(center);
		
		// need to be informed when the user click the close button on the frame
		addWindowListener(this);
		setSize(600, 700);
		setVisible(true);
	}		

	// append message to the two JTextArea
	// position at the end
	void appendRoom(String str) {
		chat.append(str);
		chat.setCaretPosition(chat.getText().length() - 1);
	}
	void appendEvent(String str) {
		event.append(str);
		event.setCaretPosition(chat.getText().length() - 1);
		
	}
	
	// start or stop where clicked
	public void actionPerformed(ActionEvent e) 
	{
		// if running we have to stop
		if(server != null) 
		{
			server.stop();
			server = null;
			tPortNumber.setEditable(true);
			stopStart.setText("Start");
			return;
		}
      	// OK start the server	
		int port;
		try {
			port = Integer.parseInt(tPortNumber.getText().trim());
		}
		catch(Exception er) {
			appendEvent("Invalid port number");
			return;
		}
		// create a new Server
		server = new Server(port, this);
		// and start it as a thread
		new ServerRunning().start();
		stopStart.setText("Stop");
		tPortNumber.setEditable(false);
	}
	
	// entry point to start the Server
	public static void main(String[] arg) 
	{
		// start server default port 7000
		new ServerGUI(7000);
	}

	
	public void windowClosing(WindowEvent e) {
		
		if(server != null) {
			try {
				server.stop();			
			}
			catch(Exception eClose) {
			}
			server = null;
		}
		// dispose the frame
		dispose();
		System.exit(0);
	}
	
	public void windowClosed(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}


	class ServerRunning extends Thread 
	{
		public void run() 
		{
			server.start();   

	//-------------if failed---------------------//

			stopStart.setText("Start");
			tPortNumber.setEditable(true);
			appendEvent("Server crashed\n");
			server = null;
		}
	}

}

