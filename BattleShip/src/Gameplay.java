
public class Gameplay {
	public static int remainingShips;
	public boolean turn;
	public boolean playerready;
	public boolean enemyready;
	
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
		if(turn == false)
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
		
		return("blah");
		
	}
	
	//if(playerready = true && playerready == enemyready)
	
	
}
