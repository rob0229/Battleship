import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Rob
 */
public class Battleship extends JFrame {
	
	 // Variables declaration -                     
    private javax.swing.JButton connectButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JPanel enemyPanel;
    private javax.swing.JButton hostButton;
    private java.awt.TextField ipAddressField;
    private javax.swing.JLabel messageLabel1;
    private javax.swing.JLabel battleshipImageLabel;
    private javax.swing.JLabel crusierImageLabel;
    private javax.swing.JLabel submarineImageLabel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel hostGameLabel;
    private static javax.swing.JLabel carrierImageLabel;
    private javax.swing.JLabel destroyerImageLabel;
    private javax.swing.JLabel hostIPAdressLabel9;
    private javax.swing.JPanel informationPanel;
    private javax.swing.JPanel enemyRemainingPanel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel messagePanel;
    private javax.swing.JTextArea messageTextArea;
    private JPanel playerPanel;
    private javax.swing.JButton readyButton;
    private javax.swing.JPanel shipInventory;
    private javax.swing.JTextField userChatEnter;     
    private EnemyGrid enemyGrid; //
    private PlayerGrid playerGrid; //
    Ship carrier = new Ship();
    Ship battleship = new Ship();
    Ship sub = new Ship();
    Ship destroyer = new Ship();
    Ship crusier = new Ship();
    //Server and Client Variables
        private ObjectOutputStream output; // output stream to client
        private ObjectInputStream input; // input stream from client
        private ServerSocket serverSocket; // server socket
        private Socket connection; // connection to client
        private int counter = 1; // counter of number of connections
        private String ipAddress;
        private ObjectOutputStream outputClient; // output stream to server
        private ObjectInputStream inputClient; // input stream from server
        private String message = ""; // message from server
        private String chatServer; // host server for this application
        private Socket client; // socket to communicate with server
        private Boolean isServer = false;     
     
    /**
     * Creates new form Battleship
     */
    public Battleship() {
        initComponents();
    }
    
    
       @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	   
    	
        messagePanel = new JPanel();
        messageLabel1 = new JLabel();
        userChatEnter = new JTextField();
        jScrollPane2 = new JScrollPane();
        messageTextArea = new JTextArea();
        controlPanel = new JPanel();
        readyButton = new JButton();
        jLabel5 = new JLabel();
        hostGameLabel = new JLabel();
        hostIPAdressLabel9 = new JLabel();
        ipAddressField = new java.awt.TextField();
        disconnectButton = new JButton();
        connectButton = new JButton();
        hostButton = new JButton();
        informationPanel = new JPanel();
        
        shipInventory = new JPanel();
        crusierImageLabel = new JLabel();
        submarineImageLabel = new JLabel();
        carrierImageLabel = new JLabel();
        destroyerImageLabel = new JLabel();
        battleshipImageLabel = new JLabel();
        enemyRemainingPanel = new JPanel();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Battleship");
        setResizable(false);
        
        //Creates player panel and enemy panel with listeners
        playerPanel = new JPanel(){
        	Image image = Toolkit.getDefaultToolkit().getImage("oceanGrid.png");
            public void paintComponent( Graphics g )
            {
                 super.paintComponent(g);
                 g.drawImage( image, 0, 0, this );
            }	
       
        	
        	
        };   
    	playerGrid = new PlayerGrid();
    	enemyPanel = new JPanel();
    	enemyGrid = new EnemyGrid(enemyPanel);   
    	new MyDropTargetListener(playerPanel);      
        messagePanel.setBorder(BorderFactory.createTitledBorder(null, "Message Center", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
        messageLabel1.setText("Message: ");

        userChatEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                userChatEnterActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(BorderFactory.createTitledBorder("Radio Room"));

        messageTextArea.setColumns(20);
        messageTextArea.setLineWrap(true);
        messageTextArea.setRows(5);
        jScrollPane2.setViewportView(messageTextArea);

        javax.swing.GroupLayout messagePanelLayout = new GroupLayout(messagePanel);
        messagePanel.setLayout(messagePanelLayout);
        messagePanelLayout.setHorizontalGroup(
            messagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(messagePanelLayout.createSequentialGroup()
                //.addGap(16, 16, 16)
                .addGroup(messagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(messagePanelLayout.createSequentialGroup()
                        .addComponent(messageLabel1)
                        //.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userChatEnter))))
        );
        messagePanelLayout.setVerticalGroup(
            messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messagePanelLayout.createSequentialGroup()
                //.addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userChatEnter)
                    .addComponent(messageLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        controlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control Panel", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        readyButton.setText("Ready!");

        jLabel5.setText("Position Ships and push when ready");

        hostGameLabel.setText("Host Game:");

        hostIPAdressLabel9.setText("Host IP Address");

        ipAddressField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipAddressFieldActionPerformed(evt);
            }
        });

        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	//if user enters ip address and clicks connect, the value in ipAddress
            	//will be updated before a call to the connect function
            	//ipAddressFieldActionPerformed(evt);
                connectButtonActionPerformed(evt);
            }
        });

        hostButton.setText("Host");
        hostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostButtonActionPerformed(evt);
            }
        });

        informationPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        informationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));
        javax.swing.GroupLayout informationPanelLayout = new javax.swing.GroupLayout(informationPanel);
        informationPanel.setLayout(informationPanelLayout);
        informationPanelLayout.setHorizontalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            //.addGap(0, 0, Short.MAX_VALUE)
        );
        informationPanelLayout.setVerticalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 101, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(informationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(controlPanelLayout.createSequentialGroup()
                                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(hostIPAdressLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hostGameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ipAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                                        .addComponent(hostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)))
                                .addGap(18, 18, 18)
                                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(disconnectButton)
                                    .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(controlPanelLayout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(readyButton))
                            .addGroup(controlPanelLayout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel5)))
                        .addGap(0, 35, Short.MAX_VALUE)))
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hostGameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(disconnectButton)
                        .addComponent(hostButton)))
                .addGap(21, 21, 21)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ipAddressField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hostIPAdressLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(connectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(readyButton))
        );
        
        
      
        enemyPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Enemy Board"));
        enemyPanel.setLayout(new GridLayout(10,10,0,0));
        
        playerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Player Board"));
      
        //allows ships to be dropped anywhere on panel
        playerPanel.setLayout(null);
        
        
        //Ship Panel Layout
        shipInventory.setBorder(javax.swing.BorderFactory.createTitledBorder("Ship Inventory"));

        crusierImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("Cruiser.jpg"))); // NOI18N
        crusierImageLabel.setText("Crusier");
        crusierImageLabel.setPreferredSize(new java.awt.Dimension(120, 60));

        submarineImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("Submarine.jpg"))); // NOI18N
        submarineImageLabel.setText("Submarine");
        submarineImageLabel.setPreferredSize(new java.awt.Dimension(90, 60));

        carrierImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("carrier.jpg"))); // NOI18N
        carrierImageLabel.setText("Carrier");
        carrierImageLabel.setPreferredSize(new java.awt.Dimension(150, 60));

        destroyerImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("Destroyer.jpg"))); // NOI18N
        destroyerImageLabel.setText("Destroyer");
        destroyerImageLabel.setPreferredSize(new java.awt.Dimension(60, 20));

        battleshipImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("Battleship.png"))); // NOI18N
        battleshipImageLabel.setText("Battleship");
        battleshipImageLabel.setPreferredSize(new java.awt.Dimension(120, 60));

        javax.swing.GroupLayout shipInventoryLayout = new javax.swing.GroupLayout(shipInventory);
        shipInventory.setLayout(shipInventoryLayout);
        shipInventoryLayout.setHorizontalGroup(
            shipInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shipInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(shipInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(crusierImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submarineImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)                
                    .addComponent(carrierImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(destroyerImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(battleshipImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        shipInventoryLayout.setVerticalGroup(
            shipInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shipInventoryLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(battleshipImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(destroyerImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submarineImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carrierImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(crusierImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        
        //Adds drag listener to ship inventory panel
        MyDragGestureListener dlistener = new MyDragGestureListener();
        DragSource ds1 = new DragSource();    
        ds1.createDefaultDragGestureRecognizer(battleshipImageLabel, DnDConstants.ACTION_COPY, dlistener);
        ds1.createDefaultDragGestureRecognizer(carrierImageLabel, DnDConstants.ACTION_COPY, dlistener);
        ds1.createDefaultDragGestureRecognizer(crusierImageLabel, DnDConstants.ACTION_COPY, dlistener);
        ds1.createDefaultDragGestureRecognizer(destroyerImageLabel, DnDConstants.ACTION_COPY, dlistener);
        ds1.createDefaultDragGestureRecognizer(submarineImageLabel, DnDConstants.ACTION_COPY, dlistener);

        //populate this panel with ship images and turn ren once they have been destroyed
        enemyRemainingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Enemy Ships Remaining"));

        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(enemyRemainingPanel);
        enemyRemainingPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(messagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(enemyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shipInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enemyRemainingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(messagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(enemyRemainingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(enemyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(shipInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    
      
   
        
        pack();
    }// </editor-fold>                        
  
  
    private void userChatEnterActionPerformed(java.awt.event.ActionEvent evt) {                                              
      if (isServer == true){
       sendData( evt.getActionCommand() );
        userChatEnter.setText( "" );
      }
      else{
          sendDataClient( evt.getActionCommand() );
        userChatEnter.setText( "" );
      }
  
    }                                             

    private void ipAddressFieldActionPerformed(java.awt.event.ActionEvent evt) {                                               
       sendData( evt.getActionCommand() );
       ipAddressField.setText( "" );
       ipAddress=ipAddressField.getText();
    }                                              

    private void hostButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
         hostButton.setEnabled(false);
        connectButton.setEnabled(false);
        isServer = true;
	   	  {
	   		Runnable serverRunnable = new Runnable(){
				@Override
				public void run() {
					runServer();// TODO Auto-generated method stub				
				}
   		
	   	  };
	   	  Thread serverThread = new Thread(serverRunnable);
	   	  serverThread.start(); // run server application
			
		}
    }                                          
  
    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
         connectButton.setEnabled(false);
        hostButton.setEnabled(false);		 
	   	  {
	   		Runnable serverRunnable = new Runnable(){
				@Override
				public void run() {
					runClient(ipAddress);// TODO Auto-generated method stub	
				}		
	   	  };
	   	  Thread serverThread = new Thread(serverRunnable);
	   	  serverThread.start(); // run server application			
		}
    }                                             

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 

            closeConnection();

    }                                                

    /*Start of server Methods*/ 

// set up and run server 
    private void runServer(){
	      try // set up server to receive connections; process connections
	      {
	         serverSocket = new ServerSocket( 12345, 100 ); // create ServerSocket

	         while ( true ) 
	         {
	            try 
	            {
	               waitForConnection(); // wait for a connection
	               getStreams(); // get input & output streams
	               processConnection(); // process connection
	            } // end try
	            catch ( EOFException eofException ) 
	            {
	               displayMessage( "\nHost terminated connection" );
	            } // end catch
	            finally 
	            {
	               closeConnection(); //  close connection
	               counter++;
	            } // end finally
	         } // end while
	      } // end try
	      catch ( IOException ioException ) 
	      {
	         ioException.printStackTrace();
	      } // end catch
	   } // end method runServer

	   // wait for connection to arrive, then display connection info
    private void waitForConnection() throws IOException{
	      displayMessage( "Waiting for connection\n" );
	      connection = serverSocket.accept(); // allow server to accept connection            
	      displayMessage( "Connection " + counter + " received from: " +
	         connection.getInetAddress().getHostName() );
	   } // end method waitForConnection

	   // get streams to send and receive data
    private void getStreams() throws IOException{
	      // set up output stream for objects
	      output = new ObjectOutputStream( connection.getOutputStream() );
	      output.flush(); // flush output buffer to send header information

	      // set up input stream for objects
	      input = new ObjectInputStream( connection.getInputStream() );

	      displayMessage( "\nGot I/O streams\n" );
	   } // end method getStreams

	   // process connection with client
    private void processConnection() throws IOException{
	      String message = "Connection successful, *sent from server* ";
	      sendData( message ); // send connection successful message

	      // enable enterField so server user can send messages
	      setTextFieldEditable( true );

	      do // process messages sent from client
	      { 
	         try // read message and display it
	         {
	            message = ( String ) input.readObject(); // read new message
	            displayMessage( "\n" + message ); // display message
	         } // end try
	         catch ( ClassNotFoundException classNotFoundException ) 
	         {
	            displayMessage( "\nUnknown object type received" );
	         } // end catch

	      } while ( !message.equals( "CLIENT>>> TERMINATE" ) );
	   } // end method processConnection

	   // close streams and socket
    private void closeConnection() {
	      displayMessage( "\nTerminating connection\n" );
	      setTextFieldEditable( false ); // disable enterField
                connectButton.setEnabled(true);
                hostButton.setEnabled(true);
	      try 
	      {
	         output.close(); // close output stream
	         input.close(); // close input stream
	         connection.close(); // close socket
	      } // end try
	      catch ( IOException ioException ) 
	      {
	         ioException.printStackTrace();
	      } // end catch
                        
        //allows for multiple connections without restarting game
             
	   } // end method closeConnection

	   // send message to client
    private void sendData( String message ) {
	      try // send object to client
	      {
	         output.writeObject( "SERVER>>> " + message );
	         output.flush(); // flush output to client
	         displayMessage( "\nSERVER>>> " + message );
	      } // end try
	      catch ( IOException ioException ) 
	      {
	         messageTextArea.append( "\nError writing object" );
	      } // end catch
	   } // end method sendData

	   // manipulates displayArea in the event-dispatch thread
    private void displayMessage( final String messageToDisplay ){
	      SwingUtilities.invokeLater(
	         new Runnable() 
	         {
	            public void run() // updates displayArea
	            {
	            	messageTextArea.append( messageToDisplay ); // append message
	            } // end method run
	         } // end anonymous inner class
	      ); // end call to SwingUtilities.invokeLater
	   } // end method displayMessage

	   // manipulates enterField in the event-dispatch thread
    private void setTextFieldEditable( final boolean editable ){
	      SwingUtilities.invokeLater(
	         new Runnable()
	         {
	            public void run() // sets enterField's editability
	            {
	               userChatEnter.setEditable( editable );
	            } // end method run
	         }  // end inner class
	      ); // end call to SwingUtilities.invokeLater
	   } // end method setTextFieldEditable

           //set up and run client
    private void runClient(String ipAddress){
     try // connect to server, get streams, process connection
      {
         connectToServer(); // create a Socket to make connection
         getStreamsClient(); // get the input and output streams
         processConnectionClient(); // process connection
      } // end try
      catch ( EOFException eofException ) 
      {
         displayMessage( "\nClient terminated connection" );
      } // end catch
      catch ( IOException ioException ) 
      {
         ioException.printStackTrace();
      } // end catch
     
      finally 
      {
          System.out.println("  gets to here run client line 514  ");
         closeConnectionClient(); // close connection
      } // end finally
    
    }
    
           // connect to server
   private void connectToServer() throws IOException{      
      displayMessage( "Attempting connection\n" );

      // create Socket to make connection to server
      client = new Socket( InetAddress.getByName( chatServer ), 12345 );

      // display connection information
      displayMessage( "Connected to: " + 
         client.getInetAddress().getHostName() );
   } // end method connectToServer

           // get streams to send and receive data
   private void getStreamsClient() throws IOException{
      // set up output stream for objects
      outputClient = new ObjectOutputStream( client.getOutputStream() );      
      outputClient.flush(); // flush output buffer to send header information

      // set up input stream for objects
      input = new ObjectInputStream( client.getInputStream() );

      displayMessage( "\nGot I/O streams\n" );
   } // end method getStreams

           // process connection with server
   private void processConnectionClient() throws IOException{
      // enable enterField so client user can send messages
      setTextFieldEditable( true );

      do // process messages sent from server
      { 
         try // read message and display it
         {
            message = ( String ) input.readObject(); // read new message
            displayMessage( "\n" + message ); // display message
         } // end try
         catch ( ClassNotFoundException classNotFoundException ) 
         {
            displayMessage( "\nUnknown object type received" );
         } // end catch

      } while ( !message.equals( "SERVER>>> TERMINATE" ) );
   } // end method processConnection

           // close streams and socket
   private void closeConnectionClient()  {
      displayMessage( "\nClosing connection" );
      setTextFieldEditable( false ); // disable enterField

      try 
      {
         outputClient.close(); // close output stream
         inputClient.close(); // close input stream
         client.close(); // close socket
      } // end try
      catch ( IOException ioException ) 
      {
         ioException.printStackTrace();
      } // end catch
   } // end method closeConnection
   
           // manipulates displayArea in the event-dispatch thread
   private void sendDataClient( String message ){
	      try // send object to client
	      {
	         outputClient.writeObject( "CLIENT>>> " + message );
	         outputClient.flush(); // flush output to client
	         displayMessage( "\nCLIENT>>> " + message );
	      } // end try
	      catch ( IOException ioException ) 
	      {
	         messageTextArea.append( "\nError writing object" );
	      } // end catch
	   } // end method sendData
/*end of server Methods*/ 
   
   
   

   

   
   
    //Main Method
   public static void main(String args[]){
		
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
