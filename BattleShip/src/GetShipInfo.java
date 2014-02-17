public class GetShipInfo {
	private int minX, minY, maxX, maxY, shipLength, shipWidth, orientation;
	private String ship;
	public GetShipInfo(String draggedShip) {
		// determines panel boundary for specific ships

		// This value changes depending on which computer I am on...
		// Sets layout information for each ship
		if (draggedShip
				.equals("file:/P:/git/Battleship/BattleShip/bin/Battleship.png")) {
			maxX = 229;
			maxY = 320;
			minY = 20;
			minX = 8;
			shipLength = 118;
			shipWidth = 28;
			ship = "Battleship";

		} else if (draggedShip
				.equals("file:/P:/git/Battleship/BattleShip/bin/carrier.jpg")) {
			maxX = 199;
			maxY = 320;
			minY = 20;
			minX = 8;
			shipLength = 148;
			shipWidth = 28;
			ship = "Carrier";

		} else if (draggedShip
				.equals("file:/P:/git/Battleship/BattleShip/bin/Cruiser.jpg")) {
			maxX = 229;
			maxY = 320;
			minY = 20;
			minX = 8;
			shipLength = 118;
			shipWidth = 28;
			ship = "Cruiser";
		} else if (draggedShip
				.equals("file:/P:/git/Battleship/BattleShip/bin/Destroyer.jpg")) {
			maxX = 289;
			maxY = 320;
			minY = 20;
			minX = 8;
			shipLength = 58;
			shipWidth = 28;
			ship = "Destroyer";
		} else if (draggedShip
				.equals("file:/P:/git/Battleship/BattleShip/bin/Submarine.jpg")) {
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