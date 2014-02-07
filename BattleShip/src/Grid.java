

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
	private JPanel boardPanel; // panel for board
	private JPanel panel2; // panel to hold board
	private Square[][] board; // board

	public Grid(){ 
		boardPanel = new JPanel(); // set up panel for squares in board
	    boardPanel.setLayout( new GridLayout( 10, 10, 0, 0 ) );
	
	    board = new Square[ 10 ][ 10 ]; // create board
	
	    // loop over the rows in the board
	    for ( int row = 0; row < board.length; row++ ) 
	    {
	       // loop over the columns in the board
	       for ( int column = 0; column < board[ row ].length; column++ ) 
	       {
	          // create square
	          board[ row ][ column ] = new Square( " ", row * 3 + column );
	          boardPanel.add( board[ row ][ column ] ); // add square       
	       } // end inner for
	    } // end outer for
	    
	    panel2 = new JPanel(); // set up panel to contain boardPanel
	    panel2.add( boardPanel); // add board panel
	    add(panel2); // add container panel
	      
	    setSize( 600, 550 ); // set size of window
	    setVisible( true ); // show window
	      
	}
	
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
	
	
	public static void main( String[] args )
	   {
	      Grid application = new Grid();
	   } // end main
	
	
}
