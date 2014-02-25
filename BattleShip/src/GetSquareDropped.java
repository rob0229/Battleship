import java.awt.Point;

public class GetSquareDropped {
	int x, y, x2, y2, minX, maxX, minY, maxY;
	String ship;
	static int orient = 0;
	static Boolean validDrop = true;
	static Boolean bsPlaced = false;
	static Boolean carrierPlaced = false;
	static Boolean destroyerPlaced = false;
	static Boolean cruiserPlaced = false;
	static Boolean subPlaced = false;

	public GetSquareDropped(Point point, String draggedShip) {
		GetShipInfo getShipInfo = new GetShipInfo(draggedShip);

		// resets valid drop for each call since it is static
		validDrop = true;
		x = (int) point.getX();
		y = (int) point.getY();
		minX = getShipInfo.getMinX();
		maxX = getShipInfo.getMaxX();
		minY = getShipInfo.getMinY();
		maxY = getShipInfo.getMaxY();
		ship = getShipInfo.getShip();
		orient = getShipInfo.getOrientation();// 0 horizontal, 1 vertical
		String shipName = getShipInfo.getShip();

		// Keeps ship placement inside boarders of panel for horizontal ships
		if (x > getShipInfo.getMaxX() && orient == 0) {
			x = maxX;
		}
		if (x < minX && orient == 0) {
			x = minX;
		}
		if (y > maxY && orient == 0) {
			y = maxY;
		}
		if (y < minY && orient == 0) {
			y = minY;
		}

		if (x > getShipInfo.getMaxX() && orient == 1) {
			x = maxX;
		}
		if (x < minX && orient == 1) {
			x = minX;
		}
		if (y > maxY && orient == 1) {
			y = maxY;
		}
		if (y < minY && orient == 1) {
			y = minY;
		}

		// converts drop point to grid square
		x2 = (x - 21) / 30;
		y2 = (y - 32) / 30;

		// alters drop point to set ship in grid correctly
		x = (x2 * 30) + 21;
		y = (y2 * 30) + 32;

		// Prevents ships from being placed on top of each other
		if (shipName.equals("Battleship") && orient == 0) {

			for (int i = 0; i < 2; i++) {
				if (Battleship.playerGrid.getGridContents(x2 + i, y2) != "~") {
					validDrop = false;
				}
			}

			if (validDrop) {
				for (int i = 0; i < 4; i++) {
					Battleship.playerGrid.setGridContents(x2 + i, y2, "B");
				}
				bsPlaced = true;
				Battleship.battleshipImageLabel.setVisible(false);
				Battleship.battleshipImageLabelVERT.setVisible(false);
			} else
				System.out.println("You cannot place the ship there");
		}

		if (shipName.equals("Battleship_r") && orient == 1) {

			for (int i = 0; i < 4; i++) {
				if (Battleship.playerGrid.getGridContents(x2, y2 + i) != "~") {
					validDrop = false;
				}

			}
			if (validDrop) {
				for (int i = 0; i < 4; i++) {
					Battleship.playerGrid.setGridContents(x2, y2 + i, "B");
				}
				bsPlaced = true;
				Battleship.battleshipImageLabel.setVisible(false);
				Battleship.battleshipImageLabelVERT.setVisible(false);
			} else
				System.out.println("You cannot place the ship there");
		}

		if (shipName.equals("Carrier") && orient == 0) {

			for (int i = 0; i < 5; i++) {
				if (Battleship.playerGrid.getGridContents(x2 + i, y2) != "~") {
					validDrop = false;
				}
			}
			if (validDrop) {
				for (int i = 0; i < 5; i++) {
					Battleship.playerGrid.setGridContents(x2 + i, y2, "C");
				}
				carrierPlaced = true;
				Battleship.carrierImageLabel.setVisible(false);
				Battleship.carrierImageLabelVERT.setVisible(false);
			} else
				System.out.println("You cannot place the ship there");
		}

		if (shipName.equals("Carrier_r") && orient == 1) {

			for (int i = 0; i < 5; i++) {

				if (Battleship.playerGrid.getGridContents(x2, y2 + i) != "~") {
					validDrop = false;

				}
			}
			if (validDrop) {
				for (int i = 0; i < 5; i++) {
					Battleship.playerGrid.setGridContents(x2, y2 + i, "C");
				}
				carrierPlaced = true;

				Battleship.carrierImageLabel.setVisible(false);
				Battleship.carrierImageLabelVERT.setVisible(false);
			} else
				System.out.println("You cannot place the ship there");
		}

		if (shipName.equals("Cruiser") && orient == 0) {

			for (int i = 0; i < 4; i++) {
				if (Battleship.playerGrid.getGridContents(x2 + i, y2) != "~") {
					validDrop = false;
				}
			}
			if (validDrop) {
				for (int i = 0; i < 4; i++) {
					Battleship.playerGrid.setGridContents(x2 + i, y2, "Z");
				}
				cruiserPlaced = true;
				Battleship.cruiserImageLabel.setVisible(false);
				Battleship.cruiserImageLabelVERT.setVisible(false);
			} else
				System.out.println("You cannot place the ship there");
		}
		if (shipName.equals("Cruiser_r") && orient == 1) {

			for (int i = 0; i < 4; i++) {
				if (Battleship.playerGrid.getGridContents(x2, y2 + i) != "~") {
					validDrop = false;
				}

			}
			if (validDrop) {
				for (int i = 0; i < 4; i++) {
					Battleship.playerGrid.setGridContents(x2, y2 + i, "Z");
				}
				cruiserPlaced = true;
				Battleship.cruiserImageLabel.setVisible(false);
				Battleship.cruiserImageLabelVERT.setVisible(false);
			} else
				System.out.println("You cannot place the ship there");
		}
		if (shipName.equals("Submarine") && orient == 0) {

			for (int i = 0; i < 3; i++) {
				if (Battleship.playerGrid.getGridContents(x2 + i, y2) != "~") {
					validDrop = false;
				}
			}
			if (validDrop) {
				for (int i = 0; i < 3; i++) {
					Battleship.playerGrid.setGridContents(x2 + i, y2, "S");
				}
				subPlaced = true;
				Battleship.submarineImageLabel.setVisible(false);
				Battleship.submarineImageLabelVERT.setVisible(false);
			} else
				System.out.println("You cannot place the ship there");
		}

		if (shipName.equals("Submarine_r") && orient == 1) {

			for (int i = 0; i < 3; i++) {
				if (Battleship.playerGrid.getGridContents(x2, y2 + i) != "~") {
					validDrop = false;
				}

			}
			if (validDrop) {
				for (int i = 0; i < 3; i++) {
					Battleship.playerGrid.setGridContents(x2, y2 + i, "S");
				}
				subPlaced = true;
				Battleship.submarineImageLabel.setVisible(false);
				Battleship.submarineImageLabelVERT.setVisible(false);
			} else
				System.out.println("You cannot place the ship there");
		}

		if (shipName.equals("Destroyer") && orient == 0) {

			for (int i = 0; i < 2; i++) {
				if (Battleship.playerGrid.getGridContents(x2 + i, y2) != "~") {
					validDrop = false;
				}
			}

			if (validDrop) {
				for (int i = 0; i < 2; i++) {
					Battleship.playerGrid.setGridContents(x2 + i, y2, "D");
				}
				destroyerPlaced = true;
				Battleship.destroyerImageLabel.setVisible(false);
				Battleship.destroyerImageLabelVERT.setVisible(false);
			} else
				System.out.println("You cannot place the ship there");
		}

		if (shipName.equals("Destroyer_r") && orient == 1) {

			for (int i = 0; i < 2; i++) {
				if (Battleship.playerGrid.getGridContents(x2, y2 + i) != "~") {
					validDrop = false;
				}

			}
			if (validDrop) {
				for (int i = 0; i < 2; i++) {
					Battleship.playerGrid.setGridContents(x2, y2 + i, "D");
				}
				destroyerPlaced = true;
				Battleship.destroyerImageLabel.setVisible(false);
				Battleship.destroyerImageLabelVERT.setVisible(false);
			} else
				System.out.println("You cannot place the ship there");

		}

		for (int i = 0; i < 10; i++) {
			System.out.println();
			for (int j = 0; j < 10; j++) {
				System.out.print(" " + Battleship.playerGrid.getGridContents(j, i) + " ");
			}
		}

	}

	public static Boolean allShipsPlaced() {
		if (bsPlaced && cruiserPlaced && carrierPlaced && subPlaced && destroyerPlaced)
			return true;
		else
			return false;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
