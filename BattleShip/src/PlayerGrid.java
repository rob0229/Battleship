import javax.swing.JPanel;


public class PlayerGrid {
	private Square[][] playerGrid;
	
	public PlayerGrid(JPanel playerPanel){
		

		playerGrid = new Square[10][10]; 
		 for ( int r = 0; r < playerGrid.length; r++ ) { 
		       for ( int col = 0; col < playerGrid[ r ].length; col++ ) 
		       {
		          // create squares	    	
		        playerGrid[ r ][ col ] = new Square( " ",r, col);
		        playerPanel.add( playerGrid[ r ][ col ] ); // add square  
		        new MyDropTargetListener(playerGrid[r][col], r , col);
		       }
		} 
	}
}
	





