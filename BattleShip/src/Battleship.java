import javax.swing.JTextField;

/**
 *
 * @author Rob Close
 */

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

public class Battleship extends javax.swing.JFrame {

	// Variables declaration
	private javax.swing.JButton connectButton;
	private javax.swing.JButton hostButton;
	private javax.swing.JButton readyButton;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea userChatDisplay;
	private javax.swing.JTextArea serverMessageDisplay;
	private javax.swing.JTextField userChatEnter;// user chat field
	private javax.swing.JTextField ipAddressEnter;// ip address
	private ObjectOutputStream output; // output stream to client
	private ObjectInputStream input; // input stream from client
	private ServerSocket serverSocket; // server socket
	private Socket connection; // connection to client
	private int counter = 1; // counter of number of connections

	// End of variables declaration

	public Battleship() {

		initComponents();

	}

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane2 = new javax.swing.JScrollPane();
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		userChatEnter = new JTextField();
		userChatDisplay = new JTextArea();
		jPanel2 = new javax.swing.JPanel();
		readyButton = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		hostButton = new javax.swing.JButton();
		ipAddressEnter = new javax.swing.JTextField();
		connectButton = new javax.swing.JButton();
		serverMessageDisplay = new javax.swing.JTextArea();
		jPanel3 = new javax.swing.JPanel();
		jPanel4 = new javax.swing.JPanel();
		jPanel5 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		ipAddressEnter.setEditable(false);

		/*
		 * ipAddressEnter.addActionListener(new ActionListener() { // send
		 * message to client public void actionPerformed(ActionEvent event) {
		 * sendData(event.getActionCommand()); serverMessageDisplay.setText("");
		 * } // end method actionPerformed } // end anonymous inner class ); //
		 * end call to addActionListener
		 */
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
				"Message Center", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.DEFAULT_POSITION));

		jLabel1.setText("Message: ");

		userChatEnter.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jScrollPane2.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Chat Log: "));

		userChatDisplay.setColumns(20);
		userChatDisplay.setRows(5);
		jScrollPane2.setViewportView(userChatDisplay);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(
																jScrollPane2)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel1)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				userChatEnter,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				300,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addComponent(
												jScrollPane2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																userChatEnter,
																javax.swing.GroupLayout.Alignment.TRAILING,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jLabel1,
																javax.swing.GroupLayout.Alignment.TRAILING))
										.addContainerGap()));

		jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
				"Control Panel", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font(
						"Times New Roman", 1, 10))); // NOI18N

		readyButton.setText("Ready!");

		jLabel5.setText("Position Ships and push when ready");

		jLabel6.setText("Host Game:");

		jLabel9.setText("Host IP Address");

		hostButton.setLabel("Host");
		hostButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				button2ActionPerformed(evt);
			}
		});

		connectButton.setLabel("Connect");

		serverMessageDisplay.setColumns(20);
		serverMessageDisplay.setRows(5);
		jScrollPane1.setViewportView(serverMessageDisplay);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(jPanel2Layout.createSequentialGroup()
			.addContainerGap(115, Short.MAX_VALUE)
			.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,jPanel2Layout.createSequentialGroup().addComponent(readyButton).addGap(145,145,160))
					.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,jPanel2Layout.createSequentialGroup()
					.addComponent(jLabel5).addGap(101,101,101))))
		.addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,false)
				.addComponent(jScrollPane1,javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup()
				.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,false)
				.addComponent(jLabel9,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
				.addComponent(jLabel6,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(hostButton,javax.swing.GroupLayout.PREFERRED_SIZE,62,javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addComponent(ipAddressEnter,javax.swing.GroupLayout.PREFERRED_SIZE,115,javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(connectButton,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE)))))
						.addGap(0, 0, Short.MAX_VALUE)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,jPanel2Layout.createSequentialGroup()
					.addGap(20, 20, 20)
				.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,false)
				.addComponent(jLabel6,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
				.addComponent(hostButton,javax.swing.GroupLayout.PREFERRED_SIZE,0,Short.MAX_VALUE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,false)
				.addComponent(connectButton,javax.swing.GroupLayout.PREFERRED_SIZE,0,Short.MAX_VALUE)
				.addComponent(jLabel9,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
				.addComponent(ipAddressEnter,javax.swing.GroupLayout.PREFERRED_SIZE,0,Short.MAX_VALUE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(jScrollPane1,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,363, Short.MAX_VALUE)
				.addComponent(jLabel5,javax.swing.GroupLayout.PREFERRED_SIZE,30,javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(readyButton)
				.addContainerGap()));

		jPanel3.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Enemy Board"));

		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
				jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0,
				Short.MAX_VALUE));
		jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 277,
				Short.MAX_VALUE));

		jPanel4.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Player Board"));

		javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
				jPanel4);
		jPanel4.setLayout(jPanel4Layout);
		jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0,
				Short.MAX_VALUE));
		jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 277,
				Short.MAX_VALUE));
		jPanel5.setBorder(javax.swing.BorderFactory
				.createTitledBorder("Ship Inventory"));

		jLabel2.setIcon(new javax.swing.ImageIcon("Battleship.jpg")); // NOI18N
		jLabel2.setText("Battleship");
		jLabel2.setPreferredSize(new java.awt.Dimension(80, 60));

		jLabel3.setIcon(new javax.swing.ImageIcon("Cruiser.jpg")); // NOI18N
		jLabel3.setText("Crusier");
		jLabel3.setPreferredSize(new java.awt.Dimension(60, 60));

		jLabel4.setIcon(new javax.swing.ImageIcon("Submarine.jpg")); // NOI18N
		jLabel4.setText("Submarine");
		jLabel4.setPreferredSize(new java.awt.Dimension(60, 60));

		jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"carrier.jpg"))); // NOI18N
		jLabel7.setText("Carrier");
		jLabel7.setPreferredSize(new java.awt.Dimension(100, 60));

		jLabel8.setIcon(new javax.swing.ImageIcon("Destroyer.jpg")); // NOI18N
		jLabel8.setText("Destroyer");
		jLabel8.setPreferredSize(new java.awt.Dimension(40, 20));

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
				jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup().addContainerGap()
				.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup().addComponent(jLabel2,javax.swing.GroupLayout.PREFERRED_SIZE,80,javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(31,31,31)
				.addComponent(jLabel3,javax.swing.GroupLayout.PREFERRED_SIZE,60,javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(27,27,27)
				.addComponent(jLabel4,javax.swing.GroupLayout.PREFERRED_SIZE,60,javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(jPanel5Layout.createSequentialGroup().addGap(37,37,37)
				.addComponent(jLabel8,javax.swing.GroupLayout.PREFERRED_SIZE,40,javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(62,62,62)
				.addComponent(jLabel7,javax.swing.GroupLayout.PREFERRED_SIZE,100,javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)));
		jPanel5Layout
				.setVerticalGroup(jPanel5Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanel5Layout.createSequentialGroup().addGap(29, 29, 29)
						.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,false)
						.addComponent(jLabel4,javax.swing.GroupLayout.DEFAULT_SIZE,20,Short.MAX_VALUE)
						.addComponent(jLabel3,javax.swing.GroupLayout.Alignment.TRAILING,javax.swing.GroupLayout.PREFERRED_SIZE,0,Short.MAX_VALUE)
						.addComponent(jLabel2,javax.swing.GroupLayout.Alignment.TRAILING,javax.swing.GroupLayout.PREFERRED_SIZE,0,Short.MAX_VALUE))
						.addGap(22, 22, 22)
						.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,false)
						.addComponent(jLabel7,javax.swing.GroupLayout.PREFERRED_SIZE,0,Short.MAX_VALUE)
						.addComponent(jLabel8,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,false)
						.addComponent(jPanel1,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
						.addComponent(jPanel2,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
								.addComponent(jPanel5,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
								.addComponent(jPanel4,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
								.addComponent(jPanel3,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,layout.createSequentialGroup()
				.addGap(17, 17, 17)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
					.addComponent(jPanel3,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(jPanel4,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE))
					.addComponent(jPanel2,javax.swing.GroupLayout.PREFERRED_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,false)
								.addComponent(jPanel1,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE)
								.addComponent(jPanel5,javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE,Short.MAX_VALUE))
								.addContainerGap()));

		pack();
	}// </editor-fold>

	private void button2ActionPerformed(java.awt.event.ActionEvent evt) {
		runServer(); // run server application
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	public void runServer() {
		try // set up server to receive connections; process connections
		{
			serverSocket = new ServerSocket(12345, 100);
			// Creates a server socket and binds it to the specified local
			// port number, with the specified backlog ServerSocket(int port,
			// int backlog)

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
		// It gets stuck here at this
		// command**********************************************************************************************************************
		connection = serverSocket.accept(); // allow server to accept connection

		System.out.println("gets here after display message line 649");

		displayMessage("Connection " + counter + " received from: "
				+ connection.getInetAddress().getHostName());
	} // end method waitForConnection

	// get streams to send and receive data
	private void getStreams() throws IOException {

		System.out.println("getStreams function line 658################");
		// set up output stream for objects
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush(); // flush output buffer to send header information

		// set up input stream for objects
		input = new ObjectInputStream(connection.getInputStream());
		displayMessage("\nGot I/O streams\n");
	} // end method getStreams

	// process connection with client
	private void processConnection() throws IOException {

		String message = "Connection successful *sent from server*";
		sendData(message); // send connection successful message
		// enable enterField so server user can send messages
		setTextFieldEditable(true);

		do // process messages sent from client
		{
			try // read message and display it
			{
				System.out
						.println("processConnection function line 682################");
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

	private void sendData(String message) {
		try // send object to client
		{
			output.writeObject("SERVER>>> " + message);
			output.flush(); // flush output to client
			displayMessage("\nSERVER>>> " + message);
		} // end try
		catch (IOException ioException) {
			userChatDisplay.append("\nError writing object");
		} // end catch
	} // end method sendData

	private void displayMessage(final String messageToDisplay) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() // updates displayArea
			{

				serverMessageDisplay.append(messageToDisplay); // append message
			} // end method run
		} // end anonymous inner class
				); // end call to SwingUtilities.invokeLater
	} // end method displayMessage

	// manipulates enterField in the event-dispatch thread
	private void setTextFieldEditable(final boolean editable) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() // sets enterField's editability
			{
				userChatEnter.setEditable(editable);
			} // end method run
		} // end inner class
				); // end call to SwingUtilities.invokeLater
	} // end method setTextFieldEditable

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed"
		// desc=" Look and feel setting code (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the
		 * default look and feel. For details see
		 * http://download.oracle.com/javase
		 * /tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Battleship.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Battleship.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Battleship.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Battleship.class.getName()).log(
					java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Battleship().setVisible(true);
			}
		});
	}

}
