import java.awt.Point;


public class Gameplay {
	public static int remainingShips;
	public boolean turn;
	
	
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
		if(turn == false && Battleship.gameStart == true)
		{
			if(message.charAt(0) == '@' && message.charAt(0) == message.charAt(1))
			{
				//int x = Integer.valueOf(Character.toString(message.charAt(3)));
				//int y = Integer.valueOf(Character.toString(message.charAt(5)));
			
				int x = Integer.valueOf(message.charAt(3));
				int y = Integer.valueOf(message.charAt(5));
				
				String s = Battleship.playerGrid.getGridContents(x,y);
				if(s == "B")
				{
					battleship.setHP(battleship.getHP() - 1);
					if(battleship.getHP() == 0)
					{
						if(remainingShips == 0)
						{
							return("You win"); // edit
						}
						else
							return("^^,0");
					}
					else
						return("Hit!");
				}
						
			}
			else if(message.charAt(0) == '!' && message.charAt(0) == message.charAt(1))
			{
				// Hit
				
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
		}
		//if it is players turn, just display message to console and do nothing with it. The enemy should not be able to send an event message 
		//since its not his turn
		if(turn == true)
			return(message);
		
		//default case just returns the message for display to screen
		else 
			return(message);		
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
			
			
			
		
		return "";
	}
	
	
	
}
