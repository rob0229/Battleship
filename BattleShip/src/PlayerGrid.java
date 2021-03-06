/**
 Create player grid which is just an 2D string array
 Copyright: Rob Close and Charlie Sun
 Created on: 03/01/2014
 */

public class PlayerGrid {
	private String[][] playerGrid;

	public PlayerGrid() {

		playerGrid = new String[10][10];

		for (int r = 0; r < playerGrid.length; r++) {
			for (int col = 0; col < playerGrid[r].length; col++) {
				playerGrid[r][col] = "~";

			}
		}
	}

	public String getGridContents(int x, int y) {
		return playerGrid[x][y];
	}

	public void setGridContents(int x, int y, String str) {
		playerGrid[x][y] = str;
	}

}
