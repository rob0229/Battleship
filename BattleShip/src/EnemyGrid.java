import java.awt.Color;

import javax.swing.JPanel;

public class EnemyGrid {

	private Square[][] enemyGrid;
	
	public EnemyGrid(JPanel enemyPanel){
		enemyGrid = new Square[10][10];
		
		 //creates enemyGrid
        for ( int row = 0; row < enemyGrid.length; row++ ) 
	    {
	       for ( int column = 0; column < enemyGrid[ row ].length; column++ ) 
	       {
	          // create squares
	    	   enemyGrid[ row ][ column ] = new Square( " ",row, column);
	    	   enemyGrid[row][column].setBackground(Color.blue);
	    	   enemyPanel.add( enemyGrid[ row ][ column ] ); // add square       
	       } 
	    }   
	}	
}
