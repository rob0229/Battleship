

import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.IOException;
import java.net.URL;
import java.awt.Container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.TransferHandler.TransferSupport;
import javax.swing.border.TitledBorder;
import java.net.InetAddress;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.SwingUtilities;

/**
 *
 * @author Rob
 */
public class Battleship extends javax.swing.JFrame {
        
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
        
        private Square[][] board; // board
        
        Ship carrier = new Ship();
        Ship battleship = new Ship();
        Ship sub = new Ship();
        Ship destroyer = new Ship();
        Ship crusier = new Ship();
        
   
     
    /**
     * Creates new form Battleship
     */
    public Battleship() {
        initComponents();
    }
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	
    	

        messagePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userChatEnter = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageTextArea = new javax.swing.JTextArea();
        controlPanel = new javax.swing.JPanel();
        readyButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ipAddressField = new java.awt.TextField();
        disconnectButton = new javax.swing.JButton();
        connectButton = new javax.swing.JButton();
        hostButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        enemyBoard = new javax.swing.JPanel();
        playerBoard = new javax.swing.JPanel();
        shipInventory = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Battleship");
        setResizable(true);

        messagePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Message Center", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setText("Message: ");

        userChatEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userChatEnterActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Radio Room"));

        messageTextArea.setColumns(20);
        messageTextArea.setLineWrap(true);
        messageTextArea.setRows(5);
        jScrollPane2.setViewportView(messageTextArea);

        javax.swing.GroupLayout messagePanelLayout = new javax.swing.GroupLayout(messagePanel);
        messagePanel.setLayout(messagePanelLayout);
        messagePanelLayout.setHorizontalGroup(
            messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(messagePanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userChatEnter))))
        );
        messagePanelLayout.setVerticalGroup(
            messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userChatEnter)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        controlPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control Panel", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP));

        readyButton.setText("Ready!");

        jLabel5.setText("Position Ships and push when ready");

        jLabel6.setText("Host Game:");

        jLabel9.setText("Host IP Address");

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
                connectButtonActionPerformed(evt);
            }
        });

        hostButton.setText("Host");
        hostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                        .addComponent(readyButton)
                        .addGap(163, 163, 163))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(101, 101, 101))))
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ipAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                                .addComponent(hostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)))
                        .addGap(18, 18, 18)
                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(disconnectButton)
                            .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(disconnectButton)
                        .addComponent(hostButton)))
                .addGap(21, 21, 21)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ipAddressField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(connectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(readyButton)
                .addContainerGap())
        );

        enemyBoard.setBackground(new java.awt.Color(51, 204, 255));
        enemyBoard.setBorder(javax.swing.BorderFactory.createTitledBorder("Enemy Board"));

        javax.swing.GroupLayout enemyBoardLayout = new javax.swing.GroupLayout(enemyBoard);
        enemyBoard.setLayout(enemyBoardLayout);
        enemyBoardLayout.setHorizontalGroup(
            enemyBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        enemyBoardLayout.setVerticalGroup(
            enemyBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        playerBoard.setBackground(new java.awt.Color(51, 204, 255));
        playerBoard.setBorder(javax.swing.BorderFactory.createTitledBorder("Player Board"));
        playerBoard.setPreferredSize(new java.awt.Dimension(12, 400));

        javax.swing.GroupLayout playerBoardLayout = new javax.swing.GroupLayout(playerBoard);
        playerBoard.setLayout(playerBoardLayout);
        playerBoardLayout.setHorizontalGroup(
            playerBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        playerBoardLayout.setVerticalGroup(
            playerBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        shipInventory.setBorder(javax.swing.BorderFactory.createTitledBorder("Ship Inventory"));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("Battleship.jpg"))); // NOI18N
        jLabel2.setText("Battleship");
        jLabel2.setPreferredSize(new java.awt.Dimension(120, 60));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("Cruiser.jpg"))); // NOI18N
        jLabel3.setText("Crusier");
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 60));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("Submarine.jpg"))); // NOI18N
        jLabel4.setText("Submarine");
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 60));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("carrier.jpg"))); // NOI18N
        jLabel7.setText("Carrier");
        jLabel7.setPreferredSize(new java.awt.Dimension(120, 60));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("Destroyer.jpg"))); // NOI18N
        jLabel8.setText("Destroyer");
        jLabel8.setMaximumSize(new java.awt.Dimension(60, 20));
        jLabel8.setMinimumSize(new java.awt.Dimension(60, 20));
        jLabel8.setPreferredSize(new java.awt.Dimension(60, 20));

        javax.swing.GroupLayout shipInventoryLayout = new javax.swing.GroupLayout(shipInventory);
        shipInventory.setLayout(shipInventoryLayout);
        shipInventoryLayout.setHorizontalGroup(
            shipInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shipInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(shipInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        shipInventoryLayout.setVerticalGroup(
            shipInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shipInventoryLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Enemy Ships Remaining"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(messagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(enemyBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(shipInventory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(enemyBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(shipInventory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(playerBoard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(22, Short.MAX_VALUE))
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
    
    //new MyDropTargetListener(playerBoard);//this must be done or we wont be able to drop any image onto the empty panel
       
    class MyDropTargetListener extends DropTargetAdapter {

    private DropTarget dropTarget;
    private JPanel p;

    
    
    
    public MyDropTargetListener(JPanel panel) {
        p = panel;
        dropTarget = new DropTarget(panel, DnDConstants.ACTION_COPY, this, true, null);

        
        String test = "@@h";
    
    
    if(test.charAt(0) == '@' && test.charAt(1) == '@'){
                
    }
        
        
    }

    @Override
    public void drop(DropTargetDropEvent event) {
        try {
            DropTarget test = (DropTarget) event.getSource();
            Component ca = (Component) test.getComponent();
            Point dropPoint = ca.getMousePosition();
            Transferable tr = event.getTransferable();

            if (event.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                Icon ico = (Icon) tr.getTransferData(DataFlavor.imageFlavor);

                if (ico != null) {

                    p.add(new JLabel(ico));
                    p.revalidate();
                    p.repaint();
                    event.dropComplete(true);
                }
            } else {
                event.rejectDrop();
            }
        } catch (Exception e) {
            e.printStackTrace();
            event.rejectDrop();
        }
    }
}

class MyDragGestureListener implements DragGestureListener {

    @Override
    public void dragGestureRecognized(DragGestureEvent event) {
        JLabel label = (JLabel) event.getComponent();
        final Icon ico = label.getIcon();


        Transferable transferable = new Transferable() {
            @Override
            public DataFlavor[] getTransferDataFlavors() {
                return new DataFlavor[]{DataFlavor.imageFlavor};
            }

            
            public boolean isDataFlavorSupported(DataFlavor flavor) {
                if (!isDataFlavorSupported(flavor)) {
                    return false;
                }
                return true;
            }

            @Override
            public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
                return ico;
            }
        };
        event.startDrag(null, transferable);
    }
}
    
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
   
   
   

   
   // private inner class for the squares on the board
   private class Square extends JPanel 
   {
      private String mark; // mark to be drawn in this square
      private int location; // location of square
   
      public Square( String squareMark, int squareLocation )
      {
         mark = squareMark; // set mark for this square
         location = squareLocation; // set location of this square
/*
         addMouseListener( 
            new MouseAdapter() 
            {
               public void mouseReleased( MouseEvent e )
               {
                  setCurrentSquare( Square.this ); // set current square

                  // send location of this square
                  sendClickedSquare( getSquareLocation() );
               } // end method mouseReleased
            } // end anonymous inner class
         ); // end call to addMouseListener
         	      */
      } // end Square constructor


      // return preferred size of Square
      public Dimension getPreferredSize() 
      { 
         return new Dimension( 35, 35 ); // return preferred size
      } // end method getPreferredSize

      // return minimum size of Square
      public Dimension getMinimumSize() 
      {
         return getPreferredSize(); // return preferred size
      } // end method getMinimumSize

      // draw Square
      public void paintComponent( Graphics g )
      {
         super.paintComponent( g );

         g.drawRect( 0, 0, 34, 34 ); // draw square
         g.drawString( mark, 11, 20 ); // draw mark   
      } // end method paintComponent
   } // end inner-class Square
   
   
   
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

    


    // Variables declaration - do not modify                     
    private javax.swing.JButton connectButton;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JPanel enemyBoard;
    private javax.swing.JButton hostButton;
    private java.awt.TextField ipAddressField;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel messagePanel;
    private javax.swing.JTextArea messageTextArea;
    private javax.swing.JPanel playerBoard;
    private javax.swing.JButton readyButton;
    private javax.swing.JPanel shipInventory;
    private javax.swing.JTextField userChatEnter;
    // End of variables declaration                   
}
