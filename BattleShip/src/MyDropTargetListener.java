import java.awt.Component;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyDropTargetListener extends DropTargetAdapter {
	
		private int shipLength =100, shipWidth=20;
	    private DropTarget dropTarget;
	    private JPanel p;
	    private Point dropPoint;
	    String draggedShip;
	    Ship ship = new Ship();
	    Ship carrier = new Ship();
	    Ship battleship = new Ship();
	    Ship sub = new Ship();
	    Ship destroyer = new Ship();
	    Ship crusier = new Ship();
	    int maxX, maxY, minY;
   
	    public MyDropTargetListener(JPanel dropPanel) {
	        p = dropPanel;
	        dropTarget = new DropTarget(dropPanel, DnDConstants.ACTION_MOVE, this, true, null);
	        
	    }

	    @Override
	    public void drop(DropTargetDropEvent event) {
	    	
	        try {
	            DropTarget shipDropped = (DropTarget) event.getSource();
	            Component ca = (Component) shipDropped.getComponent();
	            dropPoint = ca.getMousePosition();
	            
	         
	            //data that is transfered to new panel (ship image file)
	            Transferable tr = event.getTransferable();

	            //checks that the data being dragged is an imageFlavor
	            if (event.isDataFlavorSupported(DataFlavor.imageFlavor)) {
	                Icon ico = (Icon) tr.getTransferData(DataFlavor.imageFlavor);
	                draggedShip = ico.toString();
	                System.out.println("Icon Object is " + ico.toString());
	                System.out.println("String is " + draggedShip);
	                if (ico != null) {
	                	
	                	getSquareDropped(dropPoint);
	                	JLabel shipDragged = new JLabel(ico);
	                	shipDragged.setBounds(dropPoint.x, dropPoint.y, shipLength, shipWidth);
	                    p.add(shipDragged);
	                    p.revalidate();
	                    p.repaint();
	                    event.dropComplete(true);
	                     
	                    
	                    
	                }
	            } else {
	                event.rejectDrop();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            event.rejectDrop();
	        }
	        //TEST CODE*******************************************************************************************************************************
	        System.out.println("Drop point is " + dropPoint);
          
	        
	       
	        
	        
	        
	    }
	    
	    
	    private void getShip(){
	    	//determines panel boundry for specific ships
	    	 if( draggedShip == "file:/P:/git/Battleship/BattleShip/bin/carrier.jpg"){
		        	maxX =260;
		        	maxY =290;
		        	minY = 20;

		        }
	    	
	    }
	    
	    
	    
	    private void getSquareDropped(Point point){
			Point grid;
			int x,x2,y2, y;
			
			x = (int) point.getX();
			y = (int) point.getY();
			
			
			
			if (x>maxX){	
				x=maxX;	
			}
			if(y>maxY){
				y=maxY;
			}
			if(y<minY){
				y=minY;
			}
			
			
			x2 = x/30;
			y2 = y/30;
			point.setLocation(x, y);
			 grid = new Point(x2,y2);
			 System.out.println("Grid is "+ grid);
			 
			
		}
   
	}