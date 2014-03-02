/**
 Store ship info
 Copyright: Rob Close and Charlie Sun
 Created on: 03/01/2014
 */

import javax.swing.ImageIcon;

public class Ship {

	private String shipName;
	private ImageIcon ico;
	private int ori;

	public Ship(String name, String constantData, int o) {
		shipName = name;
		ico = new ImageIcon(constantData);
		ori=o;
	}
	

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String n) {
		shipName = n;
	}

	public ImageIcon getIcon() {
		return ico;
	}

	public void setImg(String x) {
		ico = new ImageIcon(x);
	}

	public int getOrientation() {
		return ori;
	}

	public void setOrientation(int o) {
		ori = o;
	}
	
}
