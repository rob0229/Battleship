/**
 Listens to when drag starts
 Copyright: Rob Close and Charlie Sun
 Created on: 03/01/2014
 */

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;


import java.awt.dnd.DragGestureRecognizer;

import java.io.IOException;

import javax.swing.Icon;
import javax.swing.JLabel;

class MyDragGestureListener implements DragGestureListener {

    @Override
    public void dragGestureRecognized(DragGestureEvent event) {
    	
    	JLabel shipGrabbed = (JLabel) event.getComponent();
     
        final Icon ico = shipGrabbed.getIcon();
   
			
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
