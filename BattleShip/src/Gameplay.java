import java.awt.Point;

import javax.swing.JLabel;

public class Gameplay {
	public static int remainingShips = 5;
	int battleshipHP = 4;
	 int carrierHP = 5;
	 int cruiserHP = 4;
	 int subHP = 3;
	 int destroyerHP = 2;


	public String Translate(String message) {
		
		if (message.length()<3)
		{
			return message;
		}
		
		int x = 200;
		int y = 200;
		int x2 = 200, y2 = 200;
		char l, m, n;
		 
		
		l = message.charAt(0);
		m = message.charAt(1);
		n = message.charAt(2);
		
		if (message.length() ==5) {
			char a = message.charAt(2);
			char b = message.charAt(4);

			x = Character.getNumericValue(a);
			y = Character.getNumericValue(b);
			x2 = (x*30)+21;
			y2 = (y*30)+32;
		}
	

		/*
		 * Game Event Messages (G.E.M.)received when it is the enemy's turn and
		 * the game is active "@@x,y" //this is an attack coordinate A return
		 * message is sent with appropriate response to attack...
		 */
		
		if (l == '@' && m == '@') 
		{
				String pGridContents = Battleship.playerGrid.getGridContents(x, y);
				// hit battleship
				if (pGridContents == "B") {
					JLabel hitLabel = new JLabel();
					 JLabel missLabel = new JLabel();
					hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
							"hitLabel.jpg")));
					missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
							"missLabel.jpg")));
					
					battleshipHP --;
					
					// displays on playerGrid enemy shots
					hitLabel.setBounds(x2, y2, 28, 28);
					Battleship.playerPanel.add(hitLabel);
					Battleship.playerPanel.repaint();
					Battleship.playerPanel.revalidate();
					// checks for sunk ship and endGame condition
					if (battleshipHP == 0 && remainingShips != 0) {	
						Battleship.displayMessage("\nThey sank our Battleship!");
						return("^^000");
					}
					if (remainingShips == 0) {
						Battleship.displayMessage("\nThey Won!");
						Battleship.gameStarted=false;
						return(">>>>>");	
					} 
					 
					
					Battleship.displayMessage("\nThats a HIT!");
					Battleship.playerTurn = true;
					return("!!"+String.valueOf(x) + "," + String.valueOf(y));
					
				
				}
				// Hit Carrier
				else if (pGridContents == "C") {
					JLabel hitLabel = new JLabel();
					JLabel missLabel = new JLabel();
					hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
							"hitLabel.jpg")));
					missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
							"missLabel.jpg")));

					carrierHP--;
						
					// displays on playerGrid enemy shots
					hitLabel.setBounds(x2, y2, 28, 28);
					Battleship.playerPanel.add(hitLabel);
					Battleship.playerPanel.repaint();
					Battleship.playerPanel.revalidate();
	
					// checks for sunk ship and endGame condition
					if (carrierHP == 0 && remainingShips != 0) {	
						Battleship.displayMessage("\nThey sank our Carrier!");
						Battleship.playerTurn = true;
						return("^^111");
					}
					if (remainingShips == 0) {
						Battleship.displayMessage("\nThey Won!");
						Battleship.gameStarted=false;
						return(">>>>>");	
					} 
				
				
					Battleship.displayMessage("\nThats a HIT!");
					Battleship.playerTurn = true;
					return("!!"+String.valueOf(x) + "," + String.valueOf(y));
				
				}
				// Hit Cruiser
				else if (pGridContents == "Z") {
				JLabel hitLabel = new JLabel();
				 JLabel missLabel = new JLabel();
				hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
						"hitLabel.jpg")));
				missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
						"missLabel.jpg")));
					
					cruiserHP--;
					
					// displays on playerGrid enemy shots
					hitLabel.setBounds(x2, y2, 28, 28);
					Battleship.playerPanel.add(hitLabel);
					Battleship.playerPanel.repaint();
					Battleship.playerPanel.revalidate();
					// checks for sunk ship and endGame condition
					if (cruiserHP == 0 && remainingShips != 0) {	
						Battleship.displayMessage("\nThey sank our Cruiser!");
						Battleship.playerTurn = true;
						Battleship.playerTurn = true;
						return("^^222");
					}
					if (remainingShips == 0) {
						Battleship.displayMessage("\nThey Won!");
						Battleship.gameStarted=false;
						return(">>>>>");	
					} 
					
					Battleship.displayMessage("\nThats a HIT!");
					Battleship.playerTurn = true;
					return("!!"+String.valueOf(x) + "," + String.valueOf(y));
				}

				// Hit Submarine
				else if (pGridContents == "S") 
				{
					JLabel hitLabel = new JLabel();
					JLabel missLabel = new JLabel();
					hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
						"hitLabel.jpg")));
					missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
						"missLabel.jpg")));
					subHP--;
					
					// displays on playerGrid enemy shots
					hitLabel.setBounds(x2, y2, 28, 28);
					Battleship.playerPanel.add(hitLabel);
					Battleship.playerPanel.repaint();
					Battleship.playerPanel.revalidate();
					// checks for sunk ship and endGame condition
					if (subHP == 0 && remainingShips != 0) {	
						Battleship.displayMessage("\nThey sank our Submarine!");
						Battleship.playerTurn = true;
						return("^^333");
					}
					if (remainingShips == 0) {
						Battleship.displayMessage("\nThey Won!");
						Battleship.gameStarted=false;
						return(">>>>>");	
					} 
					
					Battleship.displayMessage("\nThats a HIT!");
					Battleship.playerTurn = true;
					return("!!"+String.valueOf(x) + "," + String.valueOf(y));
					
				}
			// Hit Destroyer
			else if (pGridContents == "D") 
			{
				JLabel hitLabel = new JLabel();
				 JLabel missLabel = new JLabel();
				hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
						"hitLabel.jpg")));
				missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
						"missLabel.jpg")));

					destroyerHP--;
					
					// displays on playerGrid enemy shots
					hitLabel.setBounds(x2, y2, 28, 28);
					Battleship.playerPanel.add(hitLabel);
					Battleship.playerPanel.repaint();
					Battleship.playerPanel.revalidate();
					// checks for sunk ship and endGame condition
					if (destroyerHP == 0 && remainingShips != 0) {	
						Battleship.displayMessage("\nThey sank our Destroyer!");
						Battleship.playerTurn = true;
						return("^^444");
					}
					if (remainingShips == 0) {
						Battleship.displayMessage("\nThey Won!");
						Battleship.gameStarted=false;
						return(">>>>>");	
					} 
					
					Battleship.displayMessage("\nThats a HIT!");
					Battleship.playerTurn = true;
				return("!!"+String.valueOf(x) + "," + String.valueOf(y));
					
				}
			// enemy missed
			else if (pGridContents == "~") 
			{
				JLabel hitLabel = new JLabel();
				JLabel missLabel = new JLabel();
				hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
						"hitLabel.jpg")));
				missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
						"missLabel.jpg")));
					// displays on playerGrid enemy shots
				Battleship.playerGrid.setGridContents(x, y, "M");
				missLabel.setBounds(x2, y2, 28, 28);
				Battleship.playerPanel.add(missLabel);
				Battleship.playerPanel.repaint();
				Battleship.playerPanel.revalidate();
					// returns message to enemy that they missed
				Battleship.displayMessage("\nThey Missed Us!");
				Battleship.playerTurn = true;
			return("??"+String.valueOf(x) + "," + String.valueOf(y));
					
			}
		Battleship.playerTurn = true;
		}
		
		
		/*Receiving a response after an attack message 
		 * During the players turn, valid messages received from the enemy
		 * are as follows: 
		 * "!!x,y" 	//hit 
		 * "??x,y 	//miss 
		 * "^^z" 	//sunk ship z corresponds to ship 0,1,2,3,4 where 0 = battleship, 1 = carrier,
		 * 				2 = cruiser, 3 = sub, 4 = destroyer 
		 * ">>>" 	//the player has sunk all 5 enemy ships and therefore won the game
		 */
		

		// Hit
		else if (l == '!' && m == '!') {
					JLabel hitLabel = new JLabel();
					JLabel missLabel = new JLabel();
					hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
							"hitLabel.jpg")));
					missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
							"missLabel.jpg")));

					Battleship.enemyGrid.setGridContents(x, y, "H");
					hitLabel.setBounds(x2, y2, 28, 28);
					Battleship.enemyPanel.add(hitLabel);
					Battleship.enemyPanel.repaint();
					Battleship.enemyPanel.revalidate();
					Battleship.displayMessage("\nYou got HIT!");
					
				return "-Your Turn-";
		} 
		// miss
		else if (l == '?' && m == '?') {
					JLabel hitLabel = new JLabel();
					JLabel missLabel = new JLabel();
					hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"hitLabel.jpg")));
					missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"missLabel.jpg")));
					
			System.out.println("GamePlay.java line 288 --- Message = \"" + message +"\",  X2 = "+ x2 + "  Y2 = " + y2 + ", x = " + x + ", y = "+ y);
					Battleship.enemyGrid.setGridContents(x, y, "M");
					
					missLabel.setBounds(x2, y2, 28, 28);
					Battleship.enemyPanel.add(missLabel);
					Battleship.enemyPanel.repaint();
					Battleship.enemyPanel.revalidate();
					Battleship.displayMessage("\nThey MISSED!");
				return "-Your Turn-";
				}
				// sunk
		else if (l == '^' && m == '^') {
			JLabel hitLabel = new JLabel();
			 JLabel missLabel = new JLabel();
			hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"hitLabel.jpg")));
			missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
					"missLabel.jpg")));
					// add code here to deduct the right ship from the enemy
					// remaining panel
					Battleship.enemyGrid.setGridContents(x, y, "H");
					hitLabel.setBounds(x2, y2, 28, 28);
					Battleship.enemyPanel.add(hitLabel);
					Battleship.enemyPanel.repaint();
					Battleship.enemyPanel.revalidate();
					Battleship.displayMessage("\nWe sank their ship!!!");
				return "-Your Turn-";
		}
		else if (l == '>' && m == '>'&& n == '>') {
			 JLabel hitLabel = new JLabel();
			 JLabel missLabel = new JLabel();
			 hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("hitLabel.jpg")));
			 missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("missLabel.jpg")));
					// add code here to deduct the right ship from the enemy
					// remaining panel
					Battleship.enemyGrid.setGridContents(x, y, "H");
					hitLabel.setBounds(x2, y2, 28, 28);
					Battleship.enemyPanel.add(hitLabel);
					Battleship.enemyPanel.repaint();
					Battleship.enemyPanel.revalidate();
					Battleship.gameStarted = false;
					Battleship.displayMessage("\nYOU WIN!!!!!!");
				Battleship.playerTurn = false;
				return "-Your Turn-";
				}

			

			//}
			/*
			 * If the game has not started then the only Game Event Message
			 * (G.E.M.) is whether the enemy is ready or not. "###" //Received
			 * ready message from enemy
			 */
			 if (l == '#' && m == '#' && n == '#') {
					System.out.println("Ready Message Received");
					Battleship.enemyReady = true;
					if (Battleship.playerReady == true) {
						Battleship.gameStarted = true;
					}
					Battleship.displayMessage( "\nOpponent is Ready!" );
				return "--";	
			}

		

		// if it is players turn, just display enemy message to console and do
		// nothing
		// with it. The enemy should not be able to send a GEM
		// since its not his turn
		
		if(Battleship.isServer){
			Battleship.displayMessage( "\nPLAYER 1>>> " + message ); // display message message;
			return "-Your Turn-";
		}
		else{
			Battleship.displayMessage( "\nPLAYER 2>>> " + message ); // display message message;
			return "-Your Turn-";
		}
		
	
	}
		
			


	// returns a string with the attack coordinates of players click on enemy
	// board
	public static String attack(Point pt) {
		int x = (int) pt.getX();
		int y = (int) pt.getY();

		// converts drop point to grid square
		int x2 = (x - 21) / 30;
		int y2 = (y - 32) / 30;

		// alters drop point to set ship in grid correctly
		x = (x2 * 30) + 21;
		y = (y2 * 30) + 32;

		if(Battleship.enemyGrid.getGridContents(x2, y2) != "~"){
			Battleship.displayMessage("\nYou already picked that square, try again");
			return "-Your Turn-";
		}
		if (Battleship.enemyGrid.getGridContents(x2, y2) == "~") {
			Battleship.enemyGrid.setGridContents(x2, y2, "T");
				return "@@" + String.valueOf(x2) + "," + String.valueOf(y2);
			} 
		else{
			return "Something went wrong in the attack() method of Gameplay.java";
		
		}
	}

}
//
