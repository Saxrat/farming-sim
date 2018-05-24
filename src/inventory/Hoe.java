package inventory;

import processing.core.PApplet;
import processing.core.PImage;

public class Hoe extends Inventory {
	PImage hoe;
	String hoename;
	int hoeshifter = 52;
	public Hoe(PApplet p) {
		super(p);
		hoename = "../Assets/hoe.png";
		hoe = window.loadImage(hoename);
	}

	public void drawItem(int height, int width, int heightshifter) {

		window.strokeWeight(5);
		window.stroke(234, 211, 166);

		window.fill(200, 150, 0);
		window.rect(height * 50 + 75, width * 50 + 25 + heightshifter, 50, 50);
		window.strokeWeight(1);
		window.stroke(0);
		
		window.image(hoe, height*50 + hoeshifter, width*50 + heightshifter);

	}
}
