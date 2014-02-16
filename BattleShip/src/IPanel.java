import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IPanel {

private int x=0, y=0;
private JFrame mainFrame;
private ImageIcon starIcon = new ImageIcon("oceanGrid.png");
private JLabel star1 = new JLabel(starIcon, JLabel.CENTER);
private JLabel star2 = new JLabel(starIcon, JLabel.CENTER);
private JPanel mapPanel = new JPanel(null);
public static final int WINDOW_WIDTH = 800; // pixels
public static final int WINDOW_HEIGHT = 600;

public Image buffer = null;

public IPanel() {
this.x = 100;
this.y = 100;

mainFrame = new JFrame("Network Map");
mainFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
star1.addMouseMotionListener(new moveIconHandler()); 
star1.setBounds(x,y,starIcon.getIconWidth(), starIcon.getIconHeight());
mapPanel.add(star1);

this.x+=100;
this.y+=100;
star2.addMouseMotionListener(new moveIconHandler()); 
star2.setBounds(x,y,starIcon.getIconWidth(), starIcon.getIconHeight());
mapPanel.add(star2);

mainFrame.add(mapPanel);
mainFrame.setVisible(true);
}


private class moveIconHandler extends MouseMotionAdapter {
public void mouseDragged(MouseEvent e) {
System.out.println("x = " + e.getX() + ", y = " + e.getY()+ "\n");
Component c = e.getComponent();
c.setLocation( c.getX()+e.getX(), c.getY()+e.getY() );

mainFrame.repaint();
} 
}


public static void main(String[] args) {
IPanel mymap = new IPanel();
}

}
