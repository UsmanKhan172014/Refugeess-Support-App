package ChatRoom;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class Server {

	
	private static int uniqueId;
	private ArrayList<ClientThread> al;
	private ServerGUI sg;
	private SimpleDateFormat sdf;
	private int port;
	private boolean keepGoing;
	
	public Server(int port) {
		this(port, null);
	}
	
	public Server(int port, ServerGUI sg) 
	{
		this.sg = sg;
		this.port = port;
		sdf = new SimpleDateFormat("HH:mm:ss");
		al = new ArrayList<ClientThread>();
	}
	
	public void start() {
		keepGoing = true;
	
		try 
		{
			ServerSocket serverSocket = new ServerSocket(port);

			while(keepGoing) 
			{
				display("Server waiting for Clients on port " + port + ".");
				
				// accept connection
				Socket socket = serverSocket.accept();  
				
				if(!keepGoing)
					break;

				ClientThread t = new ClientThread(socket);  
				al.add(t);								
				t.start();
			}
			
			//stop
			try 
			{
				serverSocket.close();

				for(int i = 0; i < al.size(); ++i) 
				{
					ClientThread tc = al.get(i);
					try 
					{
						tc.sInput.close();
						tc.sOutput.close();
						tc.socket.close();
					}
					catch(IOException ioE) 
					{
					}
				}
			}
			catch(Exception e) 
			{
				display("Exception closing the server and clients: " + e);
			}
		}
		catch (IOException e) 
		{
            String msg = sdf.format(new Date()) + " Exception on new ServerSocket: " + e + "\n";
			display(msg);
		}
	}	
	
    /* For the GUI to stop the server*/

	protected void stop() 
	{
		keepGoing = false;
		// connect to myself as Client to exit statement 
		try 
		{
			new Socket("localhost", port);
		}
		catch(Exception e) 
		{
		}
	}
	/* Display an event (not a message) to the console or the GUI*/

	private void display(String msg) 
	{
		String time = sdf.format(new Date()) + " " + msg;
		if(sg == null)
			System.out.println(time);
		else
			sg.appendEvent(time + "\n");
	}

	/*  to broadcast a message to all Clients*/

	private synchronized void broadcast(String message) 
	{
		
		String time = sdf.format(new Date());
		String messageLf = time + " " + message + "\n";

		// display message on console or GUI
		if(sg == null)
			System.out.print(messageLf);
		else
			sg.appendRoom(messageLf);     
		
		// we loop in reverse order in case we would have to remove a Client
		// because it has disconnected

		for(int i = al.size()-1; i >= 0;i--) 
		{
			ClientThread ct = al.get(i);
			
			if(!ct.writeMsg(messageLf)) 
			{
				al.remove(i);
				display("Disconnected Client " + ct.username + " removed from list.");
			}
		}
	}

	// for a client who logoff using the LOGOUT message
	synchronized void remove(int id) 
	{
		// scan the array list until we found the Id
		for(int i = 0; i < al.size(); ++i) 
		{
			ClientThread ct = al.get(i);
			// found it
			if(ct.id == id) 
			{
				al.remove(i);
				return;
			}
		}
	}
	
	/*
	 *  To run as a console application just open a console window and: 
	 * > java Server
	 * > java Server portNumber
	 * If the port number is not specified 7090 is used
	 */ 
	public static void main(String[] args) 
	{
		// start server on port 7090 unless a PortNumber is specified 
		int portNumber = 7090;

		switch(args.length) 
		{
			case 1:
				try
				{
					portNumber = Integer.parseInt(args[0]);
				}
				catch(Exception e) 
				{
					System.out.println("Invalid port number.");
					System.out.println("Usage is: > java Server [portNumber]");
					return;
				}
			case 0:
					break;
			default:
					System.out.println("Usage is: > java Server [portNumber]");
					return;
				
		}
		// create a server object and start it
		Server server = new Server(portNumber);
		server.start();
	}

	/* One instance of this thread will run for each client */

	class ClientThread extends Thread 
		
	{
		
		Socket socket;
		ObjectInputStream sInput;
		ObjectOutputStream sOutput;

		// my unique id (easier for deconnection)
		int id;
		String username;
		ChatMessage cm;
		String date;


		ClientThread(Socket socket) {
			// a unique id
			id = ++uniqueId;
			this.socket = socket;
			
			System.out.println("Thread trying to create Object Input/Output Streams");
			try
			{
				// create output first

				sOutput = new ObjectOutputStream(socket.getOutputStream());
				sInput  = new ObjectInputStream(socket.getInputStream());
		
				username = (String) sInput.readObject();
				display(username + " just connected.");
			}
			catch (IOException e) 
			{
				display("Exception creating new Input/output Streams: " + e);
				return;
			}
			catch (ClassNotFoundException e) {
			}

            date = new Date().toString() + "\n";
		}

		// what will run forever
		public void run() 
		{
			// to loop until LOGOUT

			boolean keepGoing = true;
			while(keepGoing) 
			{
				// read a String (which is an object)
				try 
				{
					cm = (ChatMessage) sInput.readObject();
				}
				catch (IOException e) {
					display(username + " Exception reading Streams: " + e);
					break;				
				}
				catch(ClassNotFoundException e2) {
					break;
				}
				
				String message = cm.getMessage();

				// Switch on the type of message receive
				switch(cm.getType()) 
				{

				case ChatMessage.MESSAGE:
					broadcast(username + ": " + message);
					break;
				case ChatMessage.LOGOUT:
					display(username + " disconnected with a LOGOUT message.");
					keepGoing = false;
					break;
				case ChatMessage.WHOISIN:
					writeMsg("List of the users connected at " + sdf.format(new Date()) + "\n");
					// scan al the users connected
					for(int i = 0; i < al.size(); ++i) {
						ClientThread ct = al.get(i);
						writeMsg((i+1) + ") " + ct.username + " since " + ct.date);
					}
					break;
				}
			}
			// remove myself from the arrayList containing the list of the
			// connected Clients
			remove(id);
			close();
		}
		
		// try to close everything
		private void close() {
			// try to close the connection
			try {
				if(sOutput != null) sOutput.close();
			
				if(sInput != null) sInput.close();
			
				if(socket != null) socket.close();
			}
			catch (Exception e) {}
		}

		/*
		 * Write a String to the Client output stream
		 */
		private boolean writeMsg(String msg) 
		{
			// if Client is still connected send the message to it
			if(!socket.isConnected()) {
				close();
				return false;
			}
			// write the message to the stream
			try {
				sOutput.writeObject(msg);
			}
			
			catch(IOException e) {
				display("Error sending message to " + username);
				display(e.toString());
			}
			return true;
		}
	}

}


