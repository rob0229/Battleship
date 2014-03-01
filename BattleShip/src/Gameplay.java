import java.awt.Point;

import javax.swing.JLabel;

public class Gameplay {
	final Sounds sound = new Sounds();
	
	public static int remainingShips = 5;
	int battleshipHP = 4;
	int carrierHP = 5;
	int cruiserHP = 4;
	int subHP = 3;
	int destroyerHP = 2;
	char s;
	

	public String Translate(String message) {

		if (message.length() < 5) {
			return message;
		}

		int x = 200;
		int y = 200;
		int x2 = 200, y2 = 200;
		char l, m, n;

		l = message.charAt(0);
		m = message.charAt(1);
		n = message.charAt(2);
		// ship that is sunk, 0-4
		s = message.charAt(3);

		if (message.length() == 5) {
			char a = message.charAt(2);
			char b = message.charAt(4);

			x = Character.getNumericValue(a);
			y = Character.getNumericValue(b);
			x2 = (x * 30) + 21;
			y2 = (y * 30) + 32;
		}

		
		/*
		 * Game Event Messages (G.E.M.)received when it is the enemy's turn and
		 * the game is active "@@x,y" //this is an attack coordinate A return
		 * message is sent with appropriate response to attack...
		 */

		if (l == '@' && m == '@') {
			String pGridContents = Battleship.playerGrid.getGridContents(x, y);
			// hit battleship
			if (pGridContents == "B") {
				JLabel hitLabel = new JLabel();
				JLabel missLabel = new JLabel();
				hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.HITLABEL)));
				missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.MISSLABEL)));

				battleshipHP--;
				
				// displays on playerGrid enemy shots
				hitLabel.setBounds(x2, y2, 28, 28);
				Battleship.playerPanel.add(hitLabel, -1);
				Battleship.playerPanel.repaint();
				Battleship.playerPanel.revalidate();
				
				if(battleshipHP == 0){
					remainingShips--;
				}
				// checks for sunk ship and endGame condition
				if (battleshipHP == 0 && remainingShips != 0) {
					
					sound.run(5);
					Battleship.playerTurn = true;
					Battleship.yourTurnMessage.setVisible(true);
					Battleship.enemyTurnMessage.setVisible(false);
					return ("^^" + String.valueOf(x) + "0" + String.valueOf(y));
				}
				if (remainingShips == 0) {
					
					Battleship.displayMessage("\n !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					Battleship.displayMessage("\n !!!!!!!!!!!!!! You Lost !!!!!!!!!!!!!");
					Battleship.displayMessage("\n !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					Battleship.yourTurnMessage.setVisible(false);
					Battleship.enemyTurnMessage.setVisible(false);
					Battleship.youLoseMessage.setVisible(true);
					sound.run(4);
					Battleship.gameStarted = false;
					Battleship.playerTurn = false;
					return (">>"+ String.valueOf(x) + "," + String.valueOf(y));
				}

				else {
				
					sound.run(1);
					Battleship.playerTurn = true;
					Battleship.yourTurnMessage.setVisible(true);
					Battleship.enemyTurnMessage.setVisible(false);
					return ("!!" + String.valueOf(x) + "," + String.valueOf(y));
				}

			}
			// Hit Carrier
			else if (pGridContents == "C") {
				JLabel hitLabel = new JLabel();
				JLabel missLabel = new JLabel();
				hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.HITLABEL)));
				missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.MISSLABEL)));

				carrierHP--;

				// displays on playerGrid enemy shots
				hitLabel.setBounds(x2, y2, 28, 28);
				Battleship.playerPanel.add(hitLabel, -1);
				Battleship.playerPanel.repaint();
				Battleship.playerPanel.revalidate();
				
				if(carrierHP == 0){
					remainingShips--;
				}

				// checks for sunk ship and endGame condition
				if (carrierHP == 0 && remainingShips != 0) {
				
					sound.run(6);
					Battleship.playerTurn = true;
					Battleship.yourTurnMessage.setVisible(true);
					Battleship.enemyTurnMessage.setVisible(false);
					return ("^^" + String.valueOf(x) + "1" + String.valueOf(y));
				}
				if (remainingShips == 0) {
			
					sound.run(1);
					Battleship.displayMessage("\n !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					Battleship.displayMessage("\n !!!!!!!!!!!!!! You Lost !!!!!!!!!!!!!");
					Battleship.displayMessage("\n !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					Battleship.yourTurnMessage.setVisible(false);
					Battleship.enemyTurnMessage.setVisible(false);
					Battleship.youLoseMessage.setVisible(true);
					sound.run(4);
					Battleship.gameStarted = false;
					Battleship.playerTurn = false;
					return (">>"+ String.valueOf(x) + "," + String.valueOf(y));
				}

			
				sound.run(1);
				Battleship.playerTurn = true;
				Battleship.yourTurnMessage.setVisible(true);
				Battleship.enemyTurnMessage.setVisible(false);
				return ("!!" + String.valueOf(x) + "," + String.valueOf(y));

			}
			// Hit Cruiser
			else if (pGridContents == "Z") {
				JLabel hitLabel = new JLabel();
				JLabel missLabel = new JLabel();
				hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.HITLABEL)));
				missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.MISSLABEL)));

				cruiserHP--;

				// displays on playerGrid enemy shots
				hitLabel.setBounds(x2, y2, 28, 28);
				Battleship.playerPanel.add(hitLabel, -1);
				Battleship.playerPanel.repaint();
				Battleship.playerPanel.revalidate();
				
				if(cruiserHP == 0){
					remainingShips--;
				}
				// checks for sunk ship and endGame condition
				if (cruiserHP == 0 && remainingShips != 0) {
				
					sound.run(1);
					Battleship.playerTurn = true;
					Battleship.yourTurnMessage.setVisible(true);
					Battleship.enemyTurnMessage.setVisible(false);
					return ("^^" + String.valueOf(x) + "2" + String.valueOf(y));
				}
				if (remainingShips == 0) {
					
					sound.run(6);
					Battleship.displayMessage("\n !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					Battleship.displayMessage("\n !!!!!!!!!!!!!! You Lost !!!!!!!!!!!!!");
					Battleship.displayMessage("\n !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					Battleship.yourTurnMessage.setVisible(false);
					Battleship.enemyTurnMessage.setVisible(false);
					Battleship.youLoseMessage.setVisible(true);
					sound.run(4);
					Battleship.gameStarted = false;
					Battleship.playerTurn = false;
					return (">>"+ String.valueOf(x) + "," + String.valueOf(y));
				}

			
				sound.run(1);
				Battleship.playerTurn = true;
				Battleship.yourTurnMessage.setVisible(true);
				Battleship.enemyTurnMessage.setVisible(false);
				return ("!!" + String.valueOf(x) + "," + String.valueOf(y));
			}

			// Hit Submarine
			else if (pGridContents == "S") {
				JLabel hitLabel = new JLabel();
				JLabel missLabel = new JLabel();
				hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.HITLABEL)));
				missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.MISSLABEL)));
				subHP--;

				// displays on playerGrid enemy shots
				hitLabel.setBounds(x2, y2, 28, 28);
				Battleship.playerPanel.add(hitLabel, -1);
				Battleship.playerPanel.repaint();
				Battleship.playerPanel.revalidate();
				if(subHP == 0){
					remainingShips--;
				}
				// checks for sunk ship and endGame condition
				if (subHP == 0 && remainingShips != 0) {
					
					sound.run(6);
					Battleship.playerTurn = true;
					Battleship.yourTurnMessage.setVisible(true);
					Battleship.enemyTurnMessage.setVisible(false);
					return ("^^" + String.valueOf(x) + "3" + String.valueOf(y));
				}
				if (remainingShips == 0) {
					
					sound.run(1);
					Battleship.displayMessage("\n !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					Battleship.displayMessage("\n !!!!!!!!!!!!!! You Lost !!!!!!!!!!!!!");
					Battleship.displayMessage("\n !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					Battleship.yourTurnMessage.setVisible(false);
					Battleship.enemyTurnMessage.setVisible(false);
					Battleship.youLoseMessage.setVisible(true);
					sound.run(4);
					Battleship.gameStarted = false;
					Battleship.playerTurn = false;
					return (">>"+ String.valueOf(x) + "," + String.valueOf(y));
				}

				sound.run(1);
				Battleship.playerTurn = true;
				Battleship.yourTurnMessage.setVisible(true);
				Battleship.enemyTurnMessage.setVisible(false);
				return ("!!" + String.valueOf(x) + "," + String.valueOf(y));

			}
			// Hit Destroyer
			else if (pGridContents == "D") {
				JLabel hitLabel = new JLabel();
				JLabel missLabel = new JLabel();
				hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.HITLABEL)));
				missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.MISSLABEL)));

				destroyerHP--;

				// displays on playerGrid enemy shots
				hitLabel.setBounds(x2, y2, 28, 28);
				Battleship.playerPanel.add(hitLabel, -1);
				Battleship.playerPanel.repaint();
				Battleship.playerPanel.revalidate();
				
				if(destroyerHP == 0){
					remainingShips--;
				}
				// checks for sunk ship and endGame condition
				if (destroyerHP == 0 && remainingShips != 0) {
					sound.run(6);
					Battleship.playerTurn = true;
					Battleship.yourTurnMessage.setVisible(true);
					Battleship.enemyTurnMessage.setVisible(false);
					return ("^^" + String.valueOf(x) + "4" + String.valueOf(y));
				}
				if (remainingShips == 0) {
			
					Battleship.displayMessage("\n !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					Battleship.displayMessage("\n !!!!!!!!!!!!!! You Lost !!!!!!!!!!!!!");
					Battleship.displayMessage("\n !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					Battleship.yourTurnMessage.setVisible(false);
					Battleship.enemyTurnMessage.setVisible(false);
					Battleship.youLoseMessage.setVisible(true);
					sound.run(4);
					Battleship.gameStarted = false;
					Battleship.playerTurn = false;
					return (">>"+ String.valueOf(x) + "," + String.valueOf(y));
				}

			
				sound.run(1);
				Battleship.playerTurn = true;
				Battleship.yourTurnMessage.setVisible(true);
				Battleship.enemyTurnMessage.setVisible(false);
				return ("!!" + String.valueOf(x) + "," + String.valueOf(y));

			}
			// enemy missed
			else if (pGridContents == "~") {
				JLabel hitLabel = new JLabel();
				JLabel missLabel = new JLabel();
				hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.HITLABEL)));
				missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.MISSLABEL)));
				// displays on playerGrid enemy shots
				Battleship.playerGrid.setGridContents(x, y, "M");
				missLabel.setBounds(x2, y2, 28, 28);
				Battleship.playerPanel.add(missLabel, 0);
				Battleship.playerPanel.repaint();
				Battleship.playerPanel.revalidate();
				// returns message to enemy that they missed
			
				sound.run(0);
				Battleship.playerTurn = true;
				Battleship.yourTurnMessage.setVisible(true);
				Battleship.enemyTurnMessage.setVisible(false);
				return ("??" + String.valueOf(x) + "," + String.valueOf(y));

			}

		}

		/*
		 * Receiving a response after an attack message During the players turn,
		 * valid messages received from the enemy are as follows: "!!x,y" //hit
		 * "??x,y //miss "^^z" //sunk ship z corresponds to ship 0,1,2,3,4 where
		 * 0 = battleship, 1 = carrier, 2 = cruiser, 3 = sub, 4 = destroyer
		 * ">>>" //the player has sunk all 5 enemy ships and therefore won the
		 * game
		 */

		// Hit
		if (l == '!' && m == '!') {
			JLabel hitLabel = new JLabel();
			JLabel missLabel = new JLabel();
			hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.HITLABEL)));
			missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.MISSLABEL)));

			Battleship.enemyGrid.setGridContents(x, y, "H");
			hitLabel.setBounds(x2, y2, 28, 28);
			Battleship.enemyPanel.add(hitLabel, 0);
			Battleship.enemyPanel.repaint();
			Battleship.enemyPanel.revalidate();
		
			sound.run(1);
			Battleship.playerTurn = false;
			Battleship.yourTurnMessage.setVisible(false);
			Battleship.enemyTurnMessage.setVisible(true);
			return "\n-Your Turn-";
		}
		// miss
		else if (l == '?' && m == '?') {
			JLabel hitLabel = new JLabel();
			JLabel missLabel = new JLabel();
			hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.HITLABEL)));
			missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.MISSLABEL)));

			Battleship.enemyGrid.setGridContents(x, y, "M");

			missLabel.setBounds(x2, y2, 28, 28);
			Battleship.enemyPanel.add(missLabel, 0);
			Battleship.enemyPanel.repaint();
			Battleship.enemyPanel.revalidate();
		
			sound.run(0);
			Battleship.playerTurn = false;
			Battleship.yourTurnMessage.setVisible(false);
			Battleship.enemyTurnMessage.setVisible(true);
			return "\n-Your Turn-";
		}
		// sunk
		else if (l == '^' && m == '^') {
			JLabel hitLabel = new JLabel();
			JLabel missLabel = new JLabel();
			hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.HITLABEL)));
			missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.MISSLABEL)));
			
			// add code here to deduct the right ship from the enemy
			// remaining panel
			System.out.println("S (the ship sunk ) = "+ s);
			if(s == '0'){
				Battleship.enemyBattleshipLabel.setVisible(false);
			}
			else if(s == '1'){
				Battleship.enemyCarrierLabel.setVisible(false);
			}
			else if(s == '2'){
				Battleship.enemyCruiserLabel.setVisible(false);
			}
			else if(s == '3'){
			
				Battleship.enemySubmarineLabel.setVisible(false);
			}
			else if(s == '4'){
				
				Battleship.enemyDestroyerLabel.setVisible(false);
			}
			Battleship.enemyRemainingPanel.repaint();
			Battleship.enemyRemainingPanel.revalidate();
			
			Battleship.enemyGrid.setGridContents(x, y, "H");
			hitLabel.setBounds(x2, y2, 28, 28);
			Battleship.enemyPanel.add(hitLabel, 0);
			Battleship.enemyPanel.repaint();
			Battleship.enemyPanel.revalidate();
		
			sound.run(7);
			Battleship.playerTurn = false;
			Battleship.yourTurnMessage.setVisible(false);
			Battleship.enemyTurnMessage.setVisible(true);
			return "\n-Your Turn-";
			
		//All enemy ships sunk	
		} else if (l == '>' && m == '>' ) {
			JLabel hitLabel = new JLabel();
			JLabel missLabel = new JLabel();
			hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.HITLABEL)));
			missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(ConstantData.MISSLABEL)));
			// add code here to deduct the right ship from the enemy
			// remaining panel
			Battleship.enemyGrid.setGridContents(x, y, "H");
			hitLabel.setBounds(x2, y2, 28, 28);
			Battleship.enemyPanel.add(hitLabel, 0);
			Battleship.enemyPanel.repaint();
			Battleship.enemyPanel.revalidate();
			
			//ensures all enemyRemaining panel ships are gone ( the final sunk ship is never returned.)
			Battleship.enemyBattleshipLabel.setVisible(false);
			Battleship.enemyCarrierLabel.setVisible(false);
			Battleship.enemyCruiserLabel.setVisible(false);
			Battleship.enemySubmarineLabel.setVisible(false);
			Battleship.enemyDestroyerLabel.setVisible(false);
			Battleship.displayMessage("\n !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			Battleship.displayMessage("\n !!!!!!!!!!!!!! YOU WIN !!!!!!!!!!!!!!");
			Battleship.displayMessage("\n !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");		
			Battleship.yourTurnMessage.setVisible(false);
			Battleship.enemyTurnMessage.setVisible(false);
			Battleship.youWinMessage.setVisible(true);
			sound.run(3);
			Battleship.playerTurn = false;
			Battleship.gameStarted = false;
			return "\n\nGame Over";
		}

		// }
		/*
		 * If the game has not started then the only Game Event Message (G.E.M.)
		 * is whether the enemy is ready or not. "###" //Received ready message
		 * from enemy
		 */
		if (l == '#' && m == '#' && n == '#') {
		
			Battleship.enemyReady = true;
			if (Battleship.playerReady == true) {
				Battleship.gameStarted = true;
			}
			Battleship.displayMessage("\nOpponent is Ready!");
			
			return " Prepare For Combat!";
		}

		return "\nGameplay message translate did not catch that message";

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

		if (Battleship.enemyGrid.getGridContents(x2, y2) != "~") {
			Battleship.displayMessage("\nYou already picked that square, try again");
			return "*****";
		} else if (Battleship.enemyGrid.getGridContents(x2, y2) == "~") {
			Battleship.enemyGrid.setGridContents(x2, y2, "T");
			return "@@" + String.valueOf(x2) + "," + String.valueOf(y2);
		} else {
			return "\nSomething went wrong in the attack() method of Gameplay.java";

		}
	}

}
//
