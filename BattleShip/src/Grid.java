

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import java.net.InetAddress;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Grid extends JFrame {
	private JPanel playerPanel; 
	private JPanel enemyPanel; // panel for board
	private JPanel panel2; // panel to hold board
	private Square[][] playerGrid; // board
	private Square[][] enemyGrid;

	public Grid(){ 
		playerPanel = new JPanel(); // set up panel for squares in board
	    playerPanel.setLayout( new GridLayout( 10, 10, 0, 0 ) );	
	    playerGrid = new Square[10][10]; // create Grid
	    
	    enemyPanel = new JPanel(); // set up panel for squares in board
	    enemyPanel.setLayout( new GridLayout( 10, 10, 0, 0 ) );	
	    enemyGrid = new Square[10][10]; // create Grid
	    
	    playerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Player Board"));
	    enemyPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Enemy Board"));
	    // loop over the rows in the board
	    for ( int row = 0; row < playerGrid.length; row++ ) 
	    {
	       // loop over the columns in the board
	       for ( int column = 0; column < playerGrid[ row ].length; column++ ) 
	       {
	          // create square
	          playerGrid[ row ][ column ] = new Square( " ", row, column);
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
	    
	    
	    panel2 = new JPanel(); // set up panel to contain boardPanel
	    panel2.add( playerPanel); // add board panel
	    panel2.add(enemyPanel);
	    add(panel2); // add container panel
	      
	    setSize( 1000, 1000 ); // set size of window
	    setVisible( true ); // show window
	      
	}
	
	   // private inner class for the squares on the board
	   private class Square extends JPanel 
	   {
	      private String contents; // mark to be drawn in this square
	      private int xCord;
	      private int yCord;// location of square
	   
	      public Square( String squareContents, int x, int y )
	      {
	    	  contents = squareContents; // set mark for this square
	    	 
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
	
					System.out.println("The square x = "+xCord+" y = "+ yCord);
					
				}
	            } // end anonymous inner class
	         ); // end call to addMouseListener
	         	      
	      } // end Square constructor


	      // return preferred size of Square
	      public Dimension getPreferredSize() 
	      { 
	         return new Dimension( 31, 31 ); // return preferred size
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

	         g.drawRect( 0, 0, 30, 30 ); // draw square
	         //g.drawString( contents, 11, 20 ); // draw mark   
	      } // end method paintComponent
	   } // end inner-class Square
	
	
	public static void main( String[] args )
	   {
	      Grid application = new Grid();
	   } // end main
	
	
}
