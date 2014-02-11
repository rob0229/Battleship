package testFiles;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.IOException;
import java.net.URL;
import java.awt.Container;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.TransferHandler.TransferSupport;
import javax.swing.border.TitledBorder;

public class DragImageFromPanels extends JFrame {
	
	//public Container container;
	
	
    public static void main(String[] args) {
        createAndShowJFrame();
    }

    public static void createAndShowJFrame() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                JFrame frame = createJFrame();
                frame.setVisible(true);

            }
        });
    }

    private static JFrame createJFrame() {
    	
    
    	//container = getContentPane();
    	
    	//creates master JFrame to hold panels
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        frame.setTitle("Battleship test");

        //create menuPanel and interface
        JPanel menuPanel = createEmptyJPanel("Information and Control Button Area", 400, 800);
        frame.add(menuPanel, BorderLayout.WEST);
        
        JPanel panelx = new JPanel();
        JPanel panely = new JPanel();
        JPanel panelz = new JPanel();
        
        panelx.setSize(50, 50);
        panely.setSize(50, 50);
        panelz.setSize(50, 50);
        
        menuPanel.add(panelx);
        menuPanel.add(panely, "wrap");
        menuPanel.add(panelz);
        
        
        //create panel for player interface
        JPanel panel1 = createEmptyJPanel("Game Board Area", 400, 400);
        frame.add(panel1, BorderLayout.CENTER);
        frame.setBackground(Color.red);
        JPanel enemyPanel = createEmptyJPanel("Enemy", 400, 200);
      //  enemyPanel.setBackground(Color.red);
        frame.add(panel1, BorderLayout.NORTH);
        
        JPanel playerPanel = createEmptyJPanel("Player", 400, 200);
        frame.add(panel1, BorderLayout.CENTER);
       // playerPanel.setBackground(Color.blue);
        
        
        panel1.add(enemyPanel);
        panel1.add(playerPanel);
        //container.setLayout(null);
       // create board to drop ships in
       // JPanel panel2 = createEmptyJPanel("Player", 400, 800);
        
        
       new MyDropTargetListener(panel1);//this must be done or we wont be able to drop any image onto the empty panel
       panel1.add(playerPanel, BorderLayout.CENTER);

        try {
            panel1.add(createJLabelPanel(), BorderLayout.SOUTH);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        frame.setSize(1250, 1000);

        return frame;
    }
    
//Creates  J Panels 
    private static JPanel createEmptyJPanel( String title, final int width, final int height) {
        final JPanel p = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(width, height);
            }
        };
        p.setBorder(new TitledBorder(title));

        TransferHandler dnd = new TransferHandler() {
            @Override
            public boolean canImport(TransferSupport support) {
                if (!support.isDrop()) {
                    return false;
                }
                //only Strings
                if (!support.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean importData(TransferSupport support) {
                if (!canImport(support)) {
                    return false;
                }

                Transferable transferable = support.getTransferable();
                Icon ico;
                try {
                    ico = (Icon) transferable.getTransferData(DataFlavor.imageFlavor);
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
                p.add(new JLabel(ico));
                return true;
            }
        };

        p.setTransferHandler(dnd);

        return p;
    }

    private static JPanel createJLabelPanel() throws Exception {
    	
    	 final JPanel shipPanel = new JPanel() {
             @Override
             public Dimension getPreferredSize() {
                 return new Dimension(400, 100);
             }
         };
    	
    	
    	int imageWidth = 120;
    	int imageHeight = 60;
    	String bsImageFile = "Battleship.jpg";
    	
    	
    	Image bsImage = Toolkit.getDefaultToolkit().getImage(DragImage.class.getResource(bsImageFile));
        bsImage = bsImage.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
    
    	
        shipPanel.setBorder(new TitledBorder("Drag Ship from here to Panel above"));
        
        
        //sets the image to use for ships
        JLabel battleshipImage = new JLabel(new ImageIcon(bsImage));
        JLabel label2 = new JLabel(new ImageIcon(new URL("http://i.stack.imgur.com/8BGfi.png")));
        JLabel label3 = new JLabel(new ImageIcon(new URL("http://i.stack.imgur.com/1lgtq.png")));

        MyDragGestureListener dlistener = new MyDragGestureListener();
        DragSource ds1 = new DragSource();
        ds1.createDefaultDragGestureRecognizer(battleshipImage, DnDConstants.ACTION_COPY, dlistener);

        DragSource ds2 = new DragSource();
        ds2.createDefaultDragGestureRecognizer(label2, DnDConstants.ACTION_COPY, dlistener);

        DragSource ds3 = new DragSource();
        ds3.createDefaultDragGestureRecognizer(label3, DnDConstants.ACTION_COPY, dlistener);

        shipPanel.add(battleshipImage);
        shipPanel.add(label2);
        shipPanel.add(label3);
        return shipPanel;
    }
}

class MyDropTargetListener extends DropTargetAdapter {

    private DropTarget dropTarget;
    private JPanel p;

    public MyDropTargetListener(JPanel panel) {
        p = panel;
        dropTarget = new DropTarget(panel, DnDConstants.ACTION_COPY, this, true, null);

    }

    @Override
    public void drop(DropTargetDropEvent event) {
        try {
            DropTarget test = (DropTarget) event.getSource();
            Component ca = (Component) test.getComponent();
            Point dropPoint = ca.getMousePosition();
            Transferable tr = event.getTransferable();

            if (event.isDataFlavorSupported(DataFlavor.imageFlavor)) {
                Icon ico = (Icon) tr.getTransferData(DataFlavor.imageFlavor);

                if (ico != null) {

                    p.add(new JLabel(ico));
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

class MyDragGestureListener implements DragGestureListener {

    @Override
    public void dragGestureRecognized(DragGestureEvent event) {
        JLabel label = (JLabel) event.getComponent();
        final Icon ico = label.getIcon();


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

            @Override
            public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
                return ico;
            }
        };
        event.startDrag(null, transferable);
    }
}