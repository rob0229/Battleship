
public class PlayerGrid {

	/**
	 * @param args
	 */
	    private char[][] grid;
	    
	    
	    
	    
	    public char getContents(int x, int y){
	        return grid[x][y]; 
	    }
	    
	    public void setContents(int x, int y, char c){
	           grid[x][y] = c; 
	    }
	    
	    
	    
	}