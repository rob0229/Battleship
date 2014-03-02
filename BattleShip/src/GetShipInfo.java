/**
 Ship info for placement on panels
 Copyright: Rob Close and Charlie Sun
 Created on: 03/01/2014
 */

import javax.swing.ImageIcon;

public class GetShipInfo {
	private int minX, minY, maxX, maxY, shipLength, shipWidth;
	private static int orientation;
	private String ship;
	private static ImageIcon carrierIcon = new ImageIcon(ConstantData.CARRIER);
	private static ImageIcon bsIcon = new ImageIcon(ConstantData.BATTLESHIP);
	private static ImageIcon cruiserIcon = new ImageIcon(ConstantData.CRUISER);
	private static ImageIcon subIcon = new ImageIcon(ConstantData.SUBMARINE);
	private static ImageIcon destroyerIcon = new ImageIcon(ConstantData.DESTROYER);
	
	private static ImageIcon carrierIconV = new ImageIcon(ConstantData.CARRIERVERT);
	private static ImageIcon bsIconV = new ImageIcon(ConstantData.BATTLESHIPVERT);
	private static ImageIcon cruiserIconV = new ImageIcon(ConstantData.CRUISERVERT);
	private static ImageIcon subIconV = new ImageIcon(ConstantData.SUBMARINEVERT);
	private static ImageIcon destroyerIconV = new ImageIcon(ConstantData.DESTROYERVERT);
	
	public GetShipInfo(String draggedShip) {
		// determines panel boundary for specific ships

		// This value changes depending on which computer I am on...
		// Sets layout information for each ship horizontal ship
		
		
    		if (draggedShip.equals(ConstantData.BATTLESHIP) || draggedShip.equals("battleShip")) {
    			maxX = 229;
    			maxY = 320;
    			minY = 20;
    			minX = 8;
    			shipLength = 118;
    			shipWidth = 28;
    			ship = "Battleship";
    			orientation = 0;
    
    		} else if (draggedShip
    				.equals(ConstantData.CARRIER) || draggedShip.equals("carrier")) {
    			maxX = 199;
    			maxY = 320;
    			minY = 20;
    			minX = 8;
    			shipLength = 148;
    			shipWidth = 28;
    			ship = "Carrier";
    			orientation = 0;
    
    		} else if (draggedShip
    				.equals(ConstantData.CRUISER)||draggedShip.equals("cruiser")) {
    			maxX = 229;
    			maxY = 320;
    			minY = 20;
    			minX = 8;
			shipLength = 118;
    			shipWidth = 28;
    			ship = "Cruiser";
    			orientation = 0;
    		} else if (draggedShip
    				.equals(ConstantData.DESTROYER) ||draggedShip.equals("destroyer")) {
    			maxX = 289;
    			maxY = 320;
    			minY = 20;
    			minX = 8;
    			shipLength = 58;
    			shipWidth = 28;
    			ship = "Destroyer";
    			orientation = 0;
    		} else if (draggedShip
    				.equals(ConstantData.SUBMARINE) ||draggedShip.equals("sub")) {
    			maxX = 260;
    			maxY = 320;
    			minY = 20;
    			minX = 8;
    			shipLength = 88;
    			shipWidth = 28;
    			ship = "Submarine";
    			orientation = 0;
    		} 
    			
		
		//assigns parameters for vertical ships
		
    		else if (draggedShip
					.equals(ConstantData.BATTLESHIPVERT) ||draggedShip.equals("battleShipV") ) {
				maxX = 320;
				maxY = 229;
				minY = 20;
				minX = 8;
				shipLength = 28;
				shipWidth = 118;
				ship = "BattleshipV";
				orientation = 1;

			} else if (draggedShip
					.equals(ConstantData.CARRIERVERT) ||draggedShip.equals("carrierV")) {
				maxX = 320;
				maxY = 199;
				minY = 20;
				minX = 8;
				shipLength = 28;
				shipWidth = 148;
				ship = "CarrierV";
				orientation = 1;

			} else if (draggedShip
					.equals(ConstantData.CRUISERVERT)||draggedShip.equals("cruiserV")) {
				maxX = 320;
				maxY = 229;
				minY = 20;
				minX = 8;
				shipLength = 28;
				shipWidth = 118;
				ship = "CruiserV";
				orientation = 1;
			} else if (draggedShip
					.equals(ConstantData.DESTROYERVERT)||draggedShip.equals("destroyerV")) {
				maxX = 320;
				maxY = 289;
				minY = 20;
				minX = 8;
				shipLength = 28;
				shipWidth = 58;
				ship = "DestroyerV";
				orientation = 1;
			} else if (draggedShip
					.equals(ConstantData.SUBMARINEVERT) ||draggedShip.equals("subV")) {
				maxX = 320;
				maxY = 260;
				minY = 20;
				minX = 8;
				shipLength = 28;
				shipWidth = 88;
				ship = "SubmarineV";
				orientation = 1;
			} else
				System.out.println("The ship is not recognized and will not move correctly");
			
		
	}

	public int getMinX() {
		return minX;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public int getMinY() {
		return minY;
	}

	public int getShipWidth() {
		return shipWidth;
	}

	public int getShipLength() {
		return shipLength;
	}
	public String getShip() {
		return ship;
	}

	public int getOrientation(){
		return orientation;
	}
	public static void setOrientation(int or){
		orientation = or;
		
	}
	
	public static ImageIcon getIcon(String x){
	
		if(x.equals("carrier")){
    				return carrierIcon;
    				
		}	
		if(x.equals("battleship")){
			return bsIcon;
			
		}
		
		if (x.equals("cruiser")) {
			return cruiserIcon;
		}
		
		if (x.equals("sub")) {
			return subIcon;

		}
		if  (x.equals("destroyer")){
			return destroyerIcon;

		}	
		if(x.equals("carrierV")){
			return carrierIconV;
			
        }	
        if(x.equals("battleshipV")){
        	return bsIconV;
        	
        }
        
        if (x.equals("cruiserV")) {
        	return cruiserIconV;
        }
        
        if (x.equals("subV")) {
        	return subIconV;
        
        }
        else  {
        	return destroyerIconV;
        
        }	
	}

}
