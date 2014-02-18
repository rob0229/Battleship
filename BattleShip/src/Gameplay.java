import java.awt.Point;

import javax.swing.JLabel;

public class Gameplay {
	public static int remainingShips;
	public static boolean playerTurn;
	static JLabel hitLabel = new JLabel();
	static JLabel missLabel = new JLabel();

	Ship battleship;
	Ship carrier;
	Ship cruiser;
	Ship sub;
	Ship destroyer;

	public Gameplay() {
		battleship = new Ship(4);
		carrier = new Ship(5);
		cruiser = new Ship(4);
		sub = new Ship(3);
		destroyer = new Ship(2);
		remainingShips = 5;

	}

	public String Translate(String message) {
		int x = 0;
		int y = 0;
		hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"hitLabel.jpg")));
		missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"missLabel.jpg")));
		if(message.length() > 3){
			char a = message.charAt(2);
			char b = message.charAt(4);
	
			 x = Character.getNumericValue(a);
			 y = Character.getNumericValue(b);
		}
		String result = "default";
		
		

		/*
		 * Game Event Messages (G.E.M.)received when it is the enemy's turn and the game is active
		 * "@@x,y" //this is an attack coordinate 
		 * A return message is sent with appropriate response to attack...
		*/		
		if (playerTurn == false && Battleship.gameStarted == true) 
		{
			if (message.charAt(0) == '@' && message.charAt(1) == '@') {
				String s = Battleship.playerGrid.getGridContents(x, y);
				// hit battleship
				if (s == "B") {
					System.out.println("Hit battleship x = " + x + " y = " + y);
					battleship.setHP(battleship.getHP() - 1);
					System.out.println("BS Hit points = " + battleship.getHP());
					//displays on playerGrid enemy shots
					hitLabel.setBounds(x, y, 28, 28);
					Battleship.playerPanel.add(hitLabel);
					Battleship.playerPanel.repaint();
					Battleship.playerPanel.revalidate();
					//checks endGame condition
					if (battleship.getHP() == 0) {
						System.out.println("You sank my battleship");
						if (remainingShips == 0) {
							System.out.println("You Won!");
							result = ">>>"; // edit
						} else {
							System.out.println("return message = ^^0");
							result =("^^0");
						}
					} 
					else {
						System.out.println("Return Message is a hit");
						result = ("!!" + String.valueOf(x) + "," + String
								.valueOf(y));
					}
				}
				// Hit Carrier
				else if (s == "C") {
					System.out.println("Hit Carrier x = " + x + " y = " + y);

					carrier.setHP(carrier.getHP() - 1);
					System.out.println("Carrier Hit points = "
							+ carrier.getHP());
					//displays on playerGrid enemy shots
					hitLabel.setBounds(x, y, 28, 28);
					Battleship.playerPanel.add(hitLabel);
					Battleship.playerPanel.repaint();
					Battleship.playerPanel.revalidate();
					//checks endGame condition
					if (carrier.getHP() == 0) {
						System.out.println("You sank my carrier");
						if (remainingShips == 0) {
							System.out.println("You Won!");
							result = (">>>"); // edit
						} 
						else {
							System.out.println("return message = ^^0");
							result = ("^^1");
						}
					} 
					else {
						System.out.println("Return Message is a hit");
						return ("!!" + String.valueOf(x) + "," + String
								.valueOf(y));
					}
				}
				// Hit Cruiser
				else if (s == "Z") {
					System.out.println("Hit Cruiser x = " + x + " y = " + y);

					cruiser.setHP(cruiser.getHP() - 1);
					System.out.println("Cruiser Hit points = "
							+ carrier.getHP());
					//displays on playerGrid enemy shots
					hitLabel.setBounds(x, y, 28, 28);
					Battleship.playerPanel.add(hitLabel);
					Battleship.playerPanel.repaint();
					Battleship.playerPanel.revalidate();
					//checks endGame condition
					if (cruiser.getHP() == 0) {
						System.out.println("You sank my cruiser");
						if (remainingShips == 0) {
							System.out.println("You Won!");
							result = (">>>>"); // edit
						} else {
							System.out.println("return message = ^^0");
							result = ("^^2");
						}
					} else {
						System.out.println("Return Message is a hit");
						result = ("!!" + String.valueOf(x) + "," + String
								.valueOf(y));
					}
				}

				// Hit Submarine
				else if (s == "S") {
					System.out.println("Hit Submarine x = " + x + " y = " + y);

					sub.setHP(sub.getHP() - 1);
					System.out.println("Submarine Hit points = "
							+ carrier.getHP());
					//displays on playerGrid enemy shots
					hitLabel.setBounds(x, y, 28, 28);
					Battleship.playerPanel.add(hitLabel);
					Battleship.playerPanel.repaint();
					Battleship.playerPanel.revalidate();
					//checks endGame condition
					if (sub.getHP() == 0) {
						System.out.println("You sank my Submarine");
						if (remainingShips == 0) {
							System.out.println("You Won!");
							result = (">>>"); // edit
						} else {
							System.out.println("return message = ^^0");
							result = ("^^3");
						}
					} else {
						System.out.println("Return Message is a hit");
						result = ("!!" + String.valueOf(x) + "," + String
								.valueOf(y));
					}
				}
				// Hit Destroyer
				else if (s == "D") {
					System.out.println("Hit Destroyer x = " + x + " y = " + y);

					destroyer.setHP(destroyer.getHP() - 1);
					System.out.println("Destroyer Hit points = "
							+ carrier.getHP());
					//displays on playerGrid enemy shots
					hitLabel.setBounds(x, y, 28, 28);
					Battleship.playerPanel.add(hitLabel);
					Battleship.playerPanel.repaint();
					Battleship.playerPanel.revalidate();
					//checks endGame condition
					if (destroyer.getHP() == 0) {
						System.out.println("You sank my Destroyer");
						if (remainingShips == 0) {
							System.out.println("You Won!");
							result =(">>>"); // edit
						} else {
							System.out.println("return message = ^^0");
							result = ("^^4");
						}
					} else {
						System.out.println("Return Message is a hit");
						result = ("!!" + String.valueOf(x) + "," + String
								.valueOf(y));
					}

				} 
				//enemy missed
				else if (s == "~") {
					//displays on playerGrid enemy shots
					Battleship.playerGrid.setGridContents(x, y, "M");
					Battleship.playerPanel.setBounds(x, y, 28, 28);
					Battleship.playerPanel.add(missLabel);
					Battleship.playerPanel.repaint();
					Battleship.playerPanel.revalidate();
					//returns message to enemy that they missed
					result =("??"+x+","+y);
				}
				playerTurn = true;
			} 
			
			/*
			 * During the players turn, valid messages received from the enemy are as follows:
			 * 	"!!x,y" 	//hit
			 * 	"??x,y 		//miss
			 * 	"^^z" 		//sunk ship z corresponds to ship 0,1,2,3,4 where 0 = battleship, 1 = carrier, 2 = cruiser, 3 = sub, 4 = destroyer
			 * 	">>>" 		//the player has sunk all 5 enemy ships and therefore won the game
			 * 
			 */
			else if (playerTurn = true && Battleship.gameStarted == true){
				
				// Hit
				if ((message.charAt(0) == '!' && message.charAt(1) == '!')) {

					Battleship.enemyGrid.setGridContents(x, y, "H");
					Battleship.enemyPanel.setBounds(x, y, 28, 28);
					Battleship.enemyPanel.add(hitLabel);
					Battleship.enemyPanel.repaint();
					Battleship.enemyPanel.revalidate();
					

				} 
				else if (message.charAt(0) == '?'&& message.charAt(1) == '?') {
					//miss
					Battleship.enemyGrid.setGridContents(x, y, "H");
					Battleship.enemyPanel.setBounds(x, y, 28, 28);
					Battleship.enemyPanel.add(missLabel);
					Battleship.enemyPanel.repaint();
					Battleship.enemyPanel.revalidate();

				} 
				// sunk
				else if (message.charAt(0) == '^' && message.charAt(1) == '^') {
					//add code here to deduct the right ship from the enemy remaining panel
					Battleship.enemyGrid.setGridContents(x, y, "H");
					Battleship.enemyPanel.setBounds(x, y, 28, 28);
					Battleship.enemyPanel.add(hitLabel);
					Battleship.enemyPanel.repaint();
					Battleship.enemyPanel.revalidate();

				} 
				else if (message.charAt(0) == '>' && message.charAt(1) == '>' && message.charAt(2) == '>') {
					//add code here to deduct the right ship from the enemy remaining panel
					Battleship.enemyGrid.setGridContents(x, y, "H");
					Battleship.enemyPanel.setBounds(x, y, 28, 28);
					Battleship.enemyPanel.add(hitLabel);
					Battleship.enemyPanel.repaint();
					Battleship.enemyPanel.revalidate();
					Battleship.gameStarted = false;
					Battleship.displayMessage("YOU WIN!!!!!!");
					

				} 
				
				playerTurn = false;
				
			}
			/*
			 * If the game has not started then the only Game Event Message (G.E.M.) is whether the enemy is ready or not. 
			 * "###" //Received ready message from enemy
			 * 
			 */
			else if(Battleship.gameStarted == false){
				if(message.charAt(0) == '#' && message.charAt(1) =='#' && message.charAt(2)== '#')
				{		
					System.out.println("Ready Message Received");
					Battleship.enemyReady = true;
					if(Battleship.playerReady==true){
						Battleship.gameStarted = true;
					}
				}
				
			else 
				result = message;
				
					
			}	
			
		}

		// if it is players turn, just display enemy message to console and do nothing
		// with it. The enemy should not be able to send an event message
		// since its not his turn
		else if (playerTurn == true && Battleship.gameStarted == true) {
			
			result = message;
		}
		
		// default case just returns the initialized result string of "default"
		
	return result;
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

		if (Battleship.enemyGrid.getGridContents(x2, y2) == "~") {
			return "@@" + String.valueOf(x2) + "," + String.valueOf(y2);
		} else {
			System.out.println("you already picked that square, try again");
			return "Something went wrong in the attack function";
		}
	}

}
//
