import javax.swing.JLabel;


public class Ship extends JLabel {
	 private String nameOfShip =" ";
	    private int hitPoints=0;
	    private int xCord=0, yCord=0;
	    private int orientation=1;
	    private String imageName= " ";
	/**
	 * @param args
	 */

	    
	   
	    
	    
	    public String getName(){
	        return nameOfShip;
	    }
	    
	    public void setName(String name){
	        nameOfShip = name;
	    }
	    
	    public int getHP(){
	        return hitPoints;
	    }
	    
	     public void setHP(int hp){
	        hitPoints = hp;
	    }
	    
	    public int getX(){
	        return xCord;
	    }
	    
	    public void setX(int x){
	        xCord = x;
	    }
	    
	    public int getY(){
	        return yCord;
	    }
	    
	    public void setY(int y){
	        yCord = y;
	    }
	    
	    public int getOrientation(){
	        return orientation;
	    }
	    
	    public void setOrientation(int orient){
	        orientation = orient;
	    }
	    
	    public String getImageName(){
	        return imageName;
	    }
	    
	    public void setImageName(String str){
	        imageName = str;
	    }
	    
	    
	    
	    
	}
