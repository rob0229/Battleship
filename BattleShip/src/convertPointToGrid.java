import java.awt.Point;


public class convertPointToGrid {
	
	
	
	public convertPointToGrid(Point p){
	
		init(p);
	
	}
	
	
	private Point init(Point p){
		Point grid = p;
		int x, y;
		
		x = (int) p.getX();
		y = (int) p.getY();
		
		x = x%30;
		y = y%30;
		
		grid.setLocation(x,y);
		
	
		return grid;
	}
	
	

}
