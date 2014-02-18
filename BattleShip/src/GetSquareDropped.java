import java.awt.Point;


public class GetSquareDropped {
	int x, y, x2, y2, minX, maxX, minY, maxY;
	String ship;
	int orient = 0;
	static Boolean validDrop = true;
	static Boolean bsPlaced= false;
	static Boolean carrierPlaced = false;
	static Boolean destroyerPlaced = false;
	static Boolean cruiserPlaced = false;
	static Boolean subPlaced = false;



	public GetSquareDropped(Point point, String draggedShip){
	 GetShipInfo getShipInfo = new GetShipInfo(draggedShip);
	 
	//resets valid drop for each call since it is static
			validDrop = true;
		x = (int) point.getX();
		y = (int) point.getY();
		minX = getShipInfo.getMinX();
		maxX = getShipInfo.getMaxX();
		minY = getShipInfo.getMinY();
		maxY = getShipInfo.getMaxY();
		ship = getShipInfo.getShip();
		orient = getShipInfo.getOrientation();//0 horizontal, 1 vertical
		
		
		
		//Keeps ship placement inside boarders of panel
		if (x>getShipInfo.getMaxX()){	
			x=maxX;	
		}
		if (x<minX){	
			x=minX;	
		}
		if(y>maxY){
			y=maxY;
		}
		if(y<minY){
			y=minY;
		}
		//converts drop point to grid square
		x2 = (x-21)/30;
		y2 = (y-32)/30;
		

		// alters drop point to set ship in grid correctly 
		x = (x2*30)+21;
		y = (y2*30)+32;
		

		
		
		//Prevents ships from being placed on top of each other
		if(getShipInfo.getShip().equals("Battleship") && orient == 0){
			
			for(int i =0; i<2; i++){
				if(Battleship.playerGrid.getGridContents(x2+i, y2) != "~"){
					validDrop = false; 
				}
			}
			
			if(validDrop){
				for(int i =0; i<4; i++){
					Battleship.playerGrid.setGridContents(x2+i, y2, "B");
				}
				bsPlaced = true;
				Battleship.battleshipImageLabel.setVisible(false);
			}
			else
				System.out.println("You cannot place the ship there");
		}
			
		if(getShipInfo.getShip().equals("Battleship") && orient == 1){
			
			for(int i =0; i<4; i++){
				if(Battleship.playerGrid.getGridContents(x2, y2+i) != "~"){
					validDrop = false; 
				}
				
			}
			if(validDrop){
				for(int i =0; i<4; i++){
					Battleship.playerGrid.setGridContents(x2, y2+i, "B");
				}
				bsPlaced = true;
				Battleship.battleshipImageLabel.setVisible(false);
			}
			else
				System.out.println("You cannot place the ship there");
		}
		
		if(getShipInfo.getShip().equals("Carrier") && orient == 0){
			
			for(int i =0; i<5; i++){
				if(Battleship.playerGrid.getGridContents(x2+i, y2) != "~"){
					validDrop = false; 
				}
			}
			if(validDrop){
				for(int i =0; i<5; i++){
					Battleship.playerGrid.setGridContents(x2+i, y2, "C");
				}
				carrierPlaced = true;
				Battleship.carrierImageLabel.setVisible(false);
			}
			else
				System.out.println("You cannot place the ship there");
		}
		
		if(getShipInfo.getShip().equals("Carrier") && orient == 1){
			
			for(int i =0; i<5; i++){
				if(Battleship.playerGrid.getGridContents(x2, y2+i) != "~"){
					validDrop = false; 
				}	
			}
			if(validDrop){
				for(int i =0; i<5; i++){
					Battleship.playerGrid.setGridContents(x2, y2+i, "C");
				}
				carrierPlaced = true;
				Battleship.carrierImageLabel.setVisible(false);
			}
			else
				System.out.println("You cannot place the ship there");
		}
		
		if(getShipInfo.getShip().equals("Cruiser") && orient == 0){
			
			for(int i =0; i<4; i++){
				if(Battleship.playerGrid.getGridContents(x2+i, y2) != "~"){
					validDrop = false; 
				}
			}
			if(validDrop){
				for(int i =0; i<4; i++){
					Battleship.playerGrid.setGridContents(x2+i, y2, "Z");
				}
				cruiserPlaced = true;
				Battleship.cruiserImageLabel.setVisible(false);
			}
			else
				System.out.println("You cannot place the ship there");
		}
		if(getShipInfo.getShip().equals("Cruiser") && orient == 1){
			
			for(int i =0; i<4; i++){
				if(Battleship.playerGrid.getGridContents(x2, y2+i) != "~"){
					validDrop = false; 
				}
				
			}
			if(validDrop){
				for(int i =0; i<4; i++){
					Battleship.playerGrid.setGridContents(x2, y2+i, "Z");
				}
				cruiserPlaced = true;
				Battleship.cruiserImageLabel.setVisible(false);
			}
			else
				System.out.println("You cannot place the ship there");
		}	
		if(getShipInfo.getShip().equals("Submarine") && orient == 0){
			
			for(int i =0; i<3; i++){
				if(Battleship.playerGrid.getGridContents(x2+i, y2) != "~"){
					validDrop = false; 
				}
			}
			if(validDrop){
				for(int i =0; i<3; i++){
					Battleship.playerGrid.setGridContents(x2+i, y2, "S");
				}
				subPlaced = true;
				Battleship.submarineImageLabel.setVisible(false);
			}
			else
				System.out.println("You cannot place the ship there");
		}	
		
		if(getShipInfo.getShip().equals("Submarine") && orient == 1){
			
			for(int i =0; i<3; i++){
				if(Battleship.playerGrid.getGridContents(x2, y2+i) != "~"){
					validDrop = false; 
				}
				
			}
			if(validDrop){
				for(int i =0; i<3; i++){
					Battleship.playerGrid.setGridContents(x2, y2+i, "S");
				}
				subPlaced = true;
				Battleship.submarineImageLabel.setVisible(false);
			}
			else
				System.out.println("You cannot place the ship there");
		}
		
		if(getShipInfo.getShip().equals("Destroyer") && orient == 0){
			
			for(int i =0; i<2; i++){
				if(Battleship.playerGrid.getGridContents(x2+i, y2) != "~"){
					validDrop = false; 
				}
			}
			
			if(validDrop){
				for(int i =0; i<2; i++){
					Battleship.playerGrid.setGridContents(x2+i, y2, "D");
				}
				destroyerPlaced = true;
				Battleship.destroyerImageLabel.setVisible(false);
			}
			else
				System.out.println("You cannot place the ship there");
		}	
		
		if(getShipInfo.getShip().equals("Destroyer") && orient == 1){
			
			for(int i =0; i<2; i++){
				if(Battleship.playerGrid.getGridContents(x2, y2+i) != "~"){
					validDrop = false; 
				}
				
			}
			if(validDrop){
				for(int i =0; i<2; i++){
					Battleship.playerGrid.setGridContents(x2, y2+i, "D");
				}
				destroyerPlaced = true;
				Battleship.destroyerImageLabel.setVisible(false);
			}
			else
				System.out.println("You cannot place the ship there");
	
		}	
			
		//write code to rotate ship image here with right click
		
		
		
		//write code to ensure ship is not overlapped here
		
		
		
		
		//write code to reposition ship on player board here
		
		//write code to enter ship into gridArray here
		
		
		//test code **************************************************************************
	
		point.setLocation(x, y);

		for(int i = 0; i < 10; i++)
		{
			System.out.println();
			for(int j = 0; j < 10; j++)
			{
				System.out.print(" " + Battleship.playerGrid.getGridContents(j,i) + " ");
			}
		}
		
	}
	
	
	public static Boolean allShipsPlaced(){
		if (bsPlaced && cruiserPlaced && carrierPlaced && subPlaced && destroyerPlaced)
			return true;	
		else
			return false;
	
	}

	public int getX(){		
		return x;
	}
	
	public int getY(){
		return y;		
	}
	
//
}
