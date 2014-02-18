import java.awt.Point;

import javax.swing.JLabel;


public class Gameplay {
	public static int remainingShips;
	public static  boolean turn;
	static JLabel hitLabel = new JLabel();
	static JLabel missLabel = new JLabel();
	
	 Ship battleship;
	 Ship carrier;
	 Ship crusier;
	 Ship sub;
	 Ship destroyer;
	
	public Gameplay()
	{
		battleship = new Ship(4);
		carrier = new Ship(5);
		crusier = new Ship(4);
		sub = new Ship(3);
		destroyer = new Ship(2);
		
		remainingShips = 5;
		
		
	}
	
	public String Translate(String message)
	{
		hitLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("hitLabel.jpg")));
		missLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("missLabel.jpg")));
		char a = message.charAt(2);
		char b = message.charAt(4);

		int x = Character.getNumericValue(a);
		int y = Character.getNumericValue(b);
		
		
		//if(turn == false && Battleship.gameStart == true)
		if(true)
		{
				if(message.charAt(0) == '@' &&  message.charAt(1) == '@')
				{

					
					String s = Battleship.playerGrid.getGridContents(x,y);
					if(s == "B")
					{
						System.out.println("Hit battleship x = " + x + " y = " + y);
						battleship.setHP(battleship.getHP() - 1);
						if(battleship.getHP() == 0)
						{
							if(remainingShips == 0)
							{
								return("You win"); // edit
							}
							else
								return("^^0");
						}
						else
							return("!!"+ String.valueOf(x)+","+ String.valueOf(y));
					}
					else if (s == "~"){
						Battleship.playerGrid.setGridContents(x,y,"M");
						Battleship.playerPanel.setBounds(x,y,28, 28);
						Battleship.playerPanel.add(missLabel);				
						Battleship.playerPanel.repaint();
						Battleship.playerPanel.revalidate();
						
					}
				return null;
					
				}
				else if(message.charAt(0) == '!' && message.charAt(1) == '!')
				{
					// Hit
					
					Battleship.enemyGrid.setGridContents(Integer.valueOf(message.charAt(3)), Integer.valueOf(message.charAt(5)), "H");
					Battleship.enemyPanel.setBounds(Integer.valueOf(message.charAt(5)), Integer.valueOf(message.charAt(5)),	28, 28);
					Battleship.enemyPanel.add(hitLabel);				
					Battleship.enemyPanel.repaint();
					Battleship.enemyPanel.revalidate();
					
				}
				else if(message.charAt(0) == '?' && message.charAt(0) == message.charAt(1))
				{
					//
					
				}
				else if(message.charAt(0) == '#' && message.charAt(0) == message.charAt(1))
				{
					// ready
				}
				else if(message.charAt(0) == '^' && message.charAt(0) == message.charAt(1))
				{
					// sunk
					
					
				}
				else 
					return message;
		}
		
		//if it is players turn, just display message to console and do nothing with it. The enemy should not be able to send an event message 
		//since its not his turn
		else if(turn == true){
			System.out.println("turn is true line 96 Gameplay");
			return(message);
		}
		//default case just returns the message for display in message area
		
		else{	
			System.out.println("default return line 101 Gameplay.java");
			return(message);	
		}
		//return "error in gamePlay";
		return "default return, should never get here";
	}
	

	//returns a string with the attack coordinates of players click on enemy board
	public static String attack(Point pt){
		
			int x = (int) pt.getX();
			int y = (int) pt.getY();
			
			
			//converts drop point to grid square
			int x2 = (x-21)/30;
			int y2 = (y-32)/30;
		
			// alters drop point to set ship in grid correctly 
			x = (x2*30)+21;
			y = (y2*30)+32;
			
			
			if(Battleship.enemyGrid.getGridContents(x2, y2) == "~"){
				return "@@" + String.valueOf(x2)+","+ String.valueOf(y2);
			}
			else {
				System.out.println("you already picked that square, try again");
				return "Something went wrong in the attack function";
			}
	}
	
	
	
}
