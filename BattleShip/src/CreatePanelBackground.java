import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class CreatePanelBackground extends JPanel {
	
	Image image;
	public CreatePanelBackground(){
		
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
	
	
}



