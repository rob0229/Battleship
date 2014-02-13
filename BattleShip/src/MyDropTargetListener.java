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
	    private Point gridPoint;
	    
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
	            
	            
	            //need to call a method here that determines the square the ship was dropped in so that the image file for the square
	            //can be updated with the appropriate image
	            System.out.println("Drop point is " + dropPoint);
     
	            //data that is transfered to new panel (ship image file)
	            Transferable tr = event.getTransferable();

	            //checks that the data being dragged is an imageFlavor
	            if (event.isDataFlavorSupported(DataFlavor.imageFlavor)) {
	                Icon ico = (Icon) tr.getTransferData(DataFlavor.imageFlavor);

	                if (ico != null) {
	                	
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
	     
	    }
   
	}