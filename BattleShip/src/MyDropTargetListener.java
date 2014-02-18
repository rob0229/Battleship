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

	private DropTarget dropTarget;
	private JPanel p;
	private static Point dropPoint;
	String draggedShip;
	
	public MyDropTargetListener(JPanel dropPanel) {

		p = dropPanel;
		dropTarget = new DropTarget(dropPanel, DnDConstants.ACTION_COPY, this,
				true, null);

	}

	@Override
	public void drop(DropTargetDropEvent event) {

		try {
			DropTarget shipDropped = (DropTarget) event.getSource();
			Component ca = (Component) shipDropped.getComponent();
			
			//gets the pixel point where the ship was dropped
			dropPoint = ca.getMousePosition();
			// data that is transfered to new panel (ship image file)
			Transferable tr = event.getTransferable();

			// checks that the data being dragged is an imageFlavor
			if (event.isDataFlavorSupported(DataFlavor.imageFlavor)) {
				//resets validDrop to evaluate each move independently
				GetSquareDropped.validDrop = true;
				Icon ico = (Icon) tr.getTransferData(DataFlavor.imageFlavor);
				//gets the ship being dragged, this is not a great way to do this, but it is functional for this project
				draggedShip = ico.toString();
				
				GetShipInfo getShipInfo = new GetShipInfo(draggedShip);
			
				if (ico != null) {
					//determines and corrects square ship is dropped on
					GetSquareDropped getSquareDropped = new GetSquareDropped(dropPoint, draggedShip);
					//If a drop is valid(determined in GetSquareDropped Class) adds image to player panel
					if(GetSquareDropped.validDrop){
						JLabel shipDragged = new JLabel(ico);
						shipDragged.setBounds(getSquareDropped.getX(), getSquareDropped.getY(),	getShipInfo.getShipLength(), getShipInfo.getShipWidth());
						p.add(shipDragged);				
						p.repaint();
						p.revalidate();
						event.dropComplete(true);
					
					}
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
