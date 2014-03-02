/**
 Battleship
 Copyright: Rob Close and Charlie Sun
 Created on: 03/01/2014
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.TextField;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class Battleship extends JFrame {
	
	private Gameplay game = new Gameplay();
	protected boolean allShipsPlaced = false;
	public static boolean playerReady;
	public static boolean enemyReady;
	public static boolean gameStarted = false;
	public static boolean isServer = false;
	public static boolean playerTurn = false;
	private JToggleButton shipOrientButton1, shipOrientButton2;
	private JButton connectButton;
	private JPanel controlPanel;
	public static JPanel enemyPanel;
	private JButton hostButton;
	private TextField ipAddressField;
	private JLabel messageLabel1;
	protected static JTextArea instructions;
	protected static JTextArea yourTurnMessage;
	protected static JTextArea enemyTurnMessage;
	protected static JTextArea youWinMessage;
	protected static JTextArea youLoseMessage;
	protected static JLabel battleshipImageLabel;
	protected static JLabel cruiserImageLabel;
	protected static JLabel submarineImageLabel;
	protected static JLabel carrierImageLabel;
	protected static JLabel destroyerImageLabel;
	protected static JLabel battleshipImageLabelVERT;
	protected static JLabel cruiserImageLabelVERT;
	protected static JLabel submarineImageLabelVERT;
	protected static JLabel carrierImageLabelVERT;
	protected static JLabel destroyerImageLabelVERT;
	protected static JLabel enemyBattleshipLabel;
	protected static JLabel enemyCarrierLabel;
	protected static JLabel enemyCruiserLabel;
	protected static JLabel enemyDestroyerLabel;
	protected static JLabel enemySubmarineLabel;
	private JLabel readyButtonInstLabel;
	private JLabel hostGameLabel;
	private JLabel hostIPAdressLabel9;
	private JPanel informationPanel;
	public static JPanel enemyRemainingPanel;
	private JScrollPane jScrollPane2;
	private JPanel messagePanel;
	private static JTextArea messageTextArea;
	static JPanel playerPanel;
	public static JButton readyButton;
	public static JButton randomButton;
	private JPanel shipInventory;
	private JTextField userChatEnter;
	protected static EnemyGrid enemyGrid; //
	protected static PlayerGrid playerGrid; //

	// Server and Client Variables
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
	final Sounds sound = new Sounds();
	
	//Ships
	private Ship battleship = new Ship("Battleship", ConstantData.BATTLESHIP, 0);
	private Ship carrier = new Ship("Carrier", ConstantData.CARRIER,0);
	private Ship cruiser = new Ship("Cruiser", ConstantData.CRUISER, 0);
	private Ship submarine = new Ship("Submarine", ConstantData.SUBMARINE, 0);
	private Ship destroyer = new Ship("Destroyer", ConstantData.DESTROYER, 0);
	private Ship battleshipV = new Ship("BattleshipV", ConstantData.BATTLESHIPVERT, 1);
	private Ship carrierV = new Ship("CarrierV", ConstantData.CARRIERVERT, 1);
	private Ship cruiserV = new Ship("CruiserV", ConstantData.CRUISERVERT, 1);
	private Ship submarineV = new Ship("SubmarineV", ConstantData.SUBMARINEVERT, 1);
	private Ship destroyerV = new Ship("DestroyerV", ConstantData.DESTROYERVERT, 1);

	/**
	 * Constructor
	 * Creates new form Battleship
	 */
	public Battleship() {
		initComponents();
		//sound.easteregg();
	}

	
	// <editor-fold default state="collapsed" desc="Generated Code">
	@SuppressWarnings("serial")
	private void initComponents() {
		//JTextFields
		userChatEnter = new JTextField();
		
		//JLabels
		messageLabel1 = new JLabel();
		readyButtonInstLabel = new JLabel();
		hostGameLabel = new JLabel();
		hostIPAdressLabel9 = new JLabel();
		ipAddressField = new java.awt.TextField();
		
		//JText Areas
		jScrollPane2 = new JScrollPane();
		messageTextArea = new JTextArea();
		yourTurnMessage = new JTextArea("     Your Turn");
		enemyTurnMessage = new JTextArea("   Opponents Turn");
		youWinMessage = new JTextArea("      You Win!!!!");
		youLoseMessage = new JTextArea("      You Lost!!!!");
		instructions = new JTextArea(ConstantData.INSTRUCTIONS);
		
		//Buttons
		shipOrientButton1 = new JRadioButton("Horizontal");
		shipOrientButton2 = new JRadioButton("Vertical");
		connectButton = new JButton();
		readyButton = new JButton();
		randomButton = new JButton();
		hostButton = new JButton();	
		
		//enemy panel ships
		enemyBattleshipLabel = new JLabel();
		enemyCarrierLabel = new JLabel();
		enemyCruiserLabel = new JLabel();
		enemySubmarineLabel = new JLabel();
		enemyDestroyerLabel = new JLabel();
				
		//Panels
		messagePanel = new JPanel();
		controlPanel = new JPanel();
		informationPanel = new JPanel();
		shipInventory = new JPanel();
		enemyRemainingPanel = new JPanel();
		enemyPanel = new JPanel();
		
		//Grids
		playerGrid = new PlayerGrid();
		enemyGrid = new EnemyGrid();
		
		// Ocean image
		try {
			image = ImageIO.read(this.getClass().getResource("img/oceanGrid.png"));
		} catch (IOException e) {
			System.out.println("Image read error");

		}

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Battleship");
		setIconImage(image);
		setResizable(false);

		// Creates player panel with backGround image
		playerPanel = new JPanel() {
			// paints grid background but causes shadows of entire JFrame to
			// appear under oceanGrid.png
		
			@Override
			public void paintComponent(Graphics d) {
				super.paintComponent(d);
				d.drawImage(image, 20, 30, 300, 300, null);
			}
		};

		// creates Player Panel with background image
		enemyPanel = new JPanel() {
			@Override
			public void paintComponent(Graphics d) {
				super.paintComponent(d);
				d.drawImage(image, 20, 30, 300, 300, null);
			}
		};
		// Allows ships to be dropped on PlayerPanel
		new MyDropTargetListener(playerPanel);

		// adds mouse listener to enemyPanel to get attack information
		enemyPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (gameStarted) {

					String message;
					if (playerTurn == true) {
						message = Gameplay.attack(e.getPoint());
						// ensures the grid square has not been chosen before
						if (!(message.equals("*****"))) {

							if (isServer && playerTurn) {
								playerTurn = false;
								sendData(message);

							} else if (isServer == false && playerTurn) {
								playerTurn = false;
								sendDataClient(message);

							} else if (playerTurn == false) {

								displayMessage("\nIts not your turn!");
							}
						}
					}
				}
			}
		});

		
		// GUI components
		
		messagePanel.setBorder(BorderFactory.createTitledBorder(null, "Message Center", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION));
		messageLabel1.setText("Message: ");

		userChatEnter.addActionListener(new ActionListener() {
			@Override
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
		messagePanelLayout.setHorizontalGroup(messagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				messagePanelLayout.createSequentialGroup().addGap(16, 16, 16).addGroup(
						messagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jScrollPane2).addGroup(
								messagePanelLayout.createSequentialGroup().addComponent(messageLabel1).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(userChatEnter)))));
		messagePanelLayout.setVerticalGroup(messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				messagePanelLayout.createSequentialGroup().addContainerGap().addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(
								messagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(userChatEnter).addComponent(messageLabel1,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

		controlPanel.setBorder(BorderFactory.createTitledBorder(null, "Control Panel", TitledBorder.CENTER, TitledBorder.ABOVE_TOP));
		readyButton.setEnabled(false);
		readyButton.setText("Ready!");
		readyButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				readyButtonActionPerformed(evt);

			}
		});
		
		shipOrientButton1.setActionCommand("Horizontal");
		shipOrientButton1.setSelected(true);
		shipOrientButton2.setActionCommand("Vertical");
		//shipOrientButton2.setSelected(false);
		
		 // Group the radio buttons.
	    ButtonGroup group = new ButtonGroup();
	    group.add(shipOrientButton1);
	    group.add(shipOrientButton2);
		
	    RadioListener myListener = new RadioListener();
	    shipOrientButton1.addActionListener(myListener);
	    shipOrientButton1.addChangeListener(myListener);
	    shipOrientButton1.addItemListener(myListener);
	    shipOrientButton2.addActionListener(myListener);
	    shipOrientButton2.addChangeListener(myListener);
	    shipOrientButton2.addItemListener(myListener);
		
		
		randomButton.setText("Random");
		randomButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				randomButtonActionPerformed(evt);

			}

		});
		randomButton.setEnabled(true);
		readyButtonInstLabel.setText("Position Ships and push when ready");

		hostGameLabel.setText("Host Game:");

		hostIPAdressLabel9.setText("Host IP Address");

		ipAddressField.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ipAddressFieldActionPerformed(evt);
			}
		});

		connectButton.setText("Connect");
		connectButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// if user enters ipaddress and clicks connect, the value in
				// ipAddress
				// will be updated before a call to the connect function
				playerTurn = false;
				ipAddressFieldActionPerformed(evt);
				connectButtonActionPerformed(evt);
			}
		});

		hostButton.setText("Host");
		hostButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				isServer = true;
				playerTurn = true;
				hostButtonActionPerformed(evt);
			}
		});
		instructions.setColumns(2);
		instructions.setLineWrap(true);
		instructions.setRows(5);
		instructions.setFont(new Font("Serif", Font.BOLD, 16));
		instructions.setBackground(Color.gray.brighter());
		
		yourTurnMessage.setFont(new Font("Serif", Font.BOLD, 36));
		yourTurnMessage.setBackground(Color.green.brighter());		
		
		enemyTurnMessage.setFont(new Font("Serif", Font.BOLD, 32));
		enemyTurnMessage.setBackground(Color.red.brighter());
		
		youWinMessage.setFont(new Font("Serif", Font.BOLD, 36));
		youWinMessage.setBackground(Color.green.brighter());
		
		youLoseMessage.setFont(new Font("Serif", Font.BOLD, 36));
		youLoseMessage.setBackground(Color.red.brighter());
		
		informationPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		informationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));
		javax.swing.GroupLayout informationPanelLayout = new javax.swing.GroupLayout(informationPanel);
		informationPanel.setLayout(informationPanelLayout);
		informationPanelLayout.setHorizontalGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(informationPanelLayout.createSequentialGroup()
    				.addComponent(instructions, GroupLayout.PREFERRED_SIZE, 300,GroupLayout.PREFERRED_SIZE)	
    				.addComponent(yourTurnMessage, GroupLayout.PREFERRED_SIZE, 300,GroupLayout.PREFERRED_SIZE)
    				.addComponent(enemyTurnMessage, GroupLayout.PREFERRED_SIZE, 300,GroupLayout.PREFERRED_SIZE)
    				.addComponent(youWinMessage, GroupLayout.PREFERRED_SIZE, 300,GroupLayout.PREFERRED_SIZE)
    				.addComponent(youLoseMessage, GroupLayout.PREFERRED_SIZE, 300,GroupLayout.PREFERRED_SIZE)));
		informationPanelLayout.setVerticalGroup(informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(instructions, GroupLayout.PREFERRED_SIZE, 100,GroupLayout.PREFERRED_SIZE)
				.addComponent(yourTurnMessage, GroupLayout.PREFERRED_SIZE, 100,GroupLayout.PREFERRED_SIZE)
				.addComponent(enemyTurnMessage, GroupLayout.PREFERRED_SIZE, 100,GroupLayout.PREFERRED_SIZE)
				.addComponent(youWinMessage, GroupLayout.PREFERRED_SIZE, 100,GroupLayout.PREFERRED_SIZE)
				.addComponent(youLoseMessage, GroupLayout.PREFERRED_SIZE, 100,GroupLayout.PREFERRED_SIZE));

		javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
		controlPanel.setLayout(controlPanelLayout);
		controlPanelLayout.setHorizontalGroup(controlPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(
				controlPanelLayout.createSequentialGroup()
				.addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(informationPanel, javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(controlPanelLayout.createSequentialGroup()
				.addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(controlPanelLayout.createSequentialGroup()
				.addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
    				.addComponent(hostIPAdressLabel9,javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    				.addComponent(hostGameLabel,javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    				.addGap(18, 18, 18)
    				.addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
    				.addComponent(ipAddressField,javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,controlPanelLayout.createSequentialGroup()
    				.addComponent(hostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85,javax.swing.GroupLayout.PREFERRED_SIZE)
    				.addGap(15, 15, 15))).addGap(18, 18, 18).addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
    				.addComponent(connectButton,javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
    				.addGroup(controlPanelLayout.createSequentialGroup()
    						.addGap(142, 142, 142)
    				.addComponent(readyButton))	
				.addGroup(controlPanelLayout.createSequentialGroup()
					.addGap(0, 5, 75)
					.addComponent(readyButtonInstLabel)))
					.addGap(10, 35, 70)))
					.addContainerGap()));
		
		controlPanelLayout.setVerticalGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				controlPanelLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
				.addComponent(hostGameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23,javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				.addComponent(hostButton)))
				.addGap(21, 21, 21)
				.addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
				.addComponent(ipAddressField, javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(hostIPAdressLabel9, javax.swing.GroupLayout.DEFAULT_SIZE,javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addComponent(connectButton))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(informationPanel, javax.swing.GroupLayout.PREFERRED_SIZE,150, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED,javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(readyButtonInstLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(readyButton)));

		enemyPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Enemy Board"));
		enemyPanel.setLayout(null);

		playerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Player Board"));

		// allows ships to be dropped anywhere on panel
		playerPanel.setLayout(null);

		// Ship Panel Layout
		shipInventory.setBorder(javax.swing.BorderFactory.createTitledBorder("Ship Inventory"));
		
		//player ships horizontal
		cruiserImageLabel = new JLabel(cruiser.getIcon());
		submarineImageLabel = new JLabel(submarine.getIcon());
		carrierImageLabel = new JLabel(carrier.getIcon());
		destroyerImageLabel = new JLabel(destroyer.getIcon());
		battleshipImageLabel = new JLabel(battleship.getIcon());
	
		//player ships vertical
		cruiserImageLabelVERT = new JLabel(cruiserV.getIcon());
		submarineImageLabelVERT = new JLabel(submarineV.getIcon());
		carrierImageLabelVERT= new JLabel(carrierV.getIcon());
		destroyerImageLabelVERT = new JLabel(destroyerV.getIcon());
		battleshipImageLabelVERT = new JLabel(battleshipV.getIcon());
		
		//enemy ships horizontal
		enemyCruiserLabel = new JLabel(cruiser.getIcon());
		enemySubmarineLabel = new JLabel(submarine.getIcon());
		enemyCarrierLabel = new JLabel(carrier.getIcon());
		enemyDestroyerLabel = new JLabel(destroyer.getIcon());
		enemyBattleshipLabel = new JLabel(battleship.getIcon());
				

		cruiserImageLabel.setPreferredSize(new java.awt.Dimension(120, 60));
		submarineImageLabel.setPreferredSize(new java.awt.Dimension(90, 60));
		carrierImageLabel.setPreferredSize(new java.awt.Dimension(150, 60));
		destroyerImageLabel.setPreferredSize(new java.awt.Dimension(60, 60));
		battleshipImageLabel.setPreferredSize(new java.awt.Dimension(120, 60));
		
		cruiserImageLabelVERT.setPreferredSize(new java.awt.Dimension(60, 120));
		submarineImageLabelVERT.setPreferredSize(new java.awt.Dimension(60, 90));
		carrierImageLabelVERT.setPreferredSize(new java.awt.Dimension(60, 150));
		destroyerImageLabelVERT.setPreferredSize(new java.awt.Dimension(60, 60));
		battleshipImageLabelVERT.setPreferredSize(new java.awt.Dimension(60, 120));
		
		enemyBattleshipLabel.setPreferredSize(new java.awt.Dimension(120, 60));
		enemyCarrierLabel.setPreferredSize(new java.awt.Dimension(150, 60));
		enemyCruiserLabel.setPreferredSize(new java.awt.Dimension(120, 60));
		enemySubmarineLabel.setPreferredSize(new java.awt.Dimension(90, 60));
		enemyDestroyerLabel.setPreferredSize(new java.awt.Dimension(60, 60));
		

		javax.swing.GroupLayout shipInventoryLayout = new javax.swing.GroupLayout(shipInventory);
		shipInventory.setLayout(shipInventoryLayout);
		
		shipInventoryLayout.setHorizontalGroup(shipInventoryLayout.createSequentialGroup()	
				.addGroup(shipInventoryLayout.createSequentialGroup()
				
					.addGroup(shipInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addComponent(carrierImageLabel, GroupLayout.PREFERRED_SIZE, 148,GroupLayout.PREFERRED_SIZE)
							.addComponent(battleshipImageLabel,GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)							
							.addComponent(cruiserImageLabel, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addComponent(submarineImageLabel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addComponent(destroyerImageLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)	
							
							
					.addGroup(shipInventoryLayout.createSequentialGroup()
							.addComponent(carrierImageLabelVERT, GroupLayout.PREFERRED_SIZE, 28,GroupLayout.PREFERRED_SIZE)
							.addComponent(battleshipImageLabelVERT,GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(cruiserImageLabelVERT, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)				
							.addComponent(submarineImageLabelVERT, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addComponent(destroyerImageLabelVERT, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))	
							//next parallel entry
                    		.addComponent(shipOrientButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    		.addComponent(shipOrientButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)		
                    		.addComponent(randomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))));

		shipInventoryLayout.setVerticalGroup(shipInventoryLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				
				.addGroup(shipInventoryLayout.createSequentialGroup()												
					.addComponent(carrierImageLabel, GroupLayout.PREFERRED_SIZE,28, GroupLayout.PREFERRED_SIZE)					
					.addComponent(battleshipImageLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)					
					.addComponent(cruiserImageLabel,GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)										
					.addComponent(submarineImageLabel, GroupLayout.PREFERRED_SIZE, 28,GroupLayout.PREFERRED_SIZE)					
					.addComponent(destroyerImageLabel, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
				.addGroup(shipInventoryLayout.createParallelGroup()
              		.addComponent(carrierImageLabelVERT, GroupLayout.PREFERRED_SIZE,148, GroupLayout.PREFERRED_SIZE)
                	.addComponent(battleshipImageLabelVERT, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)						
    				.addComponent(cruiserImageLabelVERT,javax.swing.GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
    				.addComponent(submarineImageLabelVERT, javax.swing.GroupLayout.PREFERRED_SIZE, 88,javax.swing.GroupLayout.PREFERRED_SIZE)                				
    				.addComponent(destroyerImageLabelVERT, javax.swing.GroupLayout.PREFERRED_SIZE, 58,GroupLayout.PREFERRED_SIZE))
    				
            		.addComponent(shipOrientButton1, GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            		.addComponent(shipOrientButton2, GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            		.addComponent(randomButton, GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)	)); 
		
		// Adds drag listener to ship inventory panel
		MyDragGestureListener dlistener = new MyDragGestureListener();
		DragSource ds = new DragSource();
		DragSource ds1 = new DragSource();
		DragSource ds2 = new DragSource();
		DragSource ds3 = new DragSource();
		DragSource ds4 = new DragSource();
		DragSource ds5 = new DragSource();   
		DragSource ds6 = new DragSource();
		DragSource ds7 = new DragSource();
		DragSource ds8 = new DragSource();
		DragSource ds9 = new DragSource();
		 
		ds1.createDefaultDragGestureRecognizer(battleshipImageLabel, DnDConstants.ACTION_COPY, dlistener);
		ds2.createDefaultDragGestureRecognizer(carrierImageLabel, DnDConstants.ACTION_COPY, dlistener);
		ds3.createDefaultDragGestureRecognizer(cruiserImageLabel, DnDConstants.ACTION_COPY, dlistener);
		ds4.createDefaultDragGestureRecognizer(destroyerImageLabel, DnDConstants.ACTION_COPY, dlistener);
		ds5.createDefaultDragGestureRecognizer(submarineImageLabel, DnDConstants.ACTION_COPY, dlistener);

		ds6.createDefaultDragGestureRecognizer(battleshipImageLabelVERT, DnDConstants.ACTION_COPY, dlistener);
		ds7.createDefaultDragGestureRecognizer(carrierImageLabelVERT, DnDConstants.ACTION_COPY, dlistener);
		ds8.createDefaultDragGestureRecognizer(cruiserImageLabelVERT, DnDConstants.ACTION_COPY, dlistener);
		ds9.createDefaultDragGestureRecognizer(destroyerImageLabelVERT, DnDConstants.ACTION_COPY, dlistener);
		ds.createDefaultDragGestureRecognizer(submarineImageLabelVERT, DnDConstants.ACTION_COPY, dlistener);


		// populate this panel with ship images and remove them once they have been
		// destroyed
		enemyRemainingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Enemy Ships Remaining"));

		javax.swing.GroupLayout enemyLeftPanelLayout = new javax.swing.GroupLayout(enemyRemainingPanel);
		enemyRemainingPanel.setLayout(enemyLeftPanelLayout);
		
		enemyLeftPanelLayout.setHorizontalGroup(enemyLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(enemyLeftPanelLayout.createSequentialGroup().addContainerGap()
				.addGroup(enemyLeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(enemyCarrierLabel, GroupLayout.PREFERRED_SIZE, 148,GroupLayout.PREFERRED_SIZE)
				.addComponent(enemyBattleshipLabel,	GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
				.addComponent(enemyCruiserLabel, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
				.addComponent(enemySubmarineLabel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
				.addComponent(enemyDestroyerLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))		
				.addContainerGap(18, Short.MAX_VALUE)));
		
		enemyLeftPanelLayout.setVerticalGroup(enemyLeftPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(enemyLeftPanelLayout.createSequentialGroup()
				.addGap(29, 29, 29)
				.addComponent(enemyCarrierLabel, javax.swing.GroupLayout.PREFERRED_SIZE,28, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(enemyBattleshipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(enemyCruiserLabel,javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(enemySubmarineLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28,javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(enemyDestroyerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)		
				.addGap(124, 124, 124)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
				.addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
				.addComponent(messagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
				.addComponent(enemyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
				.addComponent(playerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(shipInventory, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
				.addComponent(enemyRemainingPanel,GroupLayout.PREFERRED_SIZE, 200,GroupLayout.PREFERRED_SIZE))));
		
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
				.addGroup(javax.swing.GroupLayout.Alignment.LEADING,layout.createSequentialGroup()
				.addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addComponent(messagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.LEADING,layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
				.addComponent(enemyRemainingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350,Short.MAX_VALUE)
				.addComponent(enemyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
				.addComponent(shipInventory, javax.swing.GroupLayout.DEFAULT_SIZE, 350,	Short.MAX_VALUE)
				.addComponent(playerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))))));
		Battleship.battleshipImageLabelVERT.setVisible(false);
        Battleship.carrierImageLabelVERT.setVisible(false);
        Battleship.cruiserImageLabelVERT.setVisible(false);
        Battleship.submarineImageLabelVERT.setVisible(false);
        Battleship.destroyerImageLabelVERT.setVisible(false);
        yourTurnMessage.setVisible(false);
        enemyTurnMessage.setVisible(false);
        youWinMessage.setVisible(false);
        youLoseMessage.setVisible(false);
		pack();
	}
	
	//Displays Horizontal or Vertical ships for player placement
	class RadioListener implements ActionListener, ChangeListener, ItemListener {  
        public void actionPerformed(ActionEvent e) {  
            
            if (e.getActionCommand() == "Horizontal") {
               //checks to see if each ship has been placed and displays it if not
                if(GetSquareDropped.bsPlaced == false){
                	Battleship.battleshipImageLabel.setVisible(true);	
                }
                if(GetSquareDropped.carrierPlaced == false){
                	Battleship.carrierImageLabel.setVisible(true); 	
                }
                if(GetSquareDropped.cruiserPlaced == false){
                	Battleship.cruiserImageLabel.setVisible(true);	
                }
                if(GetSquareDropped.subPlaced == false){
                	Battleship.submarineImageLabel.setVisible(true);	
                }
                if(GetSquareDropped.destroyerPlaced == false){
                	Battleship.destroyerImageLabel.setVisible(true);	
                }
                //hides vertical ships
                Battleship.battleshipImageLabelVERT.setVisible(false);
                Battleship.carrierImageLabelVERT.setVisible(false);
                Battleship.cruiserImageLabelVERT.setVisible(false);
                Battleship.submarineImageLabelVERT.setVisible(false);
                Battleship.destroyerImageLabelVERT.setVisible(false);
                
            }else {
            	//checks to see if each ship has been placed and displays it if not
                if(GetSquareDropped.bsPlaced == false){
                	Battleship.battleshipImageLabelVERT.setVisible(true);
                }
                if(GetSquareDropped.carrierPlaced == false){
                	Battleship.carrierImageLabelVERT.setVisible(true);
                }
                if(GetSquareDropped.cruiserPlaced == false){
                	Battleship.cruiserImageLabelVERT.setVisible(true);
                }
                if(GetSquareDropped.subPlaced == false){
                	Battleship.submarineImageLabelVERT.setVisible(true);
                }
                if(GetSquareDropped.destroyerPlaced == false){
                	Battleship.destroyerImageLabelVERT.setVisible(true);
                }
                //hides Horizontal ships
                Battleship.battleshipImageLabel.setVisible(false);
                Battleship.carrierImageLabel.setVisible(false);
                Battleship.cruiserImageLabel.setVisible(false);
                Battleship.submarineImageLabel.setVisible(false);
                Battleship.destroyerImageLabel.setVisible(false);
            }
        }
        //Required from super class
		@Override
		public void itemStateChanged(ItemEvent e) {
			
		}
		//Required from super class
		@Override
		public void stateChanged(ChangeEvent e) {
			
		}
    
	}
	
	//generates a random integer
	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	
	//gets user messages
	private void userChatEnterActionPerformed(java.awt.event.ActionEvent evt) {
		if (isServer == true) {
			displayMessage("\nServer says >>> " + userChatEnter.getText());
			sendData(evt.getActionCommand());
			userChatEnter.setText("");
		} else {
			displayMessage("\nClient says >>> " + userChatEnter.getText());
			sendDataClient(evt.getActionCommand());
			userChatEnter.setText("");
		}

	}

	//takes ipAddress
	private void ipAddressFieldActionPerformed(java.awt.event.ActionEvent evt) {
		
		ipAddress = ipAddressField.getText();	
	}

	private void readyButtonActionPerformed(ActionEvent evt) {
		
		// check that all ships are placed
		if (GetSquareDropped.allShipsPlaced()) {
			playerReady = true;
			instructions.setVisible(false);
			sound.run(2);
			readyButton.setEnabled(false);
			if (enemyReady == true) {
				gameStarted = true;
			}
			if (isServer) {
				yourTurnMessage.setVisible(true);
				sendData("#####");
			} else if (isServer == false) {
				sendDataClient("#####");
				enemyTurnMessage.setVisible(true);
			}
		}

	}

	private void randomButtonActionPerformed(ActionEvent evt) {

		Boolean bsD = false, caD = false, crD = false, sD = false, dD = false;

		randomButton.setEnabled(false);

		int randomX = randInt(21, 319);
		int randomY = randInt(30, 300);
		int randOrient = randInt(0,1);
		
		// set Battleship
		while (bsD == false) {
			randOrient = randInt(0,1);	
			
			GetShipInfo.setOrientation(randOrient);
			
			if(randOrient == 0){
				JLabel randBSLabel = new JLabel();
			randBSLabel.setIcon(battleship.getIcon());
			
			randomX = randInt(21, 319);
			randomY = randInt(30, 300);	
			Point randPoint = new Point(randomX, randomY);
			GetSquareDropped dropSq = new GetSquareDropped(randPoint, "battleShip");
			
			if (GetSquareDropped.validDrop) {
				randBSLabel.setBounds(dropSq.getX(), dropSq.getY(), 118, 28);
				playerPanel.add(randBSLabel);
				playerPanel.repaint();
				playerPanel.revalidate();
				bsD = true;
			}
			}
			else if (randOrient == 1){
				JLabel randBSLabel = new JLabel();
				randBSLabel.setIcon(battleshipV.getIcon());
				randomX = randInt(21, 319);
				randomY = randInt(30, 300);
				Point randPoint = new Point(randomX, randomY);
				GetSquareDropped dropSq = new GetSquareDropped(randPoint, "battleShipV");
			
				if (GetSquareDropped.validDrop) {
				randBSLabel.setBounds(dropSq.getX(), dropSq.getY(), 28, 118);
				playerPanel.add(randBSLabel);
				playerPanel.repaint();
				playerPanel.revalidate();
				bsD = true;
				}
			}
		}
		
		// Set Carrier
		while (caD == false) {
			randOrient = randInt(0,1);	
			
			if(randOrient == 0){
				JLabel randBSLabel = new JLabel();
    			randBSLabel.setIcon(carrier.getIcon());
    			randomX = randInt(21, 319);
    			randomY = randInt(30, 300);	
    			Point randPoint = new Point(randomX, randomY);
    			GetSquareDropped dropSq = new GetSquareDropped(randPoint, "carrier");
			
			if (GetSquareDropped.validDrop) {
				randBSLabel.setBounds(dropSq.getX(), dropSq.getY(), 148, 28);
				playerPanel.add(randBSLabel);
				playerPanel.repaint();
				playerPanel.revalidate();
				caD = true;
			}
			}
			else if (randOrient == 1){
				JLabel randBSLabel = new JLabel();
				randBSLabel.setIcon(carrierV.getIcon());
				randomX = randInt(21, 319);
				randomY = randInt(30, 300);
				Point randPoint = new Point(randomX, randomY);
				GetSquareDropped dropSq = new GetSquareDropped(randPoint, "carrierV");
			
				if (GetSquareDropped.validDrop) {					
				randBSLabel.setBounds(dropSq.getX(), dropSq.getY(), 28, 148);
				playerPanel.add(randBSLabel);
				playerPanel.repaint();
				playerPanel.revalidate();
				caD = true;
				}
			}
		}

		// Set Cruiser
		while (crD == false) {
			
			randOrient = randInt(0,1);	
		
			if(randOrient == 0){
				JLabel randBSLabel = new JLabel();
    			randBSLabel.setIcon(cruiser.getIcon());
    			randomX = randInt(21, 319);
    			randomY = randInt(30, 300);	
    			Point randPoint = new Point(randomX, randomY);
    			GetSquareDropped dropSq = new GetSquareDropped(randPoint, "cruiser");
			
			if (GetSquareDropped.validDrop) {
				randBSLabel.setBounds(dropSq.getX(), dropSq.getY(), 118, 28);
				playerPanel.add(randBSLabel);
				playerPanel.repaint();
				playerPanel.revalidate();
				crD = true;
			}
			}
			else if (randOrient == 1){
				JLabel randBSLabel = new JLabel();
				randBSLabel.setIcon(cruiserV.getIcon());
				randomX = randInt(21, 319);
				randomY = randInt(30, 300);
				Point randPoint = new Point(randomX, randomY);
				GetSquareDropped dropSq = new GetSquareDropped(randPoint, "cruiserV");
			
				if (GetSquareDropped.validDrop) {
				randBSLabel.setBounds(dropSq.getX(), dropSq.getY(), 28, 118);
				playerPanel.add(randBSLabel);
				playerPanel.repaint();
				playerPanel.revalidate();
				crD = true;
				}
			}
		}

		// Set Submarine
		while (sD == false) {
			randOrient = randInt(0,1);	
			
			if(randOrient == 0){
				JLabel randBSLabel = new JLabel();
    			randBSLabel.setIcon(submarine.getIcon());
    			randomX = randInt(21, 319);
    			randomY = randInt(30, 300);	
    			Point randPoint = new Point(randomX, randomY);
    			GetSquareDropped dropSq = new GetSquareDropped(randPoint, "sub");
			
    			if (GetSquareDropped.validDrop) {
    				randBSLabel.setBounds(dropSq.getX(), dropSq.getY(), 88, 28);
    				playerPanel.add(randBSLabel);
    				playerPanel.repaint();
    				playerPanel.revalidate();
    				sD = true;
			}
			}
			else if (randOrient == 1){
				JLabel randBSLabel = new JLabel();
				randBSLabel.setIcon(submarineV.getIcon());
				randomX = randInt(21, 319);
				randomY = randInt(30, 300);
				Point randPoint = new Point(randomX, randomY);
				GetSquareDropped dropSq = new GetSquareDropped(randPoint, "subV");
			
				if (GetSquareDropped.validDrop) {
    				randBSLabel.setBounds(dropSq.getX(), dropSq.getY(), 28, 88);
    				playerPanel.add(randBSLabel);
    				playerPanel.repaint();
    				playerPanel.revalidate();
    				sD = true;
				}
			}
		}

		// Set Destroyer
		while (dD == false) {
			randOrient = randInt(0,1);	
	
			if(randOrient == 0){
				JLabel randBSLabel = new JLabel();
    			randBSLabel.setIcon(destroyer.getIcon());
    			randomX = randInt(21, 319);
    			randomY = randInt(30, 300);	
    			Point randPoint = new Point(randomX, randomY);
    			GetSquareDropped dropSq = new GetSquareDropped(randPoint, "destroyer");
			
			if (GetSquareDropped.validDrop) {
				randBSLabel.setBounds(dropSq.getX(), dropSq.getY(), 58, 28);
				playerPanel.add(randBSLabel);
				playerPanel.repaint();
				playerPanel.revalidate();
				dD = true;
			}
			}
			else if (randOrient == 1){
				JLabel randBSLabel = new JLabel();
				randBSLabel.setIcon(destroyerV.getIcon());
				randomX = randInt(21, 319);
				randomY = randInt(30, 300);
				Point randPoint = new Point(randomX, randomY);
				GetSquareDropped dropSq = new GetSquareDropped(randPoint, "destroyerV");
			
				if (GetSquareDropped.validDrop) {
				randBSLabel.setBounds(dropSq.getX(), dropSq.getY(), 28, 58);
				playerPanel.add(randBSLabel);
				playerPanel.repaint();
				playerPanel.revalidate();
				dD = true;
				}
			}
		}
		
		readyButton.setEnabled(true);

	}

	private void hostButtonActionPerformed(ActionEvent evt) {
		hostButton.setEnabled(false);
		connectButton.setEnabled(false);		
		isServer = true;
		playerTurn = true;
		{
			Runnable serverRunnable = new Runnable() {
				@Override
				public void run() {
					runServer();
				}
			};
			Thread serverThread = new Thread(serverRunnable);
			serverThread.start(); 
		}
	}

	private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {
		connectButton.setEnabled(false);
		hostButton.setEnabled(false);
		{
			Runnable serverRunnable = new Runnable() {
				@Override
				public void run() {
				
					runClient(ipAddress);
				}
			};
			Thread serverThread = new Thread(serverRunnable);
			serverThread.start(); // run server application
		}
	}

	
	/******** Start of server Methods *************/
	// set up and run server
	private void runServer() {
		try // set up server to receive connections; process connections
		{
			serverSocket = new ServerSocket(12345, 100); // create ServerSocket

			while (true) {
				try {
					waitForConnection(); // wait for a connection
					getStreams(); // get input & output streams
					processConnection(); // process connection
				} // end try
				catch (EOFException eofException) {
					displayMessage("\nHost terminated connection");
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
		displayMessage("\nConnection " + counter + " received from: " + connection.getInetAddress().getHostName());
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
		String message = "\nConnection successful, *sent from server* ";
		sendData(message); // send connection successful message
		// enable enterField so server user can send messages
		setTextFieldEditable(true);

		do // process messages sent from client
		{
			try // read message and display it
			{

				message = (String) input.readObject(); // read new message

				/*
				 * During the players turn, valid messages received from the
				 * enemy are as follows: "!!x,y" //hit "??x,y //miss "^^z"
				 * //sunk ship z corresponds to ship 0,1,2,3,4 where 0 =
				 * battleship, 1 = carrier, 2 = cruiser, 3 = sub, 4 = destroyer
				 * ">>>" //the player has sunk all 5 enemy ships and therefore
				 * won the game
				 */
				if ((message.length() == 5)) {
					char l = message.charAt(0);
					char m = message.charAt(1);

					if ((l == '@' && m == '@') || (l == '!' && m == '!') || (l == '?' && m == '?') || (l == '^' && m == '^') || (l == '>' && m == '>') || (l == '#' && m == '#')) {
						// filters the string message to determine if it is a
						// game event or just a user message.
						// if it is a game event, Gameplay class handles it.

						message = game.Translate(message);

						sendData(message);
					}
					// message is length 5 but not a GEM
					else
						displayMessage("\nClient says>>> " + message);
				}
				// message is not length 5
				else if (message != null)
					displayMessage("\nClient says>>> "+message);

			} // end try
			catch (ClassNotFoundException classNotFoundException) {
				displayMessage("\nUnknown object type received");
			} // end catch

		} while (!message.equals("TERMINATE"));
	} // end method processConnection

	// close streams and socket
	private void closeConnection() {
		displayMessage("\nTerminating connection\n");
		setTextFieldEditable(false); // disable enterField
		connectButton.setEnabled(true);
		hostButton.setEnabled(true);
		try {
			output.close(); // close output stream
			input.close(); // close input stream
			connection.close(); // close socket
		} // end try
		catch (IOException ioException) {
			ioException.printStackTrace();
		} // end catch

		// allows for multiple connections without restarting game

	} // end method closeConnection

	// send message to client
	public void sendData(String message) {
		try // send object to client
		{
			output.writeObject(message);
			output.flush(); // flush output to client
		} // end try
		catch (IOException ioException) {
			messageTextArea.append("\nError writing object");
		} // end catch
	} // end method sendData

	// manipulates displayArea in the event-dispatch thread
	public static void displayMessage(final String messageToDisplay) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() // updates displayArea
			{
				messageTextArea.append(messageToDisplay); // append message
			} // end method run
		} // end anonymous inner class
				); // end call to SwingUtilities.invokeLater
	} // end method displayMessage

	// manipulates enterField in the event-dispatch thread
	private void setTextFieldEditable(final boolean editable) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() // sets enterField's editability
			{
				userChatEnter.setEditable(editable);
			} // end method run
		} // end inner class
				); // end call to SwingUtilities.invokeLater
	} // end method setTextFieldEditable

	
	/******** Start of client Methods *************/
	// set up and run client
	private void runClient(String ipAddress) {
	
		chatServer = ipAddress;
		
		try // connect to server, get streams, process connection
		{
			connectToServer(); // create a Socket to make connection
			getStreamsClient(); // get the input and output streams
			processConnectionClient(); // process connection
		} // end try
		catch (EOFException eofException) {
			displayMessage("\nClient terminated connection");
		} // end catch
		catch (IOException ioException) {
			ioException.printStackTrace();
		} // end catch

		finally {
			closeConnectionClient(); // close connection
		} // end finally

	}

	// connect to server
	private void connectToServer() throws IOException {
		displayMessage("Attempting connection\n");

		// create Socket to make connection to server
		client = new Socket(InetAddress.getByName(chatServer), 12345);

		// display connection information
		displayMessage("\nConnected to: " + client.getInetAddress().getHostName());
	} // end method connectToServer

	// get streams to send and receive data
	private void getStreamsClient() throws IOException {
		// set up output stream for objects
		outputClient = new ObjectOutputStream(client.getOutputStream());
		outputClient.flush(); // flush output buffer to send header information

		// set up input stream for objects
		input = new ObjectInputStream(client.getInputStream());

		displayMessage("\nGot I/O streams\n");
	} // end method getStreams

	// process connection with server
	private void processConnectionClient() throws IOException {
		// enable enterField so client user can send messages
		setTextFieldEditable(true);

		do // process messages sent from server
		{
			try // read message and display it
			{
				message = (String) input.readObject(); // read new message

				if ((message.length() == 5)) {
					char l = message.charAt(0);
					char m = message.charAt(1);

					if ((l == '@' && m == '@') || (l == '!' && m == '!') || (l == '?' && m == '?') || 
							(l == '^' && m == '^') || (l == '>' && m == '>') || (l == '#' && m == '#')) {
						// filters the string message to determine if it is a
						// game event or just a user message.
						// if it is a game event, Gameplay class handles it.

						
						message = game.Translate(message);

						sendDataClient(message);
					}
					// message is length 5 but not a GEM
					else
						displayMessage("\nServer says >>> " + message);
				}
				// message != 5
				else if (message != null)
					displayMessage("\nServer says >>> " + message);

			} // end try
			catch (ClassNotFoundException classNotFoundException) {
				displayMessage("\nUnknown object type received");
			} // end catch

		} while (!message.equals("TERMINATE"));
	} // end method processConnection

	// close streams and socket
	private void closeConnectionClient() {
		displayMessage("\nClosing connection");
		setTextFieldEditable(false); // disable enterField

		try {
			outputClient.close(); // close output stream
			inputClient.close(); // close input stream
			client.close(); // close socket
		} // end try
		catch (IOException ioException) {
			ioException.printStackTrace();
		} // end catch
	} // end method closeConnection

	// manipulates displayArea in the event-dispatch thread
	public void sendDataClient(String message) {
		try // send object to client
		{
			outputClient.writeObject(message);
			outputClient.flush(); // flush output to client
			
		} // end try
		catch (IOException ioException) {
			messageTextArea.append("\nError writing object");
		} // end catch
	} // end method sendData
	
	
	
	
	
	// Main Method
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
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Battleship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Battleship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Battleship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Battleship.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Battleship().setVisible(true);
			}
		});

	}	
}
