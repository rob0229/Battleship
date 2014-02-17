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
		dropTarget = new DropTarget(dropPanel, DnDConstants.ACTION_MOVE, this,
				true, null);

	}

	@Override
	public void drop(DropTargetDropEvent event) {

		try {
			DropTarget shipDropped = (DropTarget) event.getSource();
			Component ca = (Component) shipDropped.getComponent();

			dropPoint = ca.getMousePosition();

			// data that is transfered to new panel (ship image file)
			Transferable tr = event.getTransferable();

			// checks that the data being dragged is an imageFlavor
			if (event.isDataFlavorSupported(DataFlavor.imageFlavor)) {
				Icon ico = (Icon) tr.getTransferData(DataFlavor.imageFlavor);
				draggedShip = ico.toString();
				GetShipInfo getShipInfo = new GetShipInfo(draggedShip);
				if (ico != null) {
					System.out.println("The draggedShip = "	+ draggedShip.toString());
					GetSquareDropped getSquareDropped = new GetSquareDropped(dropPoint, draggedShip);
					JLabel shipDragged = new JLabel(ico);
					shipDragged.setBounds(getSquareDropped.getX(), getSquareDropped.getY(),	getShipInfo.getShipLength(), getShipInfo.getShipWidth());
					p.add(shipDragged);
					p.repaint();
					p.revalidate();
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
