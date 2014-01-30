// Fig. 24.5: Server.java
// Set up a Server that will receive a connection from a client, send 
// a string to the client, and close the connection.
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.Color;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Server extends JFrame {
	private JTextField enterField; // inputs message from user
	private JTextArea displayArea; // display information to user
	private ObjectOutputStream output; // output stream to client
	private ObjectInputStream input; // input stream from client
	private ServerSocket serverSocket; // server socket
	private Socket connection; // connection to client
	private int counter = 1; // counter of number of connections

	// set up GUI
	public Server() {
		//Why is this super called here? It calls the constructor for 
		//Server passing the string "Server" as an argument???? What constructor!
		//And why does the program work when this is commented out???
		//super("Server");
		
		initUI();
	}

	private void initUI() {

	    
		enterField = new JTextField(); // create enterField
		enterField.setEditable(false);
		enterField.addActionListener(new ActionListener() {
			// send message to client
			public void actionPerformed(ActionEvent event) {
				sendData(event.getActionCommand());
				enterField.setText("");
			} // end method actionPerformed
		} // end anonymous inner class
				); // end call to addActionListener

		add(enterField, BorderLayout.NORTH);

		displayArea = new JTextArea(); // create displayArea
		add(new JScrollPane(displayArea), BorderLayout.CENTER);

		setSize(600, 400); // set size of window
		setVisible(true); // show window
		
		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem eMenuItem = new JMenuItem("Exit");
		eMenuItem.setMnemonic(KeyEvent.VK_E);
	    eMenuItem.setToolTipText("Exit application");

		
		
				
				
				eMenuItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						System.exit(0);
					}
				});
				
	JButton btn = new JButton("Exit");
				btn.setBounds(100,80, 60, 20);
				
				
				btn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent event) {
						System.exit(0);
					}
				});
				
				file.add(eMenuItem);

		       menubar.add(file);

		       setJMenuBar(menubar);

				displayArea.add(btn);

				//setTitle("Tool Tip");
				//setSize(300, 200);
				setLocationRelativeTo(null);
				//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		
		
		
		
		
		
		
		
		
	} // end Server constructor

	// set up and run server
	public void runServer() {
		try // set up server to receive connections; process connections
		{
			serverSocket = new ServerSocket(12345, 100); // Creates a server
															// socket and binds
															// it to the
															// specified local
															// port number, with
															// the specified
															// backlog
															// ServerSocket(int
															// port, int
															// backlog)

			while (true) {
				try {
					waitForConnection(); // wait for a connection
					getStreams(); // get input & output streams
					processConnection(); // process connection
				} // end try
				catch (EOFException eofException) {
					displayMessage("\nServer terminated connection");
				} // end catch
				finally {
					closeConnection(); // close connection
					counter++;
				} // end finally
			} // end while
		} // end try
		catch (IOException ioException) {
			ioException.printStackTrace();
		} // end catch
	} // end method runServer

	// wait for connection to arrive, then display connection info
	private void waitForConnection() throws IOException {
		displayMessage("Waiting for connection\n");
		connection = serverSocket.accept(); // allow server to accept connection
		displayMessage("Connection " + counter + " received from: "
				+ connection.getInetAddress().getHostName());
	} // end method waitForConnection

	// get streams to send and receive data
	private void getStreams() throws IOException {
		// set up output stream for objects
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush(); // flush output buffer to send header information

		// set up input stream for objects
		input = new ObjectInputStream(connection.getInputStream());

		displayMessage("\nGot I/O streams\n");
	} // end method getStreams

	// process connection with client
	private void processConnection() throws IOException {
		String message = "Connection successful";
		sendData(message); // send connection successful message

		// enable enterField so server user can send messages
		setTextFieldEditable(true);

		do // process messages sent from client
		{
			try // read message and display it
			{
				message = (String) input.readObject(); // read new message
				displayMessage("\n" + message); // display message
			} // end try
			catch (ClassNotFoundException classNotFoundException) {
				displayMessage("\nUnknown object type received");
			} // end catch

		} while (!message.equals("CLIENT>>> TERMINATE"));
	} // end method processConnection

	// close streams and socket
	private void closeConnection() {
		displayMessage("\nTerminating connection\n");
		setTextFieldEditable(false); // disable enterField

		try {
			output.close(); // close output stream
			input.close(); // close input stream
			connection.close(); // close socket
		} // end try
		catch (IOException ioException) {
			ioException.printStackTrace();
		} // end catch
	} // end method closeConnection

	// send message to client
	private void sendData(String message) {
		try // send object to client
		{
			output.writeObject("SERVER>>> " + message);
			output.flush(); // flush output to client
			displayMessage("\nSERVER>>> " + message);
		} // end try
		catch (IOException ioException) {
			displayArea.append("\nError writing object");
		} // end catch
	} // end method sendData

	// manipulates displayArea in the event-dispatch thread
	private void displayMessage(final String messageToDisplay) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() // updates displayArea
			{
				displayArea.append(messageToDisplay); // append message
			} // end method run
		} // end anonymous inner class
				); // end call to SwingUtilities.invokeLater
	} // end method displayMessage

	// manipulates enterField in the event-dispatch thread
	private void setTextFieldEditable(final boolean editable) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() // sets enterField's editability
			{
				enterField.setEditable(editable);
			} // end method run
		} // end inner class
				); // end call to SwingUtilities.invokeLater
	} // end method setTextFieldEditable
} // end class Server

/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/
