

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import java.net.InetAddress;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.TransferHandler.TransferSupport;
import javax.swing.border.TitledBorder;

import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Grid extends JFrame {
	private JPanel shipPanel;
	private JPanel playerPanel; 
	private JPanel enemyPanel; // panel for board
	private JPanel panel; // panel to hold board
	private Square[][] playerGrid; // board
	private Square[][] enemyGrid;
	private javax.swing.JLabel battleshipImageLabel;
	private  Point droppedAt;
	
	public Grid(){ 
		
		int imageWidth = 120;
    	int imageHeight = 60;
    	String bsImageFile = "Battleship.jpg";
		
		panel = new JPanel(); // set up panel to contain boardPanel
		shipPanel = new JPanel();		
		battleshipImageLabel = new JLabel();
			
		playerPanel = new JPanel(); // set up panel for squares in board
	    playerPanel.setLayout( new GridLayout( 10, 10 ) );	
	    playerGrid = new Square[10][10]; // create Grid
	 
	    
	    enemyPanel = new JPanel(); // set up panel for squares in board
	    enemyPanel.setLayout( new GridLayout( 10, 10) );	
	    enemyGrid = new Square[10][10]; // create Grid
	    
	    shipPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ships"));
	    playerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Player Board"));
	    enemyPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Enemy Board"));
	    
	    // loop over the rows in the board
	    for ( int row = 0; row < playerGrid.length; row++ ) 
	    {
	       // loop over the columns in the board
	       for ( int column = 0; column < playerGrid[ row ].length; column++ ) 
	       {
	          // create square
	          playerGrid[ row ][ column ] = new Square( "-", row, column);
	          playerPanel.add( playerGrid[ row ][ column ] ); // add square       
	       } // end inner for
	    } // end outer for
	    
	   
	    
	    // loop over the rows in the board
	    for ( int row = 0; row < enemyGrid.length; row++ ) 
	    {
	       // loop over the columns in the board
	       for ( int column = 0; column < enemyGrid[ row ].length; column++ ) 
	       {
	          // create square
	    	   enemyGrid[ row ][ column ] = new Square( " ",row, column);
	          enemyPanel.add( enemyGrid[ row ][ column ] ); // add square       
	       } // end inner for
	    } // end outer for
	    
	    battleshipImageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("Battleship.jpg"))); // NOI18N
        battleshipImageLabel.setText("Battleship");
        battleshipImageLabel.setPreferredSize(new java.awt.Dimension(120, 30));
	    
	    
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(
        		   layout.createSequentialGroup()
        		      .addComponent(enemyPanel)
        		      .addComponent(playerPanel, 320, 320,
 	        		          320)
        		      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
        		           .addComponent(shipPanel))
        		          
        		);
        		layout.setVerticalGroup(
        		   layout.createSequentialGroup()
        		      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        		           .addComponent(enemyPanel, 320, 320,
     	        		          320))
        		           .addComponent(playerPanel, 320, 320,
      	        		          GroupLayout.PREFERRED_SIZE)
        		           .addComponent(shipPanel, 80, 82,
      	        		          GroupLayout.PREFERRED_SIZE)
        		      
        		);
        
        		layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
        		  .addComponent(enemyPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		  .addComponent(playerPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
        
        
        new MyDropTargetListener(playerPanel);
	    
	   
	   // shipPanel.add(battleshipImageLabel);
	   
	    add(panel); // add container panel
	      
	    setSize( 1000, 800 ); // set size of window
	    setVisible( true ); // show window
	    
	    
	    Image bsImage = Toolkit.getDefaultToolkit().getImage(DragImage.class.getResource(bsImageFile));	    
        bsImage = bsImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);       
        JLabel battleshipImage = new JLabel(new ImageIcon(bsImage));
        
        MyDragGestureListener dlistener = new MyDragGestureListener();
        DragSource ds1 = new DragSource();
        
        ds1.createDefaultDragGestureRecognizer(battleshipImage, DnDConstants.ACTION_COPY, dlistener);

        shipPanel.add(battleshipImage);
	      
	}
	
	
	class MyDropTargetListener extends DropTargetAdapter {

	    private DropTarget dropTarget;
	    private JPanel p;

	    public MyDropTargetListener(JPanel dropPanel) {
	        p = dropPanel;
	        dropTarget = new DropTarget(dropPanel, DnDConstants.ACTION_COPY, this, true, null);

	    }

	    @Override
	    public void drop(DropTargetDropEvent event) {
	    	Point dropPoint;
	        try {
	            DropTarget test = (DropTarget) event.getSource();
	            Component ca = (Component) test.getComponent();
	            
	            dropPoint = ca.getMousePosition();
	            droppedAt = dropPoint;
	            
	            //need to call a method here that determines the square the ship was dropped in so that the image file for the square
	            //can be updated with the appropriate image
	            System.out.println("Drop point is " + dropPoint);
     
	            //data that is transfered to new panel (ship image file)
	            Transferable tr = event.getTransferable();

	            //checks that the data being dragged is an imageFlavor
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

	            @Override
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
	
	
	   // private inner class for the squares on the board
	   private class Square extends JPanel 
	   {
	      private String contents ; // contents to be drawn in this square
	      private int xCord;
	      private int yCord;// location of square
	      private Image image;
	      
	      public Square( String squareContents, int x, int y )
	      {
	    	  contents = squareContents; // set contents for this square
	    	 
	    	  xCord = x;// set location of this square 
	    	  yCord = y;// set location of this square

	         addMouseListener( 
	            new MouseAdapter() 
	            {
	               public void mouseReleased( MouseEvent e )
	               {
	                  setCurrentSquare( Square.this ); // set current square

	               } // end method mouseReleased

				private void sendClickedSquare(Object squareLocation) {
					// TODO Auto-generated method stub
					
				}

				private Object getSquareLocation() {
					Square curr = new Square(contents, xCord, yCord);
					return curr;
				}

				private void setCurrentSquare(Square square) {
					//contents = "S";
					System.out.println("The square x = "+xCord+" y = "+ yCord + " with the contents of " + contents);
					repaint();
				}
				
				
	            } // end anonymous inner class
	         ); // end call to addMouseListener
	         	      
	      } // end Square constructor


	      public void setContents(String str) {
	    	  contents = str;
	      }
	           
	      // return preferred size of Square
	      public Dimension getPreferredSize() 
	      { 
	         return new Dimension( 30, 30); // return preferred size
	      } // end method getPreferredSize

	      // return minimum size of Square
	      public Dimension getMinimumSize() 
	      {
	         return getPreferredSize(); // return preferred size
	      } // end method getMinimumSize

	       //draw Square
	      public void paintComponent( Graphics g )
	      {
	        super.paintComponent( g );

	         g.drawRect( 0, 0, 30, 30 ); // draw square
	         g.drawString( contents, 11, 20 ); // draw contents  
	     } // end method paintComponent
	      
	     
	      
	      
	      
	   } // end inner-class Square
	
	   
	   public void addShipToSquares(Point dropAt, int shipType, int orient){
		   int x = (int)dropAt.getX();
		   int y = (int)dropAt.getY();
		   
		   
		   
		   if (x > 6 && x < 32 ){
		//	   playerGrid[0][0].setCurrentSquare() = "S";
			  // playerGrid[0][0].paintComponent((Battleship.jpg));
			   System.out.println("CONTENTS ARE "+ playerGrid[0][0].contents);
			   repaint();
			   
		   } 
		   else if(x>32 && x < 60 ){
			   playerGrid[0][1].contents = "S";
			   System.out.println("CONTENTS ARE "+ playerGrid[0][0].contents);
		   }
		   else if(x >=60 && x<89 ){
			   
			   
		   }
   
		   
	   }
	   
	   
	   
	   
	   
	
	public static void main( String[] args )
	   {
	      Grid application = new Grid();
	   } // end main
	
	
}
