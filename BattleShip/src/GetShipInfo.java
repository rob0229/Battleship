public class GetShipInfo {
	private int minX, minY, maxX, maxY, shipLength, shipWidth, orientation;
	private String ship;
	public GetShipInfo(String draggedShip) {
		// determines panel boundary for specific ships

		// This value changes depending on which computer I am on...
		// Sets layout information for each ship
		if (draggedShip
				.equals(ConstantData.battleShip) || draggedShip.equals(ConstantData.pbs)) {
			maxX = 229;
			maxY = 320;
			minY = 20;
			minX = 8;
			shipLength = 118;
			shipWidth = 28;
			ship = "Battleship";

		} else if (draggedShip
				.equals(ConstantData.carrier) || draggedShip.equals(ConstantData.pca)) {
			maxX = 199;
			maxY = 320;
			minY = 20;
			minX = 8;
			shipLength = 148;
			shipWidth = 28;
			ship = "Carrier";

		} else if (draggedShip
				.equals(ConstantData.cruiser) || draggedShip.equals(ConstantData.pcr)) {
			maxX = 229;
			maxY = 320;
			minY = 20;
			minX = 8;
			shipLength = 118;
			shipWidth = 28;
			ship = "Cruiser";
		} else if (draggedShip
				.equals(ConstantData.destroyer) || draggedShip.equals(ConstantData.pd)) {
			maxX = 289;
			maxY = 320;
			minY = 20;
			minX = 8;
			shipLength = 58;
			shipWidth = 28;
			ship = "Destroyer";
		} else if (draggedShip
				.equals(ConstantData.submarine) || draggedShip.equals(ConstantData.ps)) {
			maxX = 260;
			maxY = 320;
			minY = 20;
			minX = 8;
			shipLength = 88;
			shipWidth = 28;
			ship = "Submarine";
		} else
			System.out
					.println("The ship is not recognized and will not move correctly");
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
	public void setOrientation(int or){
		orientation = or;
		
	}

}