import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;



// private inner class for the squares on the board
   public class Square extends JPanel 
   {
      private String contents; // either unknown, hit, or miss... should display an image of the same...
      private int xCord;
      private int yCord;// location of square
      private boolean played; // square played or not
   
      public Square( String squareContents, int x, int y )
      {
    	  contents = squareContents; // set mark for this square
    	 
    	  xCord = x;// set location of this square 
    	  yCord = y;// set location of this square
    	  
    	  played = false;

         addMouseListener( 
            new MouseAdapter() 
            {
               public void mouseReleased( MouseEvent e )
               {
                  setCurrentSquare( Square.this ); // set current square

               } // end method mouseReleased

			private void sendClickedSquare(Object squareLocation) {
				// TODO Auto-generated method stub
				
			}

			private Object getSquareLocation() {
				Square curr = new Square(contents, xCord, yCord);
				return curr;
			}

			private void setCurrentSquare(Square square) {
				//Battleship.sendData("@@"+xCord + ","+yCord);
				System.out.println("The square x = " + xCord + " y = "+ yCord);
				
			}
            } // end anonymous inner class
         ); // end call to addMouseListener
         	      
      } // end Square constructor


      // return preferred size of Square
      public Dimension getPreferredSize() 
      { 
         return new Dimension( 31, 31 ); // return preferred size
      } // end method getPreferredSize

      // return minimum size of Square
      public Dimension getMinimumSize() 
      {
         return getPreferredSize(); // return preferred size
      } // end method getMinimumSize

      // draw Square
      public void paintComponent( Graphics g )
      {
         super.paintComponent( g );

         g.drawRect( 0, 0, 30, 30 ); // draw square
         g.drawString( contents, 11, 20 ); // draw mark   
      } // end method paintComponent
      
      public boolean getPlayed()
      {
    	  return played;
      }

   } // end inner-class Square
