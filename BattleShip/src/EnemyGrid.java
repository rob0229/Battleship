/**
 Create enemy grid which is just an 2D string array
 Copyright: Rob Close and Charlie Sun
 Created on: 03/01/2014
 */

public class EnemyGrid {

	private String[][] enemyGrid;

	public EnemyGrid() {

		enemyGrid = new String[10][10];

		for (int r = 0; r < enemyGrid.length; r++) {
			for (int col = 0; col < enemyGrid[r].length; col++) {
				enemyGrid[r][col] = "~";

			}
		}

	}

	public String getGridContents(int x, int y) {
		return enemyGrid[x][y];
	}

	public void setGridContents(int x, int y, String str) {
		enemyGrid[x][y] = str;
	}

}
