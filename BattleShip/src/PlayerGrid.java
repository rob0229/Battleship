import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;


public class PlayerGrid {
	private Square[][] playerGrid;
	
	public PlayerGrid(JPanel playerPanel){
		
		
		playerGrid = new Square[10][10]; 
		 for ( int r = 0; r < playerGrid.length; r++ ) { 
		       for ( int col = 0; col < playerGrid[ r ].length; col++ ) 
		       {		          	    	
		        playerGrid[ r ][ col ] = new Square( " ",r, col);
		        new MyDropTargetListener(playerPanel);
		       }
		} 
	}
}
	





