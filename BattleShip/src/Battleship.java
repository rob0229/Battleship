import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.TextField;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Rob and Charley
 */
public class Battleship extends JFrame {
	Gameplay game = new Gameplay();
	protected Boolean allShipsPlaced = false;
	public boolean playerReady;
	public boolean enemyReady;
	public static Boolean gameStart = true;
	private Boolean isServer = false;
    private JButton connectButton;
    private JPanel controlPanel;
    private JButton disconnectButton;
    public static JPanel enemyPanel;
    private JButton hostButton;
    private TextField ipAddressField;
    private JLabel messageLabel1;
    protected static JLabel battleshipImageLabel;
    protected static JLabel cruiserImageLabel;
    protected static JLabel submarineImageLabel;
    protected static JLabel carrierImageLabel;
    protected static JLabel destroyerImageLabel;
    private JLabel jLabel5;
    private JLabel hostGameLabel;
   
    private JLabel hostIPAdressLabel9;
    private JPanel informationPanel;
    private JPanel enemyRemainingPanel;
    private JScrollPane jScrollPane2;
    private JPanel messagePanel;
    private JTextArea messageTextArea;
    static JPanel playerPanel;
    private JButton readyButton;
    public static JButton randomButton;
    private JPanel shipInventory;
    private JTextField userChatEnter;     
    protected static EnemyGrid2 enemyGrid; //
    protected static PlayerGrid playerGrid; //
    
    
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
            
        Image image;
    /**
     * Creates new form Battleship
     */
    public Battleship() {
        initComponents();
    }
    
    
       @SuppressWarnings("unchecked")
    // <editor-fold default state="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	   	
        messagePanel = new JPanel();
        messageLabel1 = new JLabel();
        userChatEnter = new JTextField();
        jScrollPane2 = new JScrollPane();
        messageTextArea = new JTextArea();
        controlPanel = new JPanel();
        readyButton = new JButton();
        randomButton = new JButton();
        jLabel5 = new JLabel();
        hostGameLabel = new JLabel();
        hostIPAdressLabel9 = new JLabel();
        ipAddressField = new java.awt.TextField();
        disconnectButton = new JButton();
        connectButton = new JButton();
        hostButton = new JButton();
        informationPanel = new JPanel();      
        shipInventory = new JPanel();
        cruiserImageLabel = new JLabel();
        submarineImageLabel = new JLabel();
        carrierImageLabel = new JLabel();
        destroyerImageLabel = new JLabel();
        battleshipImageLabel = new JLabel();
        enemyRemainingPanel = new JPanel();
        playerGrid = new PlayerGrid();
        enemyGrid = new EnemyGrid2();
    	enemyPanel = new JPanel(); 

        try{
    		image = ImageIO.read(this.getClass().getResource("oceanGrid.png"));
    	}
    	catch(IOException e){
    		System.out.println("Image read error");
    		
    	}		
             
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Battleship");
        setIconImage(image);
        setResizable(false);

        //Creates player panel with backGround image
        playerPanel = new JPanel() {      
       // paints grid background but causes shadows of entire JFrame to appear under oceanGrid.png    	
        public void paintComponent(Graphics d)
        {   		
    		d.drawImage(image,20,30,300,300,null);
        	}
        };
         
        //creates Player Panel with background image
        enemyPanel = new JPanel()
        {
        public void paintComponent(Graphics d)
        {   		
    		d.drawImage(image,20,30,300,300,null);
        	}
        };
        //Allows ships to be dropped on PlayerPanel
    	new MyDropTargetListener(playerPanel); 
          
    	//adds mouse listener to enemyPanel to get attack information
    	enemyPanel.addMouseListener( 
    			new MouseAdapter() 
    			{
    				public void mouseClicked( MouseEvent e )
    				{

    					if(gameStart){//if connected do this
    						
//github.com/rob0229/Battleship.git
    						String message = Gameplay.attack(e.getPoint());
    						//ensures the grid square has not been chosen before
    						if(message != null){
	    						sendData(message);
	    						System.out.println("The grid attack is " + Gameplay.attack(e.getPoint()));
    						}
    						else
    							displayMessage("You already chose that square, try again");
    					}
    				} 

    			}); 
               
         
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
                .addGap(16, 16, 16)
                .addGroup(messagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(messagePanelLayout.createSequentialGroup()
                        .addComponent(messageLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userChatEnter))))
        );
        messagePanelLayout.setVerticalGroup(
            messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(messagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userChatEnter)
                    .addComponent(messageLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        controlPanel.setBorder(BorderFactory.createTitledBorder(null, "Control Panel", TitledBorder.CENTER, TitledBorder.ABOVE_TOP));

        readyButton.setText("Ready!");
        readyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	readyButtonActionPerformed(evt);
        
            }
        });
        
        randomButton.setText("Random");
        randomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	randomButtonActionPerformed(evt);
        
            }

			
        });

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
            	isServer = true;
            	Gameplay.turn = true;
                hostButtonActionPerformed(evt);
            }
        });

        informationPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        informationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));
        javax.swing.GroupLayout informationPanelLayout = new javax.swing.GroupLayout(informationPanel);
        informationPanel.setLayout(informationPanelLayout);
        informationPanelLayout.setHorizontalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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

        cruiserImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("Cruiser.jpg"))); // NOI18N
        //cruiserImageLabel.setText("Crusier");
        cruiserImageLabel.setPreferredSize(new java.awt.Dimension(120, 60));

        submarineImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("Submarine.jpg"))); // NOI18N
       // submarineImageLabel.setText("Submarine");
        submarineImageLabel.setPreferredSize(new java.awt.Dimension(90, 60));

        carrierImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("carrier.jpg"))); // NOI18N
        //carrierImageLabel.setText("Carrier");
        carrierImageLabel.setPreferredSize(new java.awt.Dimension(150, 60));

        destroyerImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("Destroyer.jpg"))); // NOI18N
        //destroyerImageLabel.setText("Destroyer");
        destroyerImageLabel.setPreferredSize(new java.awt.Dimension(60, 60));

        battleshipImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("Battleship.png"))); // NOI18N
        //battleshipImageLabel.setText("Battleship");
        battleshipImageLabel.setPreferredSize(new java.awt.Dimension(120, 60));

        javax.swing.GroupLayout shipInventoryLayout = new javax.swing.GroupLayout(shipInventory);
        shipInventory.setLayout(shipInventoryLayout);
        shipInventoryLayout.setHorizontalGroup(
            shipInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shipInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(shipInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cruiserImageLabel, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                    .addComponent(submarineImageLabel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)                
                    .addComponent(carrierImageLabel, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                    .addComponent(destroyerImageLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                    .addComponent(battleshipImageLabel, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                    
                    .addComponent(randomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        shipInventoryLayout.setVerticalGroup(
            shipInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shipInventoryLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(battleshipImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(destroyerImageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(submarineImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carrierImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cruiserImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(randomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        
        //Adds drag listener to ship inventory panel
        MyDragGestureListener dlistener = new MyDragGestureListener();
        DragSource ds1 = new DragSource();    
        ds1.createDefaultDragGestureRecognizer(battleshipImageLabel, DnDConstants.ACTION_COPY, dlistener);
        ds1.createDefaultDragGestureRecognizer(carrierImageLabel, DnDConstants.ACTION_COPY, dlistener);
        ds1.createDefaultDragGestureRecognizer(cruiserImageLabel, DnDConstants.ACTION_COPY, dlistener);
        ds1.createDefaultDragGestureRecognizer(destroyerImageLabel, DnDConstants.ACTION_COPY, dlistener);
        ds1.createDefaultDragGestureRecognizer(submarineImageLabel, DnDConstants.ACTION_COPY, dlistener);

        //populate this panel with ship images and turn red once they have been destroyed
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
                    .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(messagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
              
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(enemyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addComponent(playerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
              
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shipInventory, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addComponent(enemyRemainingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
               
       ) );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
         
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                		
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(messagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                        
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(enemyRemainingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(enemyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                       
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(shipInventory, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                            .addComponent(playerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))))              
       ) );
   
       pack();
    }                      
  
  
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

    private void readyButtonActionPerformed(ActionEvent evt){
    	System.out.println("All ships placed = "+GetSquareDropped.allShipsPlaced());
    	//check that all ships are placed
    	if(GetSquareDropped.allShipsPlaced()){
    	playerReady = true;
    	readyButton.setEnabled(false);
    	}
    	
    }
    
    private void randomButtonActionPerformed(ActionEvent evt) {
    	
    	Boolean bsD = false, caD = false, crD = false, sD = false, dD = false;
    	
    	randomButton.setEnabled(false);
    	
    	int randomX = randInt(21, 319);
    	int randomY = randInt(30, 300);
    	
    	//set Battleship
    	
    	while(bsD == false){
    		JLabel randBSLabel = new JLabel();
    		randBSLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.bsImage)));
    		randomX = randInt(21, 319);
	    	randomY = randInt(30, 300);
	    	Point randPoint = new Point(randomX, randomY);
	    	GetSquareDropped dropSq = new GetSquareDropped(randPoint,"battleShip");
	    	
		    	if(GetSquareDropped.validDrop){
			    	randBSLabel.setBounds(dropSq.getX(), dropSq.getY(), 118, 28);
					playerPanel.add(randBSLabel);				
					playerPanel.repaint();
					playerPanel.revalidate();
					bsD = true;
		    	}
    	}
		//Set Carrier
    	while(caD == false){
    		JLabel randBSLabel = new JLabel();
    		randBSLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.caImage)));
    		randomX = randInt(21, 319);
	    	randomY = randInt(30, 300);
	    	Point randPoint = new Point(randomX, randomY);
	    	GetSquareDropped dropSq = new GetSquareDropped(randPoint,"carrier");
	    	
		    	if(GetSquareDropped.validDrop){
			    	randBSLabel.setBounds(dropSq.getX(), dropSq.getY(), 118, 28);
					playerPanel.add(randBSLabel);				
					playerPanel.repaint();
					playerPanel.revalidate();
					caD = true;
		    	}
    	}
		
		//Set Cruiser
    	while(crD == false){
    		JLabel randBSLabel = new JLabel();
    		randBSLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.crImage)));
    		randomX = randInt(21, 319);
	    	randomY = randInt(30, 300);
	    	Point randPoint = new Point(randomX, randomY);
	    	GetSquareDropped dropSq = new GetSquareDropped(randPoint,"cruiser");
	    	
		    	if(GetSquareDropped.validDrop){
			    	randBSLabel.setBounds(dropSq.getX(), dropSq.getY(), 118, 28);
					playerPanel.add(randBSLabel);				
					playerPanel.repaint();
					playerPanel.revalidate();
					crD = true;
		    	}
    	}
		
		//Set Submarine
    	while(sD == false){
    		JLabel randBSLabel = new JLabel();
    		randBSLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.subImage)));
    		randomX = randInt(21, 319);
	    	randomY = randInt(30, 300);
	    	Point randPoint = new Point(randomX, randomY);
	    	GetSquareDropped dropSq = new GetSquareDropped(randPoint,"sub");
	    	
		    	if(GetSquareDropped.validDrop){
			    	randBSLabel.setBounds(dropSq.getX(), dropSq.getY(), 118, 28);
					playerPanel.add(randBSLabel);				
					playerPanel.repaint();
					playerPanel.revalidate();
					sD = true;
		    	}
    	}
		
		//Set Destroyer
    	while(dD == false){
    		JLabel randBSLabel = new JLabel();
    		randBSLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.dImage)));
    		randomX = randInt(21, 319);
	    	randomY = randInt(30, 300);
	    	Point randPoint = new Point(randomX, randomY);
	    	GetSquareDropped dropSq = new GetSquareDropped(randPoint,"destroyer");
	    	
		    	if(GetSquareDropped.validDrop){
			    	randBSLabel.setBounds(dropSq.getX(), dropSq.getY(), 118, 28);
					playerPanel.add(randBSLabel);				
					playerPanel.repaint();
					playerPanel.revalidate();
					dD = true;
		    	}
    	}
		
	}
    
    private void hostButtonActionPerformed(ActionEvent evt) {                                           
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
	            //filters the string message to determine if it is a game event or just a user message.
	            //if it is a game event, Gameplay class handles it.
	            System.out.println("Gets to processConnection ");
	            message = game.Translate(message);
	            System.out.println("Gets past message filter in processConnection");
	            
	            //if (message != null){
	            	displayMessage( "\nPLAYER 2>>> " + message ); // display message
	            //}
	         } // end try
	         catch ( ClassNotFoundException classNotFoundException ) 
	         {
	            displayMessage( "\nUnknown object type received" );
	         } // end catch

	      } while ( !message.equals( "TERMINATE" ) );
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
    public void sendData( String message ) {
	      try // send object to client
	      {
	         output.writeObject(message);
	         output.flush(); // flush output to client
	         displayMessage( "\nPLAYER 1>>> " + message );
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
          System.out.println("  gets to here run client line 701  ");
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
            
            //filters the string message to determine if it is a game event or just a user message.
            //if it is a game event, Gameplay class handles it.
            System.out.println("Gets to processConnectionClient ");
            message = game.Translate(message);
            System.out.println("Gets past message filter in processConnectionClient ");
           // if (message != null){
            	displayMessage( "\nPLAYER 2>>> " + message ); // display message
            //}
            
            displayMessage( "\n\nPLAYER 1>>> " + message ); // display message
         } // end try
         catch ( ClassNotFoundException classNotFoundException ) 
         {
            displayMessage( "\nUnknown object type received" );
         } // end catch

      } while ( !message.equals( "TERMINATE" ) );
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
   public void sendDataClient( String message ){
	      try // send object to client
	      {
	         outputClient.writeObject( message );
	         outputClient.flush(); // flush output to client
	         displayMessage( "\nPLAYER 2>>> " + message );
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

   public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}


                      
}
