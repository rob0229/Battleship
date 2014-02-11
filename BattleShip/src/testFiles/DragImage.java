package testFiles;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.RepaintManager;

public class DragImage extends JComponent implements MouseMotionListener {
  static int imageWidth = 120, imageHeight = 60;
  int imageX, imageY;

  Image image;

  public DragImage(Image i) {
    image = i;
    addMouseMotionListener(this);
  }

  public void mouseDragged(MouseEvent e) {
    imageX = e.getX();
    imageY = e.getY();
    repaint();
  }

  public void mouseMoved(MouseEvent e) {
  }

  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    g2.drawImage(image, imageX, imageY, this);
  }

  public static void main(String[] args) {
    String imageFile = "Battleship.jpg";
    // Turn off double buffering
    RepaintManager.currentManager(null).setDoubleBufferingEnabled(false);

    Image image = Toolkit.getDefaultToolkit().getImage(DragImage.class.getResource(imageFile));
    image = image.getScaledInstance(imageWidth, imageHeight, Image.SCALE_DEFAULT);
    JFrame frame = new JFrame("DragImage");
   
    frame.setLocationRelativeTo(null);
    frame.getContentPane().add(new DragImage(image));
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  //Ask for window decorations provided by the look and feel.
    JFrame.setDefaultLookAndFeelDecorated(true);

    //Create the frame.
    JFrame toframe = new JFrame("A window");

    //Set the frame icon to an image loaded from a file.
    
    java.net.URL imgURL = DragImage.class.getResource("Battleship.jpg");
    toframe.setIconImage(new ImageIcon(imgURL).getImage());
    
    
    toframe.getContentPane().add(new DragImage(image));
    toframe.setSize(300, 300);
    toframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    toframe.setVisible(true);
  }
}