

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.JLabel;

class MyDragGestureListener implements DragGestureListener {

    @Override
    public void dragGestureRecognized(DragGestureEvent event) {
        JLabel shipGrabbed = (JLabel) event.getComponent();
     
        final Icon ico = shipGrabbed.getIcon();
        System.out.println("MyDragGestureListener line 20 ico.toString() = " + ico.toString());
			//if(ico.toString().equals( "file:/C:/Users/Rob/git/Battleship/BattleShip/bin/Battleship.png")){
				shipGrabbed.setVisible(false);		
			//}

        Transferable transferable = new Transferable() {
            @Override
            public DataFlavor[] getTransferDataFlavors() {
                return new DataFlavor[]{DataFlavor.imageFlavor};
            }

            @Override
            public boolean isDataFlavorSupported(DataFlavor flavor) {
                if (!isDataFlavorSupported(flavor)) {
                    return false;
                }
                return true;
            }

           // @Override
            public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
            	
                return ico;
            }
        };
        event.startDrag(null, transferable);
    }
}