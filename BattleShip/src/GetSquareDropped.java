import java.awt.Point;


public class GetSquareDropped {
int x, y, x2, y2, minX, maxX, minY, maxY;
String ship;
int orient = 0;

	public GetSquareDropped(Point point, String draggedShip){
	 GetShipInfo getShipInfo = new GetShipInfo(draggedShip);

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
		

		
		//write code to prevent multiple placement of each ship here
		if(getShipInfo.getShip().equals("Battleship") && orient == 0){

			for(int i =0; i<4; i++){
				Battleship.playerGrid.setGridContents(x2+i, y2, "B");
			}
		}
			
		if(getShipInfo.getShip().equals("Battleship") && orient == 1){

			for(int i =0; i<4; i++){
				Battleship.playerGrid.setGridContents(x2, y2+i, "B");
			}
		}
		
			
		if(getShipInfo.getShip().equals("Carrier") && orient == 0){

			for(int i =0; i<5; i++){
				Battleship.playerGrid.setGridContents(x2+i, y2, "C");
			}
		}
			
		if(getShipInfo.getShip().equals("Carrier") && orient == 1){

			for(int i =0; i<5; i++){
				Battleship.playerGrid.setGridContents(x2, y2+i, "C");
			}
		}
			
		if(getShipInfo.getShip().equals("Cruiser") && orient == 0){

			for(int i =0; i<4; i++){
				Battleship.playerGrid.setGridContents(x2+i, y2, "Z");
			}
		}
			
		if(getShipInfo.getShip().equals("Cruiser") && orient == 1){

			for(int i =0; i<4; i++){
				Battleship.playerGrid.setGridContents(x2, y2+i, "Z");
			}
		}
			
		if(getShipInfo.getShip().equals("Submarine") && orient == 0){

			for(int i =0; i<3; i++){
				Battleship.playerGrid.setGridContents(x2+i, y2, "S");
			}
		}
			
		if(getShipInfo.getShip().equals("Submarine") && orient == 1){

			for(int i =0; i<3; i++){
				Battleship.playerGrid.setGridContents(x2, y2+i, "S");
			}
		}
		
		if(getShipInfo.getShip().equals("Destroyer") && orient == 0){

			for(int i =0; i<2; i++){
				Battleship.playerGrid.setGridContents(x2+i, y2, "D");
			}
		}
			
		if(getShipInfo.getShip().equals("Destroyer") && orient == 1){

			for(int i =0; i<2; i++){
				Battleship.playerGrid.setGridContents(x2, y2+i, "D");
			}
		}	
			
		//write code to rotate ship image here with right click
		
		//write code to ensure ship is not overlapped here
		
		//write code to reposition ship on player board here
		
		//write code to enter ship into gridArray here
		
		
		//test code **************************************************************************
	
		point.setLocation(x, y);
		
		System.out.println(x2 + " " + y2);
		
		for(int i = 0; i < 10; i++)
		{
			System.out.println();
			for(int j = 0; j < 10; j++)
			{
				System.out.print(" " + Battleship.playerGrid.getGridContents(j,i) + " ");
			}
		}
	}
	
	
	
	
	
	
	
	
	
	public int getX(){
		
		return x;
	}
	public int getY(){
		return y;
		
	}
	

}
