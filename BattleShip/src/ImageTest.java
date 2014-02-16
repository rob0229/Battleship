
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ImageTest extends JPanel {
	
	static Image image;
	public ImageTest(){
		
		
		try{
		image = ImageIO.read(this.getClass().getResource("oceanGrid.png"));
	}
	catch(IOException e){
		System.out.println("Image read error");
		
	}		
	}



public void paintComponent(Graphics g){
		
		g.drawImage(image,0,0,300,300,null);

}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame x = new JFrame();
		x.setPreferredSize(new Dimension(300,300));
		//x.setBackground(image);
		x.pack();
		x.setVisible(true);
	}

}