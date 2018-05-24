package inventory;

import processing.core.PApplet;
import processing.core.PImage;

public class WateringCan extends Inventory{
	String wateringname;
	PImage wateringcan;
	
	public WateringCan(PApplet p) {
		super(p);
		wateringname = "../Assets/wateringcan.png";
		wateringcan= window.loadImage(wateringname);
	}
	
	public void drawItem(int width, int height, int heightShifter) {
		window.strokeWeight(5);
		window.stroke(234, 211, 166);
	
	
	window.fill(200, 150, 0);
	window.rect(width * 50 + 75, height * 50 + 25 + heightShifter, 50, 50);
	window.strokeWeight(0);
	window.image(wateringcan, width*50 + 50, height * 50 + heightShifter);

	}
}
