public class GetShipInfo {
	private int minX, minY, maxX, maxY, shipLength, shipWidth;
	private static int orientation;
	private String ship;
	public GetShipInfo(String draggedShip) {
		// determines panel boundary for specific ships

		// This value changes depending on which computer I am on...
		// Sets layout information for each ship horizontal ship
		
    		if (draggedShip
    				.equals(ConstantData.BATTLESHIP) || draggedShip.equals(ConstantData.PBS) ||draggedShip.equals("battleShip") ) {
    			maxX = 229;
    			maxY = 320;
    			minY = 20;
    			minX = 8;
    			shipLength = 118;
    			shipWidth = 28;
    			ship = "Battleship";
    			orientation = 0;
    
    		} else if (draggedShip
    				.equals(ConstantData.CARRIER) || draggedShip.equals(ConstantData.PCA)||draggedShip.equals("carrier")) {
    			maxX = 199;
    			maxY = 320;
    			minY = 20;
    			minX = 8;
    			shipLength = 148;
    			shipWidth = 28;
    			ship = "Carrier";
    			orientation = 0;
    
    		} else if (draggedShip
    				.equals(ConstantData.CRUISER) || draggedShip.equals(ConstantData.PCR)||draggedShip.equals("cruiser")) {
    			maxX = 229;
    			maxY = 320;
    			minY = 20;
    			minX = 8;
			shipLength = 118;
    			shipWidth = 28;
    			ship = "Cruiser";
    			orientation = 0;
    		} else if (draggedShip
    				.equals(ConstantData.DESTROYER) || draggedShip.equals(ConstantData.PD)||draggedShip.equals("destroyer")) {
    			maxX = 289;
    			maxY = 320;
    			minY = 20;
    			minX = 8;
    			shipLength = 58;
    			shipWidth = 28;
    			ship = "Destroyer";
    			orientation = 0;
    		} else if (draggedShip
    				.equals(ConstantData.SUBMARINE) || draggedShip.equals(ConstantData.PS)||draggedShip.equals("sub")) {
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
					.equals(ConstantData.BATTLESHIPVERT) || draggedShip.equals(ConstantData.PBSVERT) ||draggedShip.equals("battleShip_r") ) {
				maxX = 320;
				maxY = 229;
				minY = 20;
				minX = 8;
				shipLength = 28;
				shipWidth = 118;
				ship = "Battleship_r";
				orientation = 1;

			} else if (draggedShip
					.equals(ConstantData.CARRIERVERT) || draggedShip.equals(ConstantData.PCAVERT)||draggedShip.equals("carrier_r")) {
				maxX = 320;
				maxY = 199;
				minY = 20;
				minX = 8;
				shipLength = 28;
				shipWidth = 148;
				ship = "Carrier_r";
				orientation = 1;

			} else if (draggedShip
					.equals(ConstantData.CRUISERVERT) || draggedShip.equals(ConstantData.PCRVERT)||draggedShip.equals("cruiser_r")) {
				maxX = 320;
				maxY = 229;
				minY = 20;
				minX = 8;
				shipLength = 28;
				shipWidth = 118;
				ship = "Cruiser_r";
				orientation = 1;
			} else if (draggedShip
					.equals(ConstantData.DESTROYERVERT) || draggedShip.equals(ConstantData.PDVERT)||draggedShip.equals("destroyer_r")) {
				maxX = 320;
				maxY = 289;
				minY = 20;
				minX = 8;
				shipLength = 28;
				shipWidth = 58;
				ship = "Destroyer_r";
				orientation = 1;
			} else if (draggedShip
					.equals(ConstantData.SUBMARINEVERT) || draggedShip.equals(ConstantData.PSVERT)||draggedShip.equals("sub_r")) {
				maxX = 320;
				maxY = 260;
				minY = 20;
				minX = 8;
				shipLength = 28;
				shipWidth = 88;
				ship = "Submarine_r";
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

}
